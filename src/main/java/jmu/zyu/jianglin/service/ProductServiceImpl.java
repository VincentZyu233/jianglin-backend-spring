package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Product;
import jmu.zyu.jianglin.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Long id){
        System.out.println("ovo2 ovo2" + id);
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Long addNewProduct(Product product) {
        return productRepository.save(product).getId();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void recoverProductById(Long id) {
        productRepository.recoverById(id);
    }

    @Override
    public Long updateProductById(Long oldId, Product newProductInfo) {
        Product productInDb = productRepository.findById(oldId).orElseThrow(() -> new IllegalArgumentException("id" + oldId + "does not exist"));

        productInDb.setDescription(newProductInfo.getDescription());
        productInDb.setImageData(newProductInfo.getImageData());

        productRepository.save(productInDb);

        return productInDb.getId();
    }


}
