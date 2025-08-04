package io.github.cursodsousa.libraryapi.controllers;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.Livro;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import io.github.cursodsousa.libraryapi.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorControllers {

    private final AutorRepository repository;

    @GetMapping
    public Iterable<Autor> getAutores(){
        return repository.findAll();
    }

    @PostMapping
    public Autor saveAutor(@RequestBody Autor autor){
        return repository.save(autor);
    }


}



