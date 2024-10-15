package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing_image")
public class ClothingImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothing_image_id")
    private Long clothing_image_id;

    @Column(name = "image_path")
    private String image_path;

    @Column(name = "deleted")
    private Boolean deleted;

    public ClothingImage() {
    }

    public ClothingImage(String image_path) {
        this.image_path = image_path;
    }

    public ClothingImage(Long clothing_image_id, String image_path, Boolean deleted) {
        this.clothing_image_id = clothing_image_id;
        this.image_path = image_path;
        this.deleted = deleted;
    }

    public Long getClothing_image_id() {
        return clothing_image_id;
    }

    public void setClothing_image_id(Long clothing_image_id) {
        this.clothing_image_id = clothing_image_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}