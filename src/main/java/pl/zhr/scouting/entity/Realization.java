package pl.zhr.scouting.entity;

import javax.persistence.*;

@Entity
@Table(name = "realization")
public class Realization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realization_id")
    private int realizationId;

    @Column(name = "description")
    private String description;

    @Column(name = "job")
    private String job;

    public Realization() {
    }

    public Realization(String description, String job) {
        this.description = description;
        this.job = job;
    }

    public int getRealizationId() {
        return realizationId;
    }

    public void setRealizationId(int realizationId) {
        this.realizationId = realizationId;
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
