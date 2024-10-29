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

import br.com.apirest.vetshop.model.Fornecedor;
import br.com.apirest.vetshop.service.FornecedorServico;

@RestController
@RequestMapping("/api/vetshop/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorServico servico;

    public FornecedorController(FornecedorServico serv) {
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAll(){
        List<Fornecedor> fornecedor = this.servico.Browse();
        return new ResponseEntity<>(fornecedor, HttpStatus.OK );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long codigo){
        Optional<Fornecedor> fornecedorPorId = this.servico.Read(codigo);
        if(fornecedorPorId.isPresent()){
            return new ResponseEntity<>(fornecedorPorId.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Fornecedor> post(@RequestBody Fornecedor fornecedorPost){
        Fornecedor fornecedorNovo = this.servico.Add(fornecedorPost);
        return new ResponseEntity<>(fornecedorNovo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Fornecedor> put(@RequestBody Fornecedor fornecedorPut){
        Fornecedor fornecedorEdit = this.servico.Edit(fornecedorPut);
        if(fornecedorEdit != null){
            return new ResponseEntity<>(fornecedorEdit, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Fornecedor> Delete(@PathVariable Long codigo){
        Fornecedor fornecedorDel = this.servico.Delete(codigo);
        if(fornecedorDel != null){
            return new ResponseEntity<>(fornecedorDel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
