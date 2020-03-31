package pl.zhr.scouting.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patrol")
public class Patrol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patrol_id")
    private int patrolId;

    @Column(name = "patrol_name")
    private String patrolName;

    @OneToMany(mappedBy = "patrolId")
    private List<UserData> usersData;

    public Patrol() {
    }

    public int getPatrolId() {
        return patrolId;
    }

    public void setPatrolId(int patrolId) {
        this.patrolId = patrolId;
    }

    public String getPatrolName() {
        return patrolName;
    }

    public void setPatrolName(String patrolName) {
        this.patrolName = patrolName;
    }

    public List<UserData> getUsersData() {
        return usersData;
    }

    public void setUsersData(List<UserData> users) {
        this.usersData = users;
    }

    public void addUser(UserData tempUserData) {

        if(usersData == null) usersData = new ArrayList<>();
        usersData.add(tempUserData);
        tempUserData.setPatrolId(this);
    }
}

