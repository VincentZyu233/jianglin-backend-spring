package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing_image_mapping")
public class ClothingImageMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothing_image_mapping_id")
    private Long clothing_image_mapping_id;

    @Column(name = "clothing_id")
    private Long clothing_id;

    @Column(name = "image_id")
    private Long image_id;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "clothing_id", insertable = false, updatable = false)
    private Clothing clothing;

    @ManyToOne
    @JoinColumn(name = "image_id", insertable = false, updatable = false)
    private ClothingImage clothingImage;

    public ClothingImageMapping() {
    }

    public ClothingImageMapping(Long clothing_image_mapping_id, Long clothing_id, Long image_id, Boolean deleted, Clothing clothing, ClothingImage clothingImage) {
        this.clothing_image_mapping_id = clothing_image_mapping_id;
        this.clothing_id = clothing_id;
        this.image_id = image_id;
        this.deleted = deleted;
        this.clothing = clothing;
        this.clothingImage = clothingImage;
    }

    public Long getClothing_image_mapping_id() {
        return clothing_image_mapping_id;
    }

    public void setClothing_image_mapping_id(Long clothing_image_mapping_id) {
        this.clothing_image_mapping_id = clothing_image_mapping_id;
    }

    public Long getClothing_id() {
        return clothing_id;
    }

    public void setClothing_id(Long clothing_id) {
        this.clothing_id = clothing_id;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public ClothingImage getClothingImage() {
        return clothingImage;
    }

    public void setClothingImage(ClothingImage clothingImage) {
        this.clothingImage = clothingImage;
    }
}