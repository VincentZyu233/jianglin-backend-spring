package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClothingRepository extends JpaRepository<Clothing, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing SET deleted = true WHERE clothing_id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clothing SET deleted = false WHERE clothing_id = :id", nativeQuery = true)
    void recoverById(Long id);

}
