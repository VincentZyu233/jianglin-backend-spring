package jmu.zyu.jianglin.jparepo;

import jmu.zyu.jianglin.dao.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUserRepository extends JpaRepository<WxUser, String> {

    @Query(value = "SELECT wx_avatar_path FROM wx_user WHERE open_id = :open_id", nativeQuery = true)
    String findAvatarImagePathByOpenId(String open_id);
}
