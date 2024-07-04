package jmu.zyu.jianglin.serviceimpl;


import jmu.zyu.jianglin.dao.ClothingCategoryMapping;
import jmu.zyu.jianglin.jparepo.ClothingCategoryMappingRepository;
import jmu.zyu.jianglin.service.ClothingCategoryMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingCategoryMappingServiceImpl implements ClothingCategoryMappingService {

    @Autowired
    private ClothingCategoryMappingRepository clothingCategoryMappingRepository;

    @Override
    public ClothingCategoryMapping getClothingCategoryMappingById(Long id) {
        return clothingCategoryMappingRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<ClothingCategoryMapping> getAllClothingCategoryMappings() {
        return clothingCategoryMappingRepository.findAll();
    }

    @Override
    public Long addNewClothingCategoryMapping(ClothingCategoryMapping mapping) {
        return clothingCategoryMappingRepository.save(mapping).getClothing_category_mapping_id();
    }

    @Override
    public void deleteClothingCategoryMappingById(Long id) {
        clothingCategoryMappingRepository.deleteById(id);
    }

    @Override
    public void recoverClothingCategoryMappingById(Long id) {
        clothingCategoryMappingRepository.recoverById(id);
    }

    @Override
    public Long updateClothingCategoryMappingById(Long oldId, ClothingCategoryMapping newMappingInfo) {
        ClothingCategoryMapping mappingInDb = clothingCategoryMappingRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldId + " does not exist"));

        mappingInDb.setClothing_id(newMappingInfo.getClothing_id());
        mappingInDb.setCategory_id(newMappingInfo.getCategory_id());

        clothingCategoryMappingRepository.save(mappingInDb);

        return mappingInDb.getClothing_category_mapping_id();
    }
}
