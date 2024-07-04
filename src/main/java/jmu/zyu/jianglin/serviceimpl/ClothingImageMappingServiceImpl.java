package jmu.zyu.jianglin.serviceimpl;

import jmu.zyu.jianglin.dao.ClothingCategoryMapping;
import jmu.zyu.jianglin.dao.ClothingImageMapping;
import jmu.zyu.jianglin.jparepo.ClothingCategoryMappingRepository;
import jmu.zyu.jianglin.jparepo.ClothingImageMappingRepository;
import jmu.zyu.jianglin.service.ClothingImageMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingImageMappingServiceImpl implements ClothingImageMappingService {

    @Autowired
    private ClothingImageMappingRepository clothingImageMappingRepository;

    @Override
    public ClothingImageMapping getClothingImageMappingById(Long id) {
        return clothingImageMappingRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<ClothingImageMapping> getAllClothingImageMappings() {
        return clothingImageMappingRepository.findAll();
    }

    @Override
    public Long addNewClothingImageMapping(ClothingImageMapping mapping) {
        return clothingImageMappingRepository.save(mapping).getClothing_image_mapping_id();
    }

    @Override
    public void deleteClothingImageMappingById(Long id) {
        clothingImageMappingRepository.deleteById(id);
    }

    @Override
    public void recoverClothingImageMappingById(Long id) {
        clothingImageMappingRepository.recoverById(id);
    }

    @Override
    public Long updateClothingImageMappingById(Long oldId, ClothingImageMapping newMappingInfo) {
        ClothingImageMapping mappingInDb = clothingImageMappingRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldId + " does not exist"));

        mappingInDb.setClothing_id(newMappingInfo.getClothing_id());
        mappingInDb.setImage_id(newMappingInfo.getImage_id());

        clothingImageMappingRepository.save(mappingInDb);

        return mappingInDb.getClothing_image_mapping_id();
    }
}
