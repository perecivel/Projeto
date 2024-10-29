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

import br.com.apirest.vetshop.model.Produto;
import br.com.apirest.vetshop.service.ProdutoServico;

@RestController
@RequestMapping("/api/vetshop/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoServico servico;

    public ProdutoController(ProdutoServico serv){
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produto = this.servico.Browse();
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> getById(@PathVariable Long codigo){
        Optional<Produto> produtoPorId = this.servico.Read(codigo);
        if (produtoPorId.isPresent()){
            return new ResponseEntity<>(produtoPorId.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto produtoPost) {
        Produto produtoNovo = this.servico.Add(produtoPost);
        return new ResponseEntity<>(produtoNovo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto produtoPut){
        Produto produtoEdit = this.servico.Edit(produtoPut);
        if (produtoEdit != null){
            return new ResponseEntity<>(produtoEdit, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Produto> delete(@PathVariable Long codigo){
        Produto produtoDel = this.servico.Delete(codigo);
        if (produtoDel != null){
            return new ResponseEntity<>(produtoDel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
