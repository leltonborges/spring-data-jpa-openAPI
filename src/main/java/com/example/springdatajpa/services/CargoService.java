package com.example.springdatajpa.services;

import com.example.springdatajpa.entities.Cargo;
import com.example.springdatajpa.repositories.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CargoService {
    private final CargoRepository cargoRepository;

    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    public Page<Cargo> findAll(Pageable pageable) {
        return cargoRepository.findAll(pageable);
    }

    public <S extends Cargo> S save(S entity) {
        return cargoRepository.save(entity);
    }

    public Cargo findById(Long aLong) {
        return cargoRepository.findById(aLong).get();
    }

    public void delete(Cargo entity) {
        cargoRepository.delete(entity);
    }

}
