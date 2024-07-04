package jmu.zyu.jianglin.jparepo;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;
import jmu.zyu.jianglin.dao.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE message SET deleted = true WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE message SET deleted = false WHERE id = :id", nativeQuery = true)
    void recoverById(Long id);

    @Query(value = "SELECT * FROM message WHERE deleted = false", nativeQuery = true)
    @NonNull
    List<Message> findAllNotDeleted();
}
