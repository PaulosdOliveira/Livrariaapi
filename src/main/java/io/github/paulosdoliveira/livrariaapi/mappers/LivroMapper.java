package io.github.paulosdoliveira.livrariaapi.mappers;

import io.github.paulosdoliveira.livrariaapi.dto.livro.LivroCadastroDTO;
import io.github.paulosdoliveira.livrariaapi.dto.livro.LivroCartaoDTO;
import io.github.paulosdoliveira.livrariaapi.model.Autor;
import io.github.paulosdoliveira.livrariaapi.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {


    public Livro toEntity(LivroCadastroDTO dto, Autor autor) {
        var livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setGenero(dto.getGenero());
        livro.setDescricao(dto.getDescricao());
        livro.setISBN(dto.getISBN());
        livro.setAtivo(true);
        livro.setAutor(autor);
        livro.setDataPublicacao(dto.getDataPublicacao());
        return livro;
    }


    public LivroCartaoDTO toCartao(Livro livro) {
        var cartaoDTO = new LivroCartaoDTO();
        cartaoDTO.setTitulo(livro.getTitulo());
        cartaoDTO.setGenero(livro.getGenero());
        cartaoDTO.setNomeAutor(livro.getAutor().getNome());
        cartaoDTO.setDataPublicacao(livro.getDataPublicacao());
        return cartaoDTO;
    }
}
