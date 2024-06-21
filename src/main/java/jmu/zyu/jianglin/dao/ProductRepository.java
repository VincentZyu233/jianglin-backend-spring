package jmu.zyu.jianglin.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);

    @Query(value = "SELECT image_path FROM product WHERE id = :id", nativeQuery = true)
    String findImagePathById(Long id);

    @Query(value = "SELECT * FROM product where description = :description", nativeQuery = true)
    List<Product> findProductByDescription(String description);

}
