package com.example.springdatajpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_unidade_funcionario")
public class UnidadeFuncionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 5074028810695289686L;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    public static class UnidadeFuncionarioPK implements Serializable {
        @Serial
        private static final long serialVersionUID = -985588781592311939L;

        private Long funcionario;
        private Long unidadeTrabalho;

    }

    @EmbeddedId
    private UnidadeFuncionarioPK id;

    @MapsId("funcionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @MapsId("unidadeTrabalho")
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadeTrabalho unidadeTrabalho;

}
