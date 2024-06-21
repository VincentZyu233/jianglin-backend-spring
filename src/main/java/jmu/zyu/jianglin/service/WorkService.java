package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.Work;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

public interface WorkService {

    Work getWorkById(Long id);

    String getWorkImagePathById(Long id);

    List<Work> getWorkList();

    Long addNewWork(Work work);

    void deleteWorkById(Long id);

    void recoverWorkById(Long id);

    Long updateWorkById(Long oldId, Work newWorkInfo);


}
