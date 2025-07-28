package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//Associar a Interface: Lembre-se de que, ao criar um repositório,
// você está definindo uma interface que estende JpaRepository.
// Isso significa que, em vez de implementar métodos, você está configurando um contrato
// que será gerenciado pelo Spring. Pense em "interface = contrato" e "implementação = responsabilidade do Spring".//
public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
