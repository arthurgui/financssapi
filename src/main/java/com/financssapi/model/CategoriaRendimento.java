package com.financssapi.model;

import javax.persistence.*;

@Entity
@Table(name="tb_categoria_rendimento")
public class CategoriaRendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_categoria_rendimento")
    private Long id;

    @Column(name = "nm_categoria_rendimento")
    private String nome;

    public CategoriaRendimento() {
    }

    public CategoriaRendimento(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
