package com.cursospringboot.localizacao.domain.repository.specs;

import com.cursospringboot.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public class CidadeSpecs {

    public  static Specification<Cidade> nomeEqual (String nome){//cidade  = nome
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"), nome);//metodo toPredicate
    }

    public  static Specification<Cidade> habitantesGreaterThan (Integer value){//cidade  = nome
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("habitantes"), value);//metodo toPredicate
    }

    public  static Specification<Cidade> habitantesBetwenn (Long min, Long max){//cidade entre quantidade x e y de habitantes
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("habitantes"), min, max);//metodo toPredicate
    }

    public  static Specification<Cidade> nomeLike (String nome){//cidade  = nome
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%" + nome + "%".toUpperCase());//
    }

}
