package pl.zhr.scouting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "roles")
    private String roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_data_id")
    private UserData userDataId;

    public User() {
    }

    public User (String username, String password, boolean enabled, String roles) {

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public UserData getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(UserData userData) {
        this.userDataId = userData;
    }

    public void addData(UserData tempUserData) {

        if (userDataId != null) userDataId = null;
        this.userDataId = tempUserData;
    }
}

