package jmu.zyu.jianglin.dao;

import jakarta.persistence.*;

@Entity
@Table(name="banner")
public class Banner {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    @Lob
    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public String getImagePath() {return imagePath;}

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isDeleted() {return deleted;}

    public void setDeleted(boolean deleted) {this.deleted = deleted;}
}
