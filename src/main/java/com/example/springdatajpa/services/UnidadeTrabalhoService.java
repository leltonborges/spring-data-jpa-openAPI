package com.example.springdatajpa.services;

import com.example.springdatajpa.entities.UnidadeTrabalho;
import com.example.springdatajpa.repositories.UnidadeTrabalhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public List<UnidadeTrabalho> findAll() {
        return unidadeTrabalhoRepository.findAll();
    }

    public Page<UnidadeTrabalho> findAll(Pageable pageable) {
        return unidadeTrabalhoRepository.findAll(pageable);
    }

    public <S extends UnidadeTrabalho> S save(S entity) {
        return unidadeTrabalhoRepository.save(entity);
    }

    public UnidadeTrabalho findById(Long id) {
        return unidadeTrabalhoRepository.findById(id).get();
    }

    public void delete(UnidadeTrabalho entity) {
        unidadeTrabalhoRepository.delete(entity);
    }

}
