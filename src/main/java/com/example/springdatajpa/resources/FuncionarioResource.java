package com.example.springdatajpa.resources;

import com.example.springdatajpa.entities.Funcionario;
import com.example.springdatajpa.services.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/funcionario")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FuncionarioResource {
    private final FuncionarioService funcionarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Funcionario>> findAll(){
        return ResponseEntity.ok(this.funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findByID( @PathVariable Long id){
        Funcionario funcionario = this.funcionarioService.findById(id);

        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/cargo/{id}")
    public ResponseEntity<Funcionario> findByCargoId( @PathVariable Long id){
        Funcionario funcionario = this.funcionarioService.findById(id);

        return ResponseEntity.ok(funcionario);
    }
}
