package jmu.zyu.jianglin.controller;

import jmu.zyu.jianglin.dao.Product;
import jmu.zyu.jianglin.service.ProductService;
import jmu.zyu.jianglin.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    @ResponseBody
    public Response<Product> getProductById(@PathVariable Long id){
        System.out.println("ovo ovo" + id);
        return Response.newSuccess(productService.getProductById(id));
    }

    @GetMapping("/product/all")
    @ResponseBody
    public Response<List<Product>> getProductList(){
        return Response.newSuccess(productService.getProductList());
    }

    @PostMapping("/product")
    @ResponseBody
    public Response<Long> addNewProduct(@RequestBody Product product){
        return Response.newSuccess(productService.addNewProduct(product));
    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PutMapping("/product/recover/{id}")
    @ResponseBody
    public void recoverProductById(@PathVariable Long id){
        productService.recoverProductById(id);
    }

    @PutMapping("/product/update/{id}")
    @ResponseBody
    public Response<Long> updateProductById(@PathVariable Long id, @RequestBody Product newProductInfo){
        return Response.newSuccess(productService.updateProductById(id, newProductInfo));
    }
}
