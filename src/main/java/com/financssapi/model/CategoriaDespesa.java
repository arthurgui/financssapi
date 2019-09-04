package com.financssapi.model;

import javax.persistence.*;

@Entity
@Table(name="tb_categoria_despesa")
public class CategoriaDespesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_categoria_despesa")
    private Long id;

    @Column(name = "nm_categoria_despesa")
    private String nome;

    public CategoriaDespesa() {
    }

    public CategoriaDespesa(String nome) {
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
