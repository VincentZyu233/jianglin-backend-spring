package jmu.zyu.jianglin.dao;


import jakarta.persistence.*;

@Entity
@Table(name = "clothing_category_mapping")
public class ClothingCategoryMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothing_category_mapping_id")
    private Long clothing_category_mapping_id;

    @Column(name = "clothing_id")
    private Long clothing_id;

    @Column(name = "category_id")
    private Long category_id;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "clothing_id", insertable = false, updatable = false)
    private Clothing clothing;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private ClothingCategory clothing_category;


    public ClothingCategoryMapping() {
    }

    public ClothingCategoryMapping(Long clothing_category_mapping_id, Long clothing_id, Long category_id, Boolean deleted, Clothing clothing, ClothingCategory clothing_category) {
        this.clothing_category_mapping_id = clothing_category_mapping_id;
        this.clothing_id = clothing_id;
        this.category_id = category_id;
        this.deleted = deleted;
        this.clothing = clothing;
        this.clothing_category = clothing_category;
    }

    public Long getClothing_category_mapping_id() {
        return clothing_category_mapping_id;
    }

    public void setClothing_category_mapping_id(Long clothing_category_mapping_id) {
        this.clothing_category_mapping_id = clothing_category_mapping_id;
    }

    public Long getClothing_id() {
        return clothing_id;
    }

    public void setClothing_id(Long clothing_id) {
        this.clothing_id = clothing_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
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

    public ClothingCategory getClothing_category() {
        return clothing_category;
    }

    public void setClothing_category(ClothingCategory clothing_category) {
        this.clothing_category = clothing_category;
    }
}