package pl.zhr.scouting.entity;

import javax.persistence.*;

@Entity
@Table(name = "questes")
public class Achivment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achivment_id")
    private int achivmentId;

    @Column(name = "title")
    private String title;

    public Achivment() {
    }

    public Achivment(String title) {
        this.title = title;
    }

    public int getAchivmentId() {
        return achivmentId;
    }

    public void setAchivmentId(int achivmentId) {
        this.achivmentId = achivmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
