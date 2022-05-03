package com.example.springdatajpa.repositories;

import com.example.springdatajpa.entities.UnidadeFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeFuncionarioRepository extends JpaRepository<UnidadeFuncionario, Long> {
}
