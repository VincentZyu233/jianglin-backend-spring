package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.ClothingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClothingImageRepository extends JpaRepository<ClothingImage, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_image SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing_image SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);

    @Query(value = "SELECT image_path FROM clothing_image WHERE clothing_image_id = :id", nativeQuery = true)
    String findImagePathById(Long id);

}
