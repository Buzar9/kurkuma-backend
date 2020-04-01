package pl.zhr.scouting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "quest")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quests_id")
    private int questsId;

    @Column(name = "description")
    private String description;

    @Column(name = "job")
    private String job;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievementId;

    @Column(name = "title")
    private String title;

    public Quest() {
    }

    public Quest(String description, String job) {
        this.description = description;
        this.job = job;
    }

    public int getQuestsId() {
        return questsId;
    }

    public void setQuestsId(int questsId) {
        this.questsId = questsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Achievement getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Achievement achievement) {
        if(achievementId != null) {
            achievementId = null;
        }
        this.achievementId = achievement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(Achievement achievement) {
        if (achievement == null) {
            this.title = null;
        } else {
            this.title = achievement.getTitle();
        }
    }
}
