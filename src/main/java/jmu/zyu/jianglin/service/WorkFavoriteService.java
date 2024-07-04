package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.WorkFavorite;

import java.util.List;

public interface WorkFavoriteService {

    WorkFavorite getWorkFavoriteById(Long id); // 根据id查找work_favorite对象

    List<WorkFavorite> getWorkFavoriteList(); // 获取所有work_favorite对象的列表

    List<WorkFavorite> getWorkFavoriteListByUserOpenId(String userOpenId); // 根据用户open_id获取work_favorite对象的列表

    List<WorkFavorite> checkDuplicate(String user_open_id, Long work_id);

    Long addNewWorkFavorite(WorkFavorite workFavorite); // 新增work_favorite对象，返回新增对象的id

    void deleteWorkFavoriteById(Long id); // 根据id删除work_favorite对

    void removeWorkFavoriteByUserOpenIdAndWorkId(String user_open_id, Long work_id);

    Long updateWorkFavoriteById(Long id, WorkFavorite updatedWorkFavorite); // 根据id更新work_favorite对象信息，返回更新对象的id
}