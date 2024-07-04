package jmu.zyu.jianglin.serviceimpl;


import jmu.zyu.jianglin.dao.ClothingImage;
import jmu.zyu.jianglin.jparepo.ClothingImageRepository;
import jmu.zyu.jianglin.service.ClothingImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingImageServiceImpl implements ClothingImageService {

    @Autowired
    private ClothingImageRepository clothingImageRepository;

    @Override
    public ClothingImage getClothingImageById(Long id) {
        return clothingImageRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<ClothingImage> getAllClothingImages() {
        return clothingImageRepository.findAll();
    }

    @Override
    public Long addNewClothingImage(ClothingImage clothingImage) {
        return clothingImageRepository.save(clothingImage).getClothing_image_id();
    }

    @Override
    public void deleteClothingImageById(Long id) {
        clothingImageRepository.deleteById(id);
    }

    @Override
    public void recoverClothingImageById(Long id) {
        clothingImageRepository.recoverById(id);
    }

    @Override
    public Long updateClothingImageById(Long oldId, ClothingImage newImageInfo) {
        ClothingImage imageInDb = clothingImageRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldId + " does not exist"));

        imageInDb.setImage_path(newImageInfo.getImage_path());

        clothingImageRepository.save(imageInDb);

        return imageInDb.getClothing_image_id();
    }
}