package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.ClothingCategory;
import jmu.zyu.jianglin.dao.ClothingCategoryMapping;
import jmu.zyu.jianglin.service.ClothingCategoryMappingService;
import jmu.zyu.jianglin.service.ClothingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/clothing_tag")
public class ClothingCategoryMappingController {

    @Autowired
    ClothingCategoryMappingService clothingCategoryMappingService;

    @Autowired
    ClothingCategoryService clothingCategoryService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> addNewClothingTag(
            @RequestParam Long clothing_id,
            @RequestParam Long category_id) {

        // 创建新的 ClothingCategoryMapping 对象
        ClothingCategoryMapping newMapping = new ClothingCategoryMapping();
        newMapping.setClothing_id(clothing_id);
        newMapping.setCategory_id(category_id);
        newMapping.setDeleted(false); // 默认设置为未删除

        // 调用 service 将实体保存到数据库
        Long savedMappingId = clothingCategoryMappingService
                .addNewClothingCategoryMapping(newMapping);

        ClothingCategoryMapping obj = clothingCategoryMappingService
                .getClothingCategoryMappingById(savedMappingId);

        // 返回响应
        return ResponseEntity.ok(obj);
    }

    @PostMapping("add_tag")
    public ResponseEntity<?> addNewTagMapping(@RequestParam Long clothing_id, @RequestParam String tag_name) {
        Long tag_id = clothingCategoryService.addNewClothingCategory(tag_name);

        // 如果不存在对应的 clothing_id 和 category_id 组合，则添加新的映射并返回 200
        if (clothingCategoryMappingService.countByClothingIdAndCategoryId(clothing_id, tag_id) == 0) {
            clothingCategoryMappingService.addNewClothingCategoryMapping(new ClothingCategoryMapping(clothing_id, tag_id));
            return ResponseEntity.ok("成功添加服装标签");
        }
        // 如果已存在，返回 409 状态码和对应消息
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("标签已经被添加了");
        }
    }


    @DeleteMapping("/purge/{db_id}")
    @ResponseBody
    public ResponseEntity<?> purgeClothingTag(@PathVariable Long db_id) {
        Map<String, Object> response = new HashMap<>();

        if (clothingCategoryMappingService.existsById(db_id)) {
            clothingCategoryMappingService.purgeClothingCategoryMappingById(db_id);
            response.put("result_msg", "Tag db_id " + db_id + " has been purged.");
            return ResponseEntity.ok(response);
        } else {
            response.put("result_msg", "Tag db_id " + db_id + " does not exist.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/find_tags_of/{clothing_id}")
    @ResponseBody
    public ResponseEntity<?> findTagByClothingId(@PathVariable Long clothing_id){
        return ResponseEntity.ok(clothingCategoryMappingService.findAllByClothingId(clothing_id));

//        if (clothingCategoryMappingService.existsByClothingId(clothing_id)  ){
//            return ResponseEntity.ok(clothingCategoryMappingService.findAllByClothingId(clothing_id));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("clothing_id "+clothing_id+"not exists");
//        }
    }


}
