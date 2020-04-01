package pl.zhr.scouting.entity;

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
}
