package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.ClothingCategory;
import jmu.zyu.jianglin.service.ClothingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/clothing_category")
public class ClothingCategoryController {
    @Autowired
    ClothingCategoryService clothingCategoryService;

    @PostMapping("/upload/{category_name}")
    @ResponseBody
    public ResponseEntity<?> addNewClothingCategory(@PathVariable String category_name) {
        System.out.println("qwq, Path var: category_name:"+ category_name);
        Map<String, Object> response = new HashMap<>();

        if (clothingCategoryService.existsByName(category_name)) {
            // 获取已有的 ClothingCategory 对象
            ClothingCategory obj = clothingCategoryService.getClothingCategoryByName(category_name);
            response.put("is_new_tag", false);
            response.put("tag_obj", obj);
        } else {
            // 创建一个新的 ClothingCategory 对象
            ClothingCategory newCategory = new ClothingCategory(category_name);
            System.out.println("qwq, newTagObj" + newCategory);
            clothingCategoryService.addNewClothingCategory(newCategory);

            // 获取保存后的对象
            ClothingCategory savedCategory = clothingCategoryService.getClothingCategoryByName(category_name);
            response.put("is_new_tag", true);
            response.put("tag_obj", savedCategory);
        }

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
        if ( clothingCategoryService.existsById(id)){
            clothingCategoryService.deleteClothingCategoryById(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PutMapping("/recover/{id}")
    @ResponseBody
    public ResponseEntity<?> recoverCategoryById(@PathVariable Long id){
        if ( clothingCategoryService.existsById(id) ){
            clothingCategoryService.recoverClothingCategoryById(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateClothingById(@PathVariable Long id, @RequestBody ClothingCategory newClothingCategoryInfo){
        return ResponseEntity.ok(
                clothingCategoryService.updateClothingCategoryById(id, newClothingCategoryInfo)
        );
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(
                clothingCategoryService.getClothingCategoryById(id)
        );
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> getCategoryList(){
        return ResponseEntity.ok(
                clothingCategoryService.getAllClothingCategories()
        );
    }
}
