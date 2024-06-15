package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Product;
import jmu.zyu.jianglin.service.FileUploadService;
import jmu.zyu.jianglin.service.ProductService;
import jmu.zyu.jianglin.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    FileUploadService uploadService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestPart ("file") MultipartFile file,
            @RequestPart String name
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择一个文件进行上传。");
        }

        try {
            String uploadFile = uploadService.uploadFile(file, name, false);
            return ResponseEntity.ok(productService.addNewProduct(new Product(name, uploadFile)));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("上传失败。" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Response<Product> getProductById(@PathVariable Long id){
        System.out.println("ovo ovo" + id);
        return Response.newSuccess(productService.getProductById(id));
    }

    @GetMapping("/all")
    @ResponseBody
    public Response<List<Product>> getProductList(){
        return Response.newSuccess(productService.getProductList());
    }

    @PostMapping()
    @ResponseBody
    public Response<Long> addNewProduct(@RequestBody Product product){
        return Response.newSuccess(productService.addNewProduct(product));
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
    public Response<Long> updateProductById(@PathVariable Long id, @RequestBody Product newProductInfo){
        return Response.newSuccess(productService.updateProductById(id, newProductInfo));
    }
}
