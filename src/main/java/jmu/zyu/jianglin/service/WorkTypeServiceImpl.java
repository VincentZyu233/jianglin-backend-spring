package jmu.zyu.jianglin.service;

import jmu.zyu.jianglin.dao.WorkType;
import jmu.zyu.jianglin.dao.WorkTypeRepository;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeServiceImpl implements WorkTypeService {

    @Autowired
    private WorkTypeRepository workTypeRepository;


    @Override
    public WorkType getTypeById(Long id) {
        return workTypeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<WorkType> getWorkTypeList() {
        return workTypeRepository.findAll();
    }

    @Override
    public Long addNewWorkType(WorkType workType) {
        return workTypeRepository.save(workType).getId();
    }

    @Override
    public void deleteWorkTypeById(Long id) {
        workTypeRepository.deleteById(id);
    }

    @Override
    public void recoverWorkTypeById(Long id) {
        workTypeRepository.recoverById(id);
    }

    @Override
    public Long updateWorkTypeById(Long oldId, WorkType newWorkTypeInfo) {
        WorkType workTypeInDb = workTypeRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id" + oldId + " does not exist"));

        workTypeInDb.setCategory_name(newWorkTypeInfo.getCategory_name());
        workTypeInDb.setCategory_description(newWorkTypeInfo.getCategory_description());

        workTypeRepository.save(workTypeInDb);

        return workTypeInDb.getId();
    }

}
