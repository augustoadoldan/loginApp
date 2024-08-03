
package com.mycompany.login.persistence;

import com.mycompany.login.logica.Rol;
import com.mycompany.login.logica.User;
import com.mycompany.login.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {
    UserJpaController jpaUser = new UserJpaController();
    RolJpaController jpaRol = new RolJpaController();

    public List<User> bringUsers() {
        return jpaUser.findUserEntities();
    }

    public List<Rol> bringRols() {
        return jpaRol.findRolEntities();
    }

    public void createUser(User usr) {
        jpaUser.create(usr);
    }

    public void deleteUser(Long idUsr) {
        try {
            jpaUser.destroy(idUsr);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User bringUser(Long idUser) {
        return jpaUser.findUser(idUser);
    }

    public void editUser(User usr) {
        try {
            jpaUser.edit(usr);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
