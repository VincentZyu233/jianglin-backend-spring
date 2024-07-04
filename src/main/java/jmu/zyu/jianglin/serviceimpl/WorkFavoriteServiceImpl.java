package jmu.zyu.jianglin.serviceimpl;

import jmu.zyu.jianglin.dao.WorkFavorite;
import jmu.zyu.jianglin.jparepo.WorkFavoriteRepository;
import jmu.zyu.jianglin.service.WorkFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WorkFavoriteServiceImpl implements WorkFavoriteService {

    @Autowired
    private WorkFavoriteRepository workFavoriteRepository;

    @Override
    public WorkFavorite getWorkFavoriteById(Long id) {
        Optional<WorkFavorite> workfavorite = workFavoriteRepository.findById(id);
        return workfavorite.orElse(null);
    }

    @Override
    public List<WorkFavorite> getWorkFavoriteList() {
        return workFavoriteRepository.findAll();
    }

    @Override
    public List<WorkFavorite> getWorkFavoriteListByUserOpenId(String user_open_id) {
        return workFavoriteRepository.findByUserOpenId(user_open_id);
    }

    @Override
    public List<WorkFavorite> checkDuplicate(String user_open_id, Long work_id) {
        return workFavoriteRepository.findByUserOpenIdAndWorkId(user_open_id,work_id);
    }

    @Override
    public Long addNewWorkFavorite(WorkFavorite workFavorite) {
        WorkFavorite savedWorkFavorite = workFavoriteRepository.save(workFavorite);
        return savedWorkFavorite.getId();
    }

    @Override
    public void deleteWorkFavoriteById(Long id) {
        workFavoriteRepository.deleteById(id);
    }

    @Override
    public void removeWorkFavoriteByUserOpenIdAndWorkId(String user_open_id, Long work_id) {
        workFavoriteRepository.removeByUserOpenIdAndWorkId(user_open_id, work_id);
    }

    @Override
    public Long updateWorkFavoriteById(Long oldId, WorkFavorite updatedWorkFavorite) {
        Optional<WorkFavorite> existingWorkFavorite = workFavoriteRepository.findById(oldId);
        if ( existingWorkFavorite.isEmpty() ){
            return null;
        }

        WorkFavorite workFavorite = existingWorkFavorite.get();

        workFavorite.setWork_id(updatedWorkFavorite.getWork_id());
        workFavorite.setUser_open_id(updatedWorkFavorite.getUser_open_id());

        workFavoriteRepository.save(workFavorite);
        return workFavorite.getId();
    }
}
