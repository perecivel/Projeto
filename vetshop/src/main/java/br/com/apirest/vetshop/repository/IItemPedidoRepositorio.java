package br.com.apirest.vetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.apirest.vetshop.model.ItemPedido;

public interface IItemPedidoRepositorio extends JpaRepository<ItemPedido, Long>{
    
}
