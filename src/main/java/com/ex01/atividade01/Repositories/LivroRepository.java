package com.ex01.atividade01.Repositories;

import com.ex01.atividade01.Models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
