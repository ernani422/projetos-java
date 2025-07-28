package io.github.cursodsousa.libraryapi;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

//	public static void main(String[] args) {
//		var context = SpringApplication.run(Application.class, args);
//		AutorRepository repository = context.getBean(AutorRepository.class);
//		exmeploSalvarRegistro(repository);
//
//
//	}
//
//	public static void exmeploSalvarRegistro(AutorRepository autorRepository) {
//		Autor autor = new Autor();
//		autor.setNome("josé");
//		autor.setNacionalidade("Brasileiro");
//		autor.setDataNascimento(LocalDate.of(1950, 1, 31));
//
//		var autorSalvo = autorRepository.save(autor);
//		System.out.println(autorSalvo);
//
//	}

}
