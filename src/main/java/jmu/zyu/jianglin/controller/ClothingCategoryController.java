package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.ClothingCategory;
import jmu.zyu.jianglin.service.ClothingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clothing_category")
public class ClothingCategoryController {
    @Autowired
    ClothingCategoryService clothingCategoryService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> addNewClothingCategory(@RequestPart String category_name){
        return ResponseEntity.ok(
            clothingCategoryService.addNewClothingCategory( new ClothingCategory(category_name))
        );
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
