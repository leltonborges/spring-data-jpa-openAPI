package com.example.springdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends RepresentationModel<Funcionario> implements Serializable {
    @Serial
    private static final long serialVersionUID = 3002557075007411584L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private BigDecimal salary;
    private LocalDate contractDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<UnidadeFuncionario> unidadeFuncionario = new ArrayList<>();


    public Funcionario(String name, String cpf, BigDecimal salary, LocalDate contractDate, Cargo cargo) {
        super(new ArrayList<>());
        this.name = name;
        this.cpf = cpf;
        this.salary = salary;
        this.contractDate = contractDate;
        this.cargo = cargo;
    }
}
