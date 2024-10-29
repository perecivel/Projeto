package br.com.apirest.vetshop.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Set<Produto> produtos;

    private LocalDate dataDeInclusao;
    private LocalDate dataDeAlteracao;
    

    public Long getId() {
        return Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Set<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }
    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }
    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }
    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public Pedido() {
        this.produtos = new HashSet<>();
    }

    public Pedido(Long Id, String nome, Cliente cliente, Fornecedor fornecedor, Set<Produto> produtos,
            LocalDate dataDeInclusao, LocalDate dataDeAlteracao) {
        this.Id = Id;
        this.nome = nome;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.produtos = produtos;
        this.dataDeInclusao = dataDeInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
    }
}
