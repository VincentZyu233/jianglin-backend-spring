package jmu.zyu.jianglin.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE work SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE work SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);

    @Query(value = "SELECT image_path FROM work WHERE id = :id", nativeQuery = true)
    String findImagePathById(Long id);

}
