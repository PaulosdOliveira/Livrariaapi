package io.github.paulosdoliveira.livrariaapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table
public class Autor {

    public Autor() {

    }

    public Autor(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 90)
    private String descricaoBreve;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private String  UrlFoto;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getUrlFoto() {
        return UrlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        UrlFoto = urlFoto;
    }
}
