package br.com.apirest.vetshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.vetshop.model.ItemPedido;

import br.com.apirest.vetshop.repository.IItemPedidoRepositorio;

@Service
public class ItemPedidoServico implements IBaseServicoJPA <ItemPedido> {

    @Autowired
    private IItemPedidoRepositorio repositorio;

    public ItemPedidoServico(IItemPedidoRepositorio repo) {
        this.repositorio = repo;
    }

    @Override
    public List<ItemPedido> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<ItemPedido> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public ItemPedido Edit(ItemPedido obj) {
        // Optional<ItemPedido> categoriaExistente = this.repositorio.findById(obj.getId());
        // if(categoriaExistente.isPresent()){
        //     ItemPedido categoriaEditada = categoriaExistente.get();
        //     categoriaEditada.setNome(obj.getNome());
        //     this.repositorio.save(categoriaEditada);
        // }
        return null;
    }

    @Override
    public ItemPedido Add(ItemPedido obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public ItemPedido Delete(Long chave) {
        Optional<ItemPedido> itemPedidoExiste = this.repositorio.findById(chave);
        if(itemPedidoExiste.isPresent()){
            this.repositorio.delete(itemPedidoExiste.get());
            return itemPedidoExiste.get();
        }
        return null;
    }
    
}
