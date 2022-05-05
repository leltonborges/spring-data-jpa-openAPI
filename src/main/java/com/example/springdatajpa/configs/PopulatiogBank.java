package com.example.springdatajpa.configs;

import com.example.springdatajpa.entities.Cargo;
import com.example.springdatajpa.entities.Funcionario;
import com.example.springdatajpa.services.CargoService;
import com.example.springdatajpa.services.FuncionarioService;
import com.example.springdatajpa.services.UnidadeTrabalhoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
@Profile({"test", "dev"})
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PopulatiogBank implements CommandLineRunner {

    private final CargoService cargoService;
    private final FuncionarioService funcionarioService;
    private final UnidadeTrabalhoService unidadeTrabalhoService;

    @Override
    public void run(String... args) throws Exception {
        this.saveEntities();
    }

    @Transactional
    void saveEntities() {
        Cargo c1 = new Cargo("Desenvolvedor Back End", "Desenvolve APIs");
        Cargo c2 = new Cargo("Desenvolvedor Front End", "Desenvolve Telas");

        Funcionario f1 = new Funcionario("João", "123", new BigDecimal(12256.5), LocalDate.now(), c1);
        Funcionario f2 = new Funcionario("Bia", "1433", new BigDecimal(12256.5), LocalDate.now(), c1);
        Funcionario f3 = new Funcionario("Lia", "2363", new BigDecimal(12256.5), LocalDate.now(), c2);
        Funcionario f4 = new Funcionario("Bob", "4123", new BigDecimal(12256.5), LocalDate.now(), c2);

        c1.addFuncionario(f1);
        c1.addFuncionario(f2);
        c2.addFuncionario(f3);
        c2.addFuncionario(f4);

        this.cargoService.save(c1);
        this.cargoService.save(c2);

        this.funcionarioService.save(f1);
        this.funcionarioService.save(f2);
        this.funcionarioService.save(f3);
        this.funcionarioService.save(f4);

    }


}
