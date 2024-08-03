
package com.mycompany.login.logica;

import com.mycompany.login.persistence.PersistenceController;
import java.util.List;

public class Controller {
    
    PersistenceController persisCtrl;

    public Controller() {
        persisCtrl = new PersistenceController();
    }
    
    public User validarUsuario(String userSt, String pwSt) {
        
        User userBringed = null;
        //String message = "";
        List<User> usersList = persisCtrl.bringUsers();
        for(User u:usersList){
            if(u.getUserName().equals(userSt)){
                if(u.getUserPw().equals(pwSt)){
                    //message = "Usuario y contraseña correctos.\nBienvenido.";
                    userBringed=u;
                    return userBringed;
                }
                else{
                    userBringed=null;
                    //message="Contraseña incorrecta.";
                    return userBringed;
                }
            }
            else{
                userBringed=null;
                //message="Usuario y contraseña incorrecta.";
            }
        }
        return userBringed;
    }

    public List<User> bringUsers() {
        return persisCtrl.bringUsers();
    }

    public List<Rol> bringRols() {
        return persisCtrl.bringRols();
    }

    public void crearUsuario(String userName, String pw, String bringedRol) {
        User usr = new User ();
        usr.setUserName(userName);
        usr.setUserPw(pw);
        Rol findedRol = new Rol();
        findedRol = this.traerRol(bringedRol);
        if(findedRol!=null){
            usr.setSingleRol(findedRol);
        }
        long id = this.findLastId();
        usr.setId(id+1);
        persisCtrl.createUser(usr);
    }
    private Rol traerRol(String bringedRol) {
        List<Rol> rolList = persisCtrl.bringRols();
        for(Rol r : rolList){
            if(r.getRolName().equals(bringedRol))
                return r;
        }
        return null;
    }

    private long findLastId() {
        int lastId;
        List<User> usersList = persisCtrl.bringUsers();
        User usr = usersList.get(usersList.size()-1);
        return usr.getId();
    }

    public void deleteUser(Long idUsr) {
        persisCtrl.deleteUser(idUsr);

    }

    public User bringUser(Long idUser) {
        return persisCtrl.bringUser(idUser);
    }

    public void editUser(User usr, String userName, String pw, String bringedRol) {
        usr.setUserName(userName);
        usr.setUserPw(pw);
        Rol findedRol = new Rol();
        findedRol = this.traerRol(bringedRol);
        if(findedRol!=null){
            usr.setSingleRol(findedRol);
        }
        persisCtrl.editUser(usr);

    }
}
