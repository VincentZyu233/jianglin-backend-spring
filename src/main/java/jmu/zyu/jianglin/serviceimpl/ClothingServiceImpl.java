package jmu.zyu.jianglin.serviceimpl;

import jmu.zyu.jianglin.dao.Clothing;
import jmu.zyu.jianglin.dao.ClothingCategory;
import jmu.zyu.jianglin.dao.ClothingImage;
import jmu.zyu.jianglin.dao.ClothingCategoryMapping;
import jmu.zyu.jianglin.dao.ClothingImageMapping;
import jmu.zyu.jianglin.jparepo.ClothingCategoryMappingRepository;
import jmu.zyu.jianglin.jparepo.ClothingCategoryRepository;
import jmu.zyu.jianglin.jparepo.ClothingImageMappingRepository;
import jmu.zyu.jianglin.jparepo.ClothingImageRepository;
import jmu.zyu.jianglin.jparepo.ClothingRepository;
import jmu.zyu.jianglin.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingServiceImpl implements ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    @Override
    public Clothing getClothingById(Long id) {
        return clothingRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Clothing> getAllClothing() {
        return clothingRepository.findAll();
    }

    @Override
    public Long addNewClothing(Clothing clothing) {
        return clothingRepository.save(clothing).getClothing_id();
    }

    @Override
    public void deleteClothingById(Long id) {
        clothingRepository.deleteById(id);
    }

    @Override
    public void recoverClothingById(Long id) {
        clothingRepository.recoverById(id);
    }

    @Override
    public Long updateClothingById(Long oldId, Clothing newClothingInfo) {
        Clothing clothingInDb = clothingRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldId + " does not exist"));

        clothingInDb.setClothing_name(newClothingInfo.getClothing_name());
        clothingInDb.setClothing_description(newClothingInfo.getClothing_description());

        clothingRepository.save(clothingInDb);

        return clothingInDb.getClothing_id();
    }
}

