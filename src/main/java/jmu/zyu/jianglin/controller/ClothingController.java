package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Clothing;
import jmu.zyu.jianglin.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    ClothingService clothingService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Long> addNewClothing(@RequestPart String clothing_name, @RequestPart String clothing_description){
        return ResponseEntity.ok(
           clothingService.addNewClothing(new Clothing(clothing_name, clothing_description))
        );
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Clothing> getClothingById(@PathVariable Long id){
        return ResponseEntity.ok(
            clothingService.getClothingById(id)
        );
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Clothing>> getClothingList(){
        return ResponseEntity.ok(
                clothingService.getAllClothing()
        );
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteClothingById(@PathVariable Long id){
        if (clothingService.existsById(id) ){
            clothingService.deleteClothingById(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PutMapping("/recover/{id}")
    @ResponseBody
    public ResponseEntity<?> recoverClothingById(@PathVariable Long id){
        if (clothingService.existsById(id) ){
            clothingService.recoverClothingById(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateClothingById(@PathVariable Long id, @RequestBody Clothing newClothingInfo){
        return ResponseEntity.ok(
                clothingService.updateClothingById(id, newClothingInfo)
        );
    }
}
