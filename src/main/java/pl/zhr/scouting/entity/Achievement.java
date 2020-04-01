package pl.zhr.scouting.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "achievement")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private int achievementId;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "achievementId")
    private List<Quest> questList;

    public Achievement() {
    }

    public Achievement(String title) {
        this.title = title;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
