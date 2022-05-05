package com.example.springdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_cargo")
public class Cargo extends RepresentationModel<Cargo> implements Serializable {

    @Serial
    private static final long serialVersionUID = 5629851324697331039L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Cargo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addFuncionario(final Funcionario funcionario){
        funcionario.setCargo(this);
        this.getFuncionarios().add(funcionario);
    }
}
