package com.example.auth.dao;

import com.example.auth.entities.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammeRepository extends JpaRepository<Programme,Long> {
}
