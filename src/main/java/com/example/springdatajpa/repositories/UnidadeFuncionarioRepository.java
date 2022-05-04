package com.example.springdatajpa.repositories;

import com.example.springdatajpa.entities.Funcionario;
import com.example.springdatajpa.entities.UnidadeFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UnidadeFuncionarioRepository extends JpaRepository<UnidadeFuncionario, Long> {
    Optional<Funcionario> findByFuncionario_Name(String name);
}
