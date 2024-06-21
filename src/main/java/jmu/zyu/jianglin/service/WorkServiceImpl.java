package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Work;
import jmu.zyu.jianglin.dao.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{

    @Autowired
    private WorkRepository workRepository;


    @Override
    public Work getWorkById(Long id) {
        return workRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public String getWorkImagePathById(Long id) {
        return workRepository.findImagePathById(id);
    }

    @Override
    public List<Work> getWorkList() {
        return workRepository.findAll();
    }



    @Override
    public Long addNewWork(Work work) {
        return workRepository.save(work).getId();
    }

    @Override
    public void deleteWorkById(Long id) {
        workRepository.deleteById(id);
    }

    @Override
    public void recoverWorkById(Long id) {
        workRepository.recoverById(id);
    }

    @Override
    public Long updateWorkById(Long oldId, Work newWorkInfo) {
        Work workInDb = workRepository.findById(oldId).
                orElseThrow(() -> new IllegalArgumentException("id" + oldId + "does not "));

        workInDb.setImage_path(newWorkInfo.getImage_path());
        workInDb.setWork_name(newWorkInfo.getWork_name());
        workInDb.setType_id(newWorkInfo.getType_id());

        workRepository.save(workInDb);

        return workInDb.getId();
    }
}
