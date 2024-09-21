package jmu.zyu.jianglin.serviceimpl;


import jmu.zyu.jianglin.dao.ClothingCategory;
import jmu.zyu.jianglin.jparepo.ClothingCategoryRepository;
import jmu.zyu.jianglin.service.ClothingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingCategoryServiceImpl implements ClothingCategoryService {

    @Autowired
    private ClothingCategoryRepository clothingCategoryRepository;

    @Override
    public ClothingCategory getClothingCategoryById(Long id) {
        return clothingCategoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public ClothingCategory getClothingCategoryByName(String TagName) {
        return clothingCategoryRepository.findByCategoryName(TagName);
    }

    @Override
    public List<ClothingCategory> getAllClothingCategories() {
        return clothingCategoryRepository.findAll();
    }

    @Override
    public Long addNewClothingCategory(ClothingCategory clothingCategory) {
        return clothingCategoryRepository.save(clothingCategory).getClothing_category_id();
    }

    @Override
    public void deleteClothingCategoryById(Long id) {
        clothingCategoryRepository.deleteById(id);
    }

    @Override
    public void recoverClothingCategoryById(Long id) {
        clothingCategoryRepository.recoverById(id);
    }

    @Override
    public Long updateClothingCategoryById(Long oldId, ClothingCategory newCategoryInfo) {
        ClothingCategory categoryInDb = clothingCategoryRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldId + " does not exist"));

        categoryInDb.setCategory_name(newCategoryInfo.getCategory_name());

        clothingCategoryRepository.save(categoryInDb);

        return categoryInDb.getClothing_category_id();
    }

    @Override
    public boolean existsById(Long id) {
        return clothingCategoryRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String TagName) {
        return clothingCategoryRepository.getExistNumberByCategoryName(TagName) > 0;
    }
}
