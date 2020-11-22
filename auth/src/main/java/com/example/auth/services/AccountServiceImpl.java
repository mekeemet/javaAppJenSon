package com.example.auth.services;

import com.example.auth.dao.AppRoleRepository;
import com.example.auth.dao.AppUserRepository;
import com.example.auth.dao.TaskRepository;
import com.example.auth.entities.AppRole;
import com.example.auth.entities.AppUser;
import com.example.auth.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Consumer;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public AppUser saveUser(AppUser appUser) {
//        String hashPW=bCryptPasswordEncoder.encode(appUser.getPassword());
//        appUser.setPassword(hashPW);
//        return appUserRepository.save(appUser);
//    }

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser user = appUserRepository.findByUsername(username);
        if(user != null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("please confirm password");
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(username, "USER");
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }

    @Override
    public Task saveTask(String taskname, Long user_id) {
        Optional<AppUser> appUser=appUserRepository.findById(user_id);
        AppUser user = new AppUser();
        if(appUser.isPresent()) {
            user = appUser.get();
        } else {
            System.out.println("This user doesn't exist!");
        }
        Task task = new Task();
        task.setTaskName(taskname);
        task.setAppUser(user);
        taskRepository.save(task);
        System.out.println("******************"+user.getUsername()+"*********************");
        return task;
    }
}
