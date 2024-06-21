package jmu.zyu.jianglin.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkType, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE work_type SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE work_type SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);

}
