package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.user.LoginService;
import com.epam.training.ticketservice.core.user.persistence.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class UserCommand {

    LoginService signInOutService;

    @Autowired
    UserCommand(LoginService signInOutService){
        this.signInOutService=signInOutService;
    }


    @ShellMethod(value = "Sign in as an admin",key = "sign in privileged")
    public String login(String username,String password){

        try {
            signInOutService.signIn(username,password);
        }catch (Exception e) {
            return e.getMessage();
        }

        return "You are signed in";
    }

    @ShellMethod(value = "Log out from admin account",key = "sign out")
    public String logout(){

        try {
            signInOutService.signOut();
        }catch (Exception e){
            return e.getMessage();
        }
        return "You signed out";
    }

    @ShellMethod(value = "Describe account", key = "describe account")
    public String describeAccount(){
        if(signInOutService.describe())
            return "Signed in with privileged account "+ Admin.getUsername();
        return "You are not signed in";
    }

}
