package com.example.springdatajpa.configs;

import com.example.springdatajpa.entities.Cargo;
import com.example.springdatajpa.services.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;

@Configuration
@Profile({"test", "dev"})
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PopulatiogBank implements CommandLineRunner {

    private final CargoService cargoService;

    @Override
    public void run(String... args) throws Exception {
        this.saveCargos();
    }

    @Transactional
    void saveCargos(){
        Cargo c1 = new Cargo(null, "Desenvolvedor Back End", "Desenvolve APIs", Collections.EMPTY_LIST);
        Cargo c2 = new Cargo(null, "Desenvolvedor Front End", "Desenvolve Telas", Collections.EMPTY_LIST);

        this.cargoService.save(c1);
        this.cargoService.save(c2);
    }
}
