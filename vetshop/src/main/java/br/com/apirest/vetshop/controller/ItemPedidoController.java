package br.com.apirest.vetshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.vetshop.model.ItemPedido;
import br.com.apirest.vetshop.service.ItemPedidoServico;

@RestController
@RequestMapping("/api/vetshop/itemPedido")
public class ItemPedidoController {
    
    @Autowired
    private ItemPedidoServico servico;

    public ItemPedidoController(ItemPedidoServico serv) {
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> getAll(){
        List<ItemPedido> cliente = this.servico.Browse();
        return new ResponseEntity<>(cliente, HttpStatus.OK );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemPedido> getById(@PathVariable Long codigo){
        Optional<ItemPedido> itemPedidoPorId = this.servico.Read(codigo);
        if(itemPedidoPorId.isPresent()){
            return new ResponseEntity<>(itemPedidoPorId.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ItemPedido> post(@RequestBody ItemPedido itemPedidoPost){
        ItemPedido itemPedidoNovo = this.servico.Add(itemPedidoPost);
        return new ResponseEntity<>(itemPedidoNovo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ItemPedido> put(@RequestBody ItemPedido itemPedidoPut){
        ItemPedido itemPedidoEdit = this.servico.Edit(itemPedidoPut);
        if(itemPedidoEdit != null){
            return new ResponseEntity<>(itemPedidoEdit, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ItemPedido> Delete(@PathVariable Long codigo){
        ItemPedido ItemPedidoDel = this.servico.Delete(codigo);
        if(ItemPedidoDel != null){
            return new ResponseEntity<>(ItemPedidoDel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
