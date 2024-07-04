package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing")
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothing_id")
    private Long clothing_id;

    @Column(name = "clothing_name")
    private String clothing_name;

    @Column(name = "clothing_description")
    private String clothing_description;

    @Column(name = "deleted")
    private Boolean deleted;


    public Clothing() {
    }

    public Clothing(Long clothing_id, String clothing_name, String clothing_description, Boolean deleted) {
        this.clothing_id = clothing_id;
        this.clothing_name = clothing_name;
        this.clothing_description = clothing_description;
        this.deleted = deleted;
    }

    public Long getClothing_id() {
        return clothing_id;
    }

    public void setClothing_id(Long clothing_id) {
        this.clothing_id = clothing_id;
    }

    public String getClothing_name() {
        return clothing_name;
    }

    public void setClothing_name(String clothing_name) {
        this.clothing_name = clothing_name;
    }

    public String getClothing_description() {
        return clothing_description;
    }

    public void setClothing_description(String clothing_description) {
        this.clothing_description = clothing_description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}




