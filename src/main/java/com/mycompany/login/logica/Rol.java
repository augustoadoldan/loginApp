
package com.mycompany.login.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {
        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private int id;
        private String rolName;
        private String description;
        @OneToMany(mappedBy="singleRol")
        private List<User> usersList;

    public Rol() {
    }

    public Rol(int id, String rolName, String description, List<User> usersList) {
        this.id = id;
        this.rolName = rolName;
        this.description = description;
        this.usersList = usersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
        
        
}
