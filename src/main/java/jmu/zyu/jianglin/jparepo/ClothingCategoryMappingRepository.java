package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.ClothingCategoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ClothingCategoryMappingRepository extends JpaRepository<ClothingCategoryMapping, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_category_mapping SET deleted = true WHERE clothing_category_mapping_id = :clothing_category_mapping_id", nativeQuery = true)
    void deleteById(@NonNull Long clothing_category_mapping_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_category_mapping SET deleted = false WHERE clothing_category_mapping_id = :clothing_category_mapping_id", nativeQuery = true)
    void recoverById(Long clothing_category_mapping_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM clothing_category_mapping WHERE clothing_category_mapping_id = :clothing_category_mapping_id", nativeQuery = true)
    void purgeById(Long clothing_category_mapping_id);

    @Transactional
    @Query(value = "SELECT * FROM clothing_category_mapping WHERE clothing_id = :clothing_id", nativeQuery = true)
    /* AND deleted = false*/
    List<ClothingCategoryMapping> findAllByClothingId(Long clothing_id);

    @Transactional
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM clothing_category_mapping WHERE clothing_id = :clothing_id", nativeQuery = true)
    Long getExistNumberByClothingId(@NonNull Long clothing_id);

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM clothing_category_mapping WHERE clothing_id = :clothing_id AND category_id = :category_id", nativeQuery = true)
    Long countByClothingIdAndCategoryId(@NonNull Long clothing_id, @NonNull Long category_id);
}
