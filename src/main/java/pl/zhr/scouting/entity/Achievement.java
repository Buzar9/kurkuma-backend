package pl.zhr.scouting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "achievementId",
                cascade = CascadeType.ALL)
    private List<Quest> questList;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_achievement_open",
            joinColumns = @JoinColumn(name = "achievement_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> openUserList;

    @ManyToMany
    @JoinTable(
            name = "user_achievement_finished",
            joinColumns = @JoinColumn(name = "achievement_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> finishedUserList;

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

    public List<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }

    public void addQuest(Quest theQuest) {

        if(questList == null) questList = new ArrayList<>();
        questList.add(theQuest);
        theQuest.setAchievementId(this);
    }

    public List<User> getOpenUserList() {
        return openUserList;
    }

    public void setOpenUserList(List<User> userList) {
        this.openUserList = userList;
    }
}
