package com.financssapi.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_forma_pagamento")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_forma_pagamento")
    private Long id;

    @Column(name = "nm_forma_pagamento")
    private String nome;

    @Column(name = "ds_forma_pagamento")
    private String descricao;

    public FormaPagamento() {
    }

    public FormaPagamento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
