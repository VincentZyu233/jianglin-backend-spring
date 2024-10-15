package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.ClothingImage;
import jmu.zyu.jianglin.dao.ClothingImageMapping;
import jmu.zyu.jianglin.service.ClothingImageMappingService;
import jmu.zyu.jianglin.service.ClothingImageService;
import jmu.zyu.jianglin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/clothing_image")
public class ClothingImageController {

    @Autowired
    ClothingImageService clothingImageService;

    @Autowired
    ClothingImageMappingService clothingImageMappingService;

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestPart ("file")MultipartFile file,
            @RequestParam Long clothing_id
    ){
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择一个文件进行上传。");
        }

        try{
            String uploadFile = fileService.uploadFile(file,"clothing_image","clothing");
            ClothingImage clothingImage = new ClothingImage(uploadFile);
            clothingImageService.addNewClothingImage(clothingImage);
            Long image_id = clothingImage.getClothing_image_id();

            ClothingImageMapping mappingObj = new ClothingImageMapping(clothing_id, image_id);
            clothingImageMappingService.addNewClothingImageMapping( mappingObj );

            return ResponseEntity.ok(mappingObj);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("上传失败。" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getClothingImageObjById(@PathVariable Long id){
        return ResponseEntity.ok(clothingImageService.getClothingImageById(id));
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> getClothingImageList(){
        return ResponseEntity.ok( clothingImageService.getAllClothingImages() );
    }

    @GetMapping("images_of_clothing/{clothing_id}")
    @ResponseBody
    public ResponseEntity<?> getImagesOfThisClothing(@PathVariable Long clothing_image){
        return ResponseEntity.ok( clothingImageMappingService.getImagesOfThisClothing(clothing_image) );
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<?> getClothingImageById(@PathVariable Long id) throws IOException{
        byte[] imageBytes =
                fileService.getImageByteArray(
                        clothingImageService.getClothingImagePathById(id)
                );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        // 返回包含图片字节数组的 ResponseEntity
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

}
