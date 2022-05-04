package com.example.springdatajpa.resources;

import com.example.springdatajpa.entities.Cargo;
import com.example.springdatajpa.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public ResponseEntity<Cargo> findByID( @PathVariable Long id){
        Cargo cargo = this.cargoService.findById(id);
        cargo.add(linkTo(methodOn(CargoResource.class).findAll()).withRel(IanaLinkRelations.COLLECTION));

        cargo.add(linkTo(methodOn(CargoResource.class).findByID(id)).withSelfRel());

        return ResponseEntity.ok(cargo);
    }
}
