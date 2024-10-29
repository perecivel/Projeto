package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.Pedido;
import br.com.apirest.vetshop.repository.IPedidoRepositorio;

@Service
public class PedidoServico implements IBaseServicoJPA<Pedido>{
    
    @Autowired
    private IPedidoRepositorio repositorio;

    public PedidoServico(IPedidoRepositorio repo) {
        this.repositorio = repo;
    }

    @Override
    public List<Pedido> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Pedido> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Pedido Edit(Pedido obj) {
        Optional<Pedido> pedidoExistente = this.repositorio.findById(obj.getId());
        if(pedidoExistente.isPresent()){
            Pedido pedidoEditado = pedidoExistente.get();
            pedidoEditado.setNome(obj.getNome());
            // pedidoEditado.setCliente(obj.getCliente());
            // pedidoEditado.setFornecedor(obj.getFornecedor());
            // pedidoEditado.setDataDeInclusao(obj.getDataDeInclusao());
            pedidoEditado.setDataDeAlteracao(obj.getDataDeAlteracao());
            this.repositorio.save(pedidoEditado);
        }
        return null;
    }

    @Override
    public Pedido Add(Pedido obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public Pedido Delete(Long chave) {
        Optional<Pedido> produtoExistente = this.repositorio.findById(chave);
        if(produtoExistente.isPresent()){
            this.repositorio.delete(produtoExistente.get());
            return produtoExistente.get();
        }
        return null;
    }
    
}
