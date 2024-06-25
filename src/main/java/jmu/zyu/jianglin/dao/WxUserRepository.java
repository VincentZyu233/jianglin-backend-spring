package jmu.zyu.jianglin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUserRepository extends JpaRepository<WxUser, String> {

}
