package com.example.auth;

import com.example.auth.dao.TaskRepository;
import com.example.auth.entities.AppRole;
import com.example.auth.entities.AppUser;
import com.example.auth.entities.Task;
import com.example.auth.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class AuthApplication {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
//    @Bean
//    CommandLineRunner start(AccountService accountService){
//        repositoryRestConfiguration.exposeIdsFor(AppUser.class);
//        return args -> {
//            accountService.saveRole(new AppRole(null,"USER"));
//            accountService.saveRole(new AppRole(null,"ADMIN"));
//
//            Stream.of("user1","user2","root","admin").forEach(u->{
//                accountService.saveUser(u,"1234","1234");
//            });
//            accountService.addRoleToUser("admin","ADMIN");
//            accountService.addRoleToUser("root","ADMIN");
//
//            Stream.of("T3","T4").forEach(t->{
//                accountService.saveTask(t, (long) 4);
//            });
//            Stream.of("T5","T6").forEach(t->{
//                accountService.saveTask(t, (long) 3);
//            });
//            Stream.of("T7","T8").forEach(t->{
//                accountService.saveTask(t, (long) 2);
//            });
//
//            taskRepository.findAll().forEach(t->{
//                System.out.println(t.getId()+" "+t.getTaskName()+" "+t.getAppUser().getUsername());
//        });
//        };
//    }

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    public void run(String... args) throws Exception {
//        taskRepository.deleteAll();
//        Stream.of("T5","T6").forEach(t->{
//            accountService.saveTask(t, (long) 2);
//        });
//        taskRepository.findAll().forEach(t->{
//            System.out.println(t.getTaskName());
//        });
//        accountService.saveRole(new AppRole(null,"USER"));
//        accountService.saveRole(new AppRole(null,"ADMIN"));
//        Stream.of("root", "admin", "user1", "user2").forEach(u->{
//            accountService.saveUser(u,"1234","1234");
//           });
//        accountService.addRoleToUser("root","ADMIN");
//        accountService.addRoleToUser("admin","ADMIN");
//    }
}
