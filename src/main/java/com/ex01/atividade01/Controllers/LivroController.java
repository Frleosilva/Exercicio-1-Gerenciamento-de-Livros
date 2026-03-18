package com.ex01.atividade01.Controllers;

import com.ex01.atividade01.Models.LivroModel;
import com.ex01.atividade01.Repositories.LivroRepository;
import com.ex01.atividade01.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "livros")

public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
       List<LivroModel> request = livroService.findAll();
       return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarProduto(@RequestBody LivroModel livroModel){
        LivroModel request = livroService.criarLivro(LivroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livroModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public LivroModel atualizar(@PathVariable Long id, @RequestBody LivroModel livroModel){
        return livroService.atualizar(id, livroModel);
    }
}
