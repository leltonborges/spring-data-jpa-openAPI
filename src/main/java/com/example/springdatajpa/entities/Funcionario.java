package com.example.springdatajpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_funcionario")
@NamedEntityGraph(
        name = "Funcionario.unidadeFuncionario",
        attributeNodes = @NamedAttributeNode("unidadeFuncionario")
)
public class Funcionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 3002557075007411584L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private BigDecimal salary;
    private LocalDate contractDate;

    @ManyToOne
    private Cargo cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<UnidadeFuncionario> unidadeFuncionario;
}
