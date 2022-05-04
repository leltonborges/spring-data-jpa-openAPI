package com.example.springdatajpa.repositories;

import com.example.springdatajpa.entities.Funcionario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @EntityGraph(value = "Funcionario.unidadeFuncionario", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Funcionario> findByName(String name);

}
