package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name="banner")
public class Banner {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    @Column(name = "image_path", nullable = false)
    private String image_path;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Banner(String text, String image_path) {
        this.text = text;
        this.image_path = image_path;
    }

    public Banner() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
