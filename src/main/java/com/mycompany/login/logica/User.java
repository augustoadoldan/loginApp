
package com.mycompany.login.logica;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private String userPw;
    @ManyToOne
    @JoinColumn(name="fk_rol")
    private Rol singleRol;

    public User() {
    }

    public User(Long id, String userName, String userPw, Rol singleRol) {
        this.id = id;
        this.userName = userName;
        this.userPw = userPw;
        this.singleRol = singleRol;
    }

    public Rol getSingleRol() {
        return singleRol;
    }

    public void setSingleRol(Rol singleRol) {
        this.singleRol = singleRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    
}
