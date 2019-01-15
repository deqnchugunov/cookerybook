package cookerybook.entities;

import cookerybook.entities.base.EntityModel;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements EntityModel {

    private int id;
    private String username;
    private String password;

    public User() {}

    @Override
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
