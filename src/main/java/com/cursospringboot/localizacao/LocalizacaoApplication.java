package com.cursospringboot.localizacao;

import com.cursospringboot.localizacao.domain.entity.Cidade;
import com.cursospringboot.localizacao.domain.repository.CidadeRepository;
import com.cursospringboot.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication  implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
//		var cidade = new Cidade(null, "Paulo", null);
//		cidadeService.filtroDinamico(cidade).forEach(System.out::println);

		cidadeService.listarCidadesByNomeSpec();
	}
	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
