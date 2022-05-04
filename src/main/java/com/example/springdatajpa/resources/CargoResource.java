package com.example.springdatajpa.resources;

import com.example.springdatajpa.entities.Cargo;
import com.example.springdatajpa.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CargoResource {
    private final CargoService cargoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cargo>> findAll(){
        return ResponseEntity.ok(this.cargoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> findByID(@PathVariable Long id){
        return ResponseEntity.ok(this.cargoService.findById(id).get());
    }
}
