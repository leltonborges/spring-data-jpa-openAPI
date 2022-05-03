package com.example.springdatajpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "tb_unidade_trabalho")
public class UnidadeTrabalho implements Serializable {
    @Serial
    private static final long serialVersionUID = -8058317873380213241L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "unidadeTrabalho")
    private List<UnidadeFuncionario> unidadeFuncionario = new ArrayList<>();
}
