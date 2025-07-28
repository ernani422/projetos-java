package io.github.cursodsousa.libraryapi.service;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import io.github.cursodsousa.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository repository;
    private final LivroRepository livroRepository;
    private final Validator validator;

    public Autor salvar(Autor autor) {
        validator.validateObject(autor);
        return repository.save(autor);


    }
}
