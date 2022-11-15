package com.cursospringboot.localizacao.domain.repository;

import com.cursospringboot.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository <Cidade, Long>, JpaSpecificationExecutor<Cidade> {//JpaSpecificationExecutor - recebe uma especificacao como paramentro - um pedaço de queery


    List<Cidade> findByNome(String nome);//busca pelo nome correto === //queries metodos
    List<Cidade> findByNomeStartingWith(String nome);//busca pelo nome iniciado pelo trecho
    List<Cidade> findByNomeEndingWith(String nome);//busca pelo nome terminando pelo trecho
    List<Cidade> findByNomeContaining(String nome);//busca pelo nome contendo aquele trecho
    List<Cidade> findByHabitantes(Long habitantes);
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")//?1 - primeiro paramentro que vier na query - lower ou upper caixa baixa ou alta
    List<Cidade> findByNomeLike(String nome, Sort sort);//busca pelo nome like ordenado

    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")//?1 - primeiro paramentro que vier na query - lower ou upper caixa baixa ou alta
    Page<Cidade> findByNomeLike(String nome, Pageable sort);//busca pelo nome like paginado

    List<Cidade> findByHabitantesLessThan(Long habitantes);//menor que uma quantidade x de habitantes

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);//maior que

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);


}
