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

import br.com.apirest.vetshop.model.Categoria;
import br.com.apirest.vetshop.service.CategoriaServico;

@RestController
@RequestMapping("/api/vetshop/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServico servico;

    public CategoriaController(CategoriaServico serv) {
        this.servico = serv;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        List<Categoria> categoria = this.servico.Browse();
        return new ResponseEntity<>(categoria, HttpStatus.OK );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> getById(@PathVariable Long codigo){
        Optional<Categoria> categoriaPorId = this.servico.Read(codigo);
        if(categoriaPorId.isPresent()){
            return new ResponseEntity<>(categoriaPorId.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria catPost){
        Categoria catNovo = this.servico.Add(catPost);
        return new ResponseEntity<>(catNovo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Categoria> put(@RequestBody Categoria catPut){
        Categoria catEdit = this.servico.Edit(catPut);
        if(catEdit != null){
            return new ResponseEntity<>(catEdit, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Categoria> Delete(@PathVariable Long codigo){
        Categoria categoriaDel = this.servico.Delete(codigo);
        if(categoriaDel != null){
            return new ResponseEntity<>(categoriaDel, HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
