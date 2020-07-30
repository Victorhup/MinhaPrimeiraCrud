package com.escola.Escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.Escola.model.Turmas;

@Repository
public interface TurmasRepository extends JpaRepository<Turmas, Long>{
    public List<Turmas> findAllByTurmaContainingIgnoreCase (String turma);
}
