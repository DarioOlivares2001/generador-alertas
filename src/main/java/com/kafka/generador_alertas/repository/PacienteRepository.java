package com.kafka.generador_alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.generador_alertas.model.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
