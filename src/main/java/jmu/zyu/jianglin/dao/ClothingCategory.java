package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing_category")
public class ClothingCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothing_category_id")
    private Long clothing_category_id;

    @Column(name = "category_name", unique = true)
    private String category_name;

    @Column(name = "deleted")
    private Boolean deleted = false;

    public ClothingCategory() {
    }

    public ClothingCategory(String category_name) {
        this.category_name = category_name;
        deleted = false;
    }

    public ClothingCategory(Long clothing_category_id, String category_name, Boolean deleted) {
        this.clothing_category_id = clothing_category_id;
        this.category_name = category_name;
        this.deleted = deleted;
    }

    public Long getClothing_category_id() {
        return clothing_category_id;
    }

    public void setClothing_category_id(Long clothing_category_id) {
        this.clothing_category_id = clothing_category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ClothingCategory{" +
                "clothing_category_id=" + clothing_category_id +
                ", category_name='" + category_name + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}