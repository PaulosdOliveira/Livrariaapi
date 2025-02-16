package io.github.paulosdoliveira.livrariaapi.services;

import io.github.paulosdoliveira.livrariaapi.dto.livro.LivroCadastroDTO;
import io.github.paulosdoliveira.livrariaapi.dto.livro.LivroCartaoDTO;
import io.github.paulosdoliveira.livrariaapi.mappers.LivroMapper;
import io.github.paulosdoliveira.livrariaapi.model.Livro;
import io.github.paulosdoliveira.livrariaapi.repositories.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Service
public class LivroService {

    public LivroService(LivroMapper mapper, LivroRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public LivroService() {

    }

    @Autowired
    private LivroMapper mapper;

    @Autowired
    private LivroRepository repository;

    public void salvarLivro(LivroCadastroDTO dto) {
        var livro = mapper.toEntity(dto);
        livro.setAtivo(true);
        repository.save(livro);
    }

    @Transactional
    public boolean deletarLivro(UUID id) {
        var possivelLivro = repository.findById(id);
        if (!possivelLivro.isPresent()) return false;
        var livro = possivelLivro.get();
        livro.setAtivo(false);
        return true;
    }

    public Page<List<LivroCartaoDTO>> buscarLivros(String titulo) {
        var livro = new Livro(titulo);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Livro> livroExample = Example.of(livro, matcher);
        Pageable page = PageRequest.of(0, 12);
        var resultado = repository.findAll(livroExample, page);


        Page<List<LivroCartaoDTO>> lista = resultado.map(pagina -> {
            return Collections.singletonList(mapper.toCartao(pagina));
        });

        return lista;
    }
}
