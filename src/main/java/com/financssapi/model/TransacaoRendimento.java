package com.financssapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_transacao_rendimento")
public class TransacaoRendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_transacao_rendimento")
    private Long id;

    @Column(name = "nm_transacao_rendimento")
    private String nome;

    @Column(name = "nu_valor")
    private float valor;

    @ManyToOne()
    @JoinColumn(name = "cd_categoria_rendimento")
    private CategoriaRendimento categoriaRendimento;

    @ManyToOne()
    @JoinColumn(name = "cd_conta")
    private Conta conta;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "dt_lancamento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtLancamento;

    @Column(name = "dt_cadastro", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    public TransacaoRendimento() {
    }

    public TransacaoRendimento(String nome, float valor, CategoriaRendimento categoriaRendimento, Conta conta, String descricao, Date dtLancamento, Date dtCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.categoriaRendimento = categoriaRendimento;
        this.conta = conta;
        this.descricao = descricao;
        this.dtLancamento = dtLancamento;
        this.dtCadastro = dtCadastro;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public CategoriaRendimento getCategoriaRendimento() {
        return categoriaRendimento;
    }

    public void setCategoriaRendimento(CategoriaRendimento categoriaRendimento) {
        this.categoriaRendimento = categoriaRendimento;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
