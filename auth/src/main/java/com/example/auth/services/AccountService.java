package com.example.auth.services;

import com.example.auth.entities.AppRole;
import com.example.auth.entities.AppUser;
import com.example.auth.entities.Task;

public interface AccountService
{
    public AppUser saveUser(String username, String password, String confirmedPassword);
    public AppRole saveRole(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public Task saveTask(String taskname, Long user_id);
}
