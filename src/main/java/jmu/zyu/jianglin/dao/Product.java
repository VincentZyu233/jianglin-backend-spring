package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Long getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public void setId(Long id) {this.id = id;}

    public String getImagePath() {return imagePath;}

    public void setImagePath(String imagePath) {this.imagePath = imagePath;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {return deleted;}

    public void setDeleted(boolean deleted) {this.deleted = deleted;}
}
