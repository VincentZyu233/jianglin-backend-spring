package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.ClothingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface ClothingCategoryRepository extends JpaRepository<ClothingCategory, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_category SET deleted = true WHERE clothing_category_id = :clothing_category_id", nativeQuery = true)
    void deleteById(@NonNull Long clothing_category_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_category SET deleted = false WHERE clothing_category_id = :clothing_category_id", nativeQuery = true)
    void recoverById(Long clothing_category_id);

    @Query(value = "SELECT * FROM clothing_category WHERE category_name = :category_name", nativeQuery = true)
    ClothingCategory findByCategoryName(String category_name);

    @Query(value = "SELECT COUNT(*) > 0 FROM clothing_category WHERE category_name = :category_name", nativeQuery = true)
    Long getExistNumberByCategoryName(String category_name);


}
