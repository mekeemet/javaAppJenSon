package com.example.auth.web;

import com.example.auth.dao.AppUserRepository;
import com.example.auth.entities.AppUser;
import com.example.auth.services.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    AppUserRepository appUserRepository;
    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
        if (!userForm.getPassword().equals(userForm.getConfirmedPassword()))
            throw new RuntimeException("You must Confirm Password");
        AppUser user=accountService.loadUserByUsername(userForm.getUsername());
        if (user!=null)
            throw new RuntimeException("This user Already existes");
        AppUser appUser=new AppUser();
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
//        accountService.saveUser(appUser);
        accountService.addRoleToUser(userForm.getUsername(),"USER");
        return appUser;
    }

    @GetMapping("/user/{username}")
    public AppUser getOneTask(@PathVariable String username) {
        return appUserRepository.findByUsername(username);
    }
}
@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;

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

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
