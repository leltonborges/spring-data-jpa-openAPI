package com.example.springdatajpa.repositories;

import com.example.springdatajpa.entities.UnidadeTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends JpaRepository<UnidadeTrabalho, Long> {
}
