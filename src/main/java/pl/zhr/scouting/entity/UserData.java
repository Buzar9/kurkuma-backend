package pl.zhr.scouting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_data_id")
    private int userDataId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @OneToOne(mappedBy = "userDataId",
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patrol_id")
    private Patrol patrolId;

    @Column(name = "patrol_name")
    private String patrolName;

    public UserData() {
    }

    public UserData(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(int userDataId) {
        this.userDataId = userDataId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = user.getUsername();
    }

    public Patrol getPatrolId() {
        return patrolId;
    }

    public void setPatrolId(Patrol patrol) {
        if(patrolId != null) {
            patrolId = null;
        }
        this.patrolId = patrol;
    }

    public String getPatrolName() {
        return patrolName;
    }

    public void setPatrolName(Patrol patrol) {
        if (patrol == null) {
            this.patrolName = null;
        } else {
            this.patrolName = patrol.getPatrolName();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

