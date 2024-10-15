package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.ClothingImageMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClothingImageMappingRepository extends JpaRepository<ClothingImageMapping, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_image_mapping SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_image_mapping SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);

    @Transactional
    @Query(value = "SELECT * FROM clothing_image_mapping WHERE clothing_id = :clothing_id", nativeQuery = true)
    List<ClothingImageMapping> getImagesOfThisClothing(Long clothing_id);

}
