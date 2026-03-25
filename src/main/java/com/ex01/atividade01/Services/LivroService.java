package com.ex01.atividade01.Services;

import com.ex01.atividade01.Models.LivroModel;
import com.ex01.atividade01.Repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public Optional<LivroModel> buscarId(Long id) {
        return livroRepository.findById(id);
    }

    public LivroModel atualizar(Long id, LivroModel livroModel) {
        LivroModel newLivro = livroRepository.findById(id).get();
        newLivro.setTitulo(livroModel.getTitulo());
        newLivro.setAutor(livroModel.getAutor());
        newLivro.setAnoPublicacao(livroModel.getAnoPublicacao());
        return livroRepository.save(newLivro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
