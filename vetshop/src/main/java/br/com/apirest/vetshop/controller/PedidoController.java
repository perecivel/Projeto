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


import br.com.apirest.vetshop.model.Pedido;
import br.com.apirest.vetshop.service.PedidoServico;

@RestController
@RequestMapping("/api/vetshop/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServico servico;

    public PedidoController(PedidoServico serv) {
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        List<Pedido> pedido = this.servico.Browse();
        return new ResponseEntity<>(pedido, HttpStatus.OK );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getById(@PathVariable Long codigo){
        Optional<Pedido> pedidoPorId = this.servico.Read(codigo);
        if(pedidoPorId.isPresent()){
            return new ResponseEntity<>(pedidoPorId.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@RequestBody Pedido pedidoPost){
        Pedido pedidoNovo = this.servico.Add(pedidoPost);
        return new ResponseEntity<>(pedidoNovo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pedido> put(@RequestBody Pedido pedidoPut){
        Pedido pedidoEdit = this.servico.Edit(pedidoPut);
        if(pedidoEdit != null){
            return new ResponseEntity<>(pedidoEdit, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Pedido> Delete(@PathVariable Long codigo){
        Pedido pedidoDel = this.servico.Delete(codigo);
        if(pedidoDel != null){
            return new ResponseEntity<>(pedidoDel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
