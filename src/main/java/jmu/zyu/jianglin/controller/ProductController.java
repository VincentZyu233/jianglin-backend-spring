package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Product;
import jmu.zyu.jianglin.service.FileService;
import jmu.zyu.jianglin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestPart ("file") MultipartFile file,
            @RequestPart String name,
            @RequestPart String description
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择一个文件进行上传。");
        }

        try {
            String uploadFile = fileService.uploadFile(file, name, false);
            return ResponseEntity.ok(productService.addNewProduct(new Product(name, uploadFile, description)));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("上传失败。" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        System.out.println("ovo ovo" + id);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<?> getProductImageById(@PathVariable Long id) throws IOException {
        System.out.println("ovo1 in getProductImageById(): getProductImagePathById(id)" + productService.getProductImagePathById(id) );

        byte[] imageBytes = fileService.getImageByteArray(productService.getProductImagePathById(id));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        // 返回包含图片字节数组的 ResponseEntity
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);

    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Product>> getProductList(){
        return ResponseEntity.ok(productService.getProductList());
    }

    @GetMapping("/all/{descriptionName}")


    @PostMapping()
    @ResponseBody
    public ResponseEntity<Long> addNewProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addNewProduct(product));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PutMapping("/recover/{id}")
    @ResponseBody
    public void recoverProductById(@PathVariable Long id){
        productService.recoverProductById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Long> updateProductById(@PathVariable Long id, @RequestBody Product newProductInfo){
        return ResponseEntity.ok(productService.updateProductById(id, newProductInfo));
    }
}
