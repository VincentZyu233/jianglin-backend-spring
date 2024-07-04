package jmu.zyu.jianglin.jparepo;

import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE appointment SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE appointment SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);




}
