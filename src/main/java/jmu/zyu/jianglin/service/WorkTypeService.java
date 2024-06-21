package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.WorkType;

import java.util.List;

public interface WorkTypeService {
    WorkType getTypeById(Long id);

    List<WorkType> getWorkTypeList();

    Long addNewWorkType(WorkType workType);

    void deleteWorkTypeById(Long id);

    void recoverWorkTypeById(Long id);

    Long updateWorkTypeById(Long oldId, WorkType newWorkTypeInfo);

}
