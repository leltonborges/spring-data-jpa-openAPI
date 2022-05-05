package com.example.springdatajpa.services;

import com.example.springdatajpa.entities.Funcionario;
import com.example.springdatajpa.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Page<Funcionario> findAll(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }

    public <S extends Funcionario> S save(S entity) {
        return funcionarioRepository.save(entity);
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    public void delete(Funcionario entity) {
        funcionarioRepository.delete(entity);
    }

}
