package io.github.cursodsousa.libraryapi.service;

import io.github.cursodsousa.libraryapi.repository.LivroRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivrosService {

    @Getter
    private final AutorService autorService;

    private final LivroRepository livroRepository;


}
