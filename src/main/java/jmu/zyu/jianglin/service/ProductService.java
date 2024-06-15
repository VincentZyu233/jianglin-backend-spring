package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id); // 根据id查找Product对象

    List<Product> getProductList(); // 获取所有Product对象的列表

    Long addNewProduct(Product product); // 新增Product对象，返回新增对象的id

    void deleteProductById(Long id); // 根据id删除Product对象

    void recoverProductById(Long id); // 根据id恢复被删除的Product对象

    Long updateProductById(Long oldId, Product newProductInfo); // 根据id更新Product对象信息，返回更新对象的id
}
