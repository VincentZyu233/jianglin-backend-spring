package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.ClothingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClothingCategoryRepository extends JpaRepository<ClothingCategory, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_category SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_category SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);



}
