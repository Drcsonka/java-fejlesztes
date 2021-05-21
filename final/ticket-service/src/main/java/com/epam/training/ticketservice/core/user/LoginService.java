package com.epam.training.ticketservice.core.user;

import com.epam.training.ticketservice.core.user.persistence.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void signIn(String username, String password) throws Exception {

        if(Admin.getPassword().equals(password) && Admin.getUsername().equals(username) &&
                !Admin.isLogedIn()){
            Admin.setIsLogedIn(true);
            return;
        }
        if(Admin.isLogedIn()){
            throw new Exception("You already logged in");
        }
        if(Admin.getPassword().equals(password) == false || Admin.getUsername().equals(username) == false){
            throw new Exception("Login failed due to incorrect credentials");
        }

    }

    public void signOut() throws Exception {

        if(!Admin.isLogedIn())
            throw new Exception("You are not logged in");
        Admin.setIsLogedIn(false);

    }

    public boolean describe(){
        return Admin.isLogedIn();

    }

}
