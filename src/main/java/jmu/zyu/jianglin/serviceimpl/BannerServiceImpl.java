package jmu.zyu.jianglin.serviceimpl;

import jmu.zyu.jianglin.dao.Banner;
import jmu.zyu.jianglin.jparepo.BannerRepository;
import jmu.zyu.jianglin.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getBannerById(Long id) {
        return bannerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Banner> getBannerList() {
        return bannerRepository.findAll();
    }

    @Override
    public String getBannerImagePathById(Long id){
        return bannerRepository.findImagePathById(id);
    }

    @Override
    public Long addNewBanner(Banner banner) {
        return bannerRepository.save(banner).getId();
    }

    @Override
    public void deleteBannerById(Long id) {
        bannerRepository.deleteById(id);
    }

    @Override
    public void recoverBannerById(Long id) {
        bannerRepository.recoverById(id);
    }

    @Override
    public Long updateBannerById(Long oldId, Banner newBannerInfo) {
        Banner bannerInDb = bannerRepository.findById(oldId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldId + " does not exist"));

        bannerInDb.setText(newBannerInfo.getText());
        bannerInDb.setImage_path(newBannerInfo.getImage_path());

        bannerRepository.save(bannerInDb);

        return bannerInDb.getId();
    }
}
