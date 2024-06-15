package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public byte[] getImageData() {return imageData;}

    public void setImageData(byte[] imageData) {this.imageData = imageData;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {return deleted;}

    public void setDeleted(boolean deleted) {this.deleted = deleted;}
}
