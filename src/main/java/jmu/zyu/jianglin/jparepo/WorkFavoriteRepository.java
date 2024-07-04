package jmu.zyu.jianglin.jparepo;

import jmu.zyu.jianglin.dao.WorkFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WorkFavoriteRepository extends JpaRepository<WorkFavorite, Long> {

    @Query( value = "SELECT * FROM work_favorite WHERE user_open_id = :user_open_id", nativeQuery = true)
    List<WorkFavorite> findByUserOpenId(String user_open_id);

    @Query("SELECT wf FROM WorkFavorite wf WHERE wf.user_open_id = :user_open_id AND wf.work_id = :work_id")
    List<WorkFavorite> findByUserOpenIdAndWorkId(String user_open_id, Long work_id);

    @Modifying
    @Query("DELETE FROM WorkFavorite wf WHERE wf.user_open_id = :user_open_id AND wf.work_id = :work_id")
    void removeByUserOpenIdAndWorkId(String user_open_id, Long work_id);

}
