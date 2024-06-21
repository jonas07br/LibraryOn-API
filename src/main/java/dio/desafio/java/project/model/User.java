package dio.desafio.java.project.model;


import dio.desafio.java.project.dto.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name="tab_user")
public class User {

    @Id
    @Column(name="email_user")
    String email;

    @Column(name="name_user")
    String name;

    @Column(name="password")
    String password;

    public User(UserDTO userDTO) {
        this.email = userDTO.email();
        this.name = userDTO.name();
        this.password = userDTO.password();
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
