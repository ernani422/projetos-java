package io.github.cursodsousa.libraryapi.controllers;

import io.github.cursodsousa.libraryapi.model.Livro;
import io.github.cursodsousa.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivrosControlles {
    private final LivroRepository livroRepository;


    @GetMapping
    public Iterable<Livro> getLivros() {
        return livroRepository.findAll();
    }

    @PostMapping
    public Livro saveLivro(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }


}
