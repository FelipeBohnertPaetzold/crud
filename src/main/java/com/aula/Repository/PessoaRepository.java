package com.aula.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, String>{

}
