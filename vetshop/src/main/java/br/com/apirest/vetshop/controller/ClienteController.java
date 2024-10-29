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

import br.com.apirest.vetshop.model.Cliente;
import br.com.apirest.vetshop.service.ClienteServico;

@RestController
@RequestMapping("/api/vetshop/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteServico servico;

    public ClienteController(ClienteServico serv) {
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> cliente = this.servico.Browse();
        return new ResponseEntity<>(cliente, HttpStatus.OK );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getById(@PathVariable Long codigo){
        Optional<Cliente> clientePorId = this.servico.Read(codigo);
        if(clientePorId.isPresent()){
            return new ResponseEntity<>(clientePorId.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente clientePost){
        Cliente clienteNovo = this.servico.Add(clientePost);
        return new ResponseEntity<>(clienteNovo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> put(@RequestBody Cliente clientePut){
        Cliente clienteEdit = this.servico.Edit(clientePut);
        if(clienteEdit != null){
            return new ResponseEntity<>(clienteEdit, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Cliente> Delete(@PathVariable Long codigo){
        Cliente clienteDel = this.servico.Delete(codigo);
        if(clienteDel != null){
            return new ResponseEntity<>(clienteDel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
