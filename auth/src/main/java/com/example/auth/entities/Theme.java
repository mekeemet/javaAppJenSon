package com.example.auth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Theme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private  String lieu;
    @ManyToOne
    private AppUser appUser;
    @OneToMany(mappedBy = "theme",fetch = FetchType.LAZY)
    private Collection<Programme> programmes;

}
