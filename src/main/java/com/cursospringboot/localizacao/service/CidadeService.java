package com.cursospringboot.localizacao.service;

import antlr.StringUtils;
import com.cursospringboot.localizacao.domain.entity.Cidade;
import com.cursospringboot.localizacao.domain.repository.CidadeRepository;
import com.cursospringboot.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    void salvarCidade(){
        var cidade = new Cidade(1L, "Maceio", 1500000L);
        cidadeRepository.save(cidade);
    }


    public void listarCidades(){
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public void listarCidadesPorNome(){
        //cidadeRepository.findByNome("Rio").forEach(System.out::println);
        //cidadeRepository.findByNomeStartingWith("Per").forEach(System.out::println);
        Pageable pageable = PageRequest.of(2,2);//paginando
        cidadeRepository.findByNomeLike("%%%%", pageable).forEach(System.out::println);

    }
    public void listarCidadesPorHabitantes(){
        cidadeRepository.findByHabitantes(1400000L).forEach(System.out::println);
    }

    public void listarCidadesPorQuantdHabitantes(){
        //cidadeRepository.findByHabitantesGreaterThan(120000L).forEach(System.out::println);//menor que
        cidadeRepository.findByHabitantesLessThanAndNomeLike(120000L, "Br%")
                .forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){//
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase("nome")//ignora caixa alta ou baixa no nome, pode adc todas as propriedades que quiser ignorar
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);//se começa com o valor que foi passado no parametro no metodo run
        Example<Cidade> example = Example.of(cidade);
        return cidadeRepository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        Specification<Cidade> specification = CidadeSpecs.nomeEqual("Sao Paulo");
        cidadeRepository.findAll(specification).forEach(System.out::println);
    }

//    void listarCidadesSpecsFiltroDinamico(Cidade filtro){
//        Specification<Cidade> specification = Specification.where(((root, query, criteriaBuilder) -> criteriaBuilder.conjunction()));
//        //select * from cidade where 1 = 1
//        if(filtro.getId() != null){
//            specification = specification.and( idEqual(filtro.getId()) );
//        }
//        if(StringUtils.hasTex)
//    }
}
