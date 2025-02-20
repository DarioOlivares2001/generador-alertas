package com.kafka.generador_alertas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.generador_alertas.dto.AlertDTO;
import com.kafka.generador_alertas.model.Alerta;
import com.kafka.generador_alertas.model.Paciente;
import com.kafka.generador_alertas.repository.AlertaRepository;
import com.kafka.generador_alertas.repository.PacienteRepository;




@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void saveAlert(AlertDTO alertDTO) {
        // Obtener paciente por ID
        Paciente paciente = pacienteRepository.findById(alertDTO.getPatientId()).orElse(null);

        if (paciente != null) {
            // Crear entidad Alerta
            Alerta alerta = new Alerta();
            alerta.setPatient(paciente);
            alerta.setAlertType(alertDTO.getAlertType());
            alerta.setStatus(alertDTO.getStatus());
            alerta.setTimestamp(alertDTO.getTimestamp());

            // Guardar alerta
            alertaRepository.save(alerta);
        } else {
            // Si el paciente no se encuentra, lanzar excepción o manejar el error
            System.out.println("Paciente no encontrado con ID: " + alertDTO.getPatientId());
        }
    }
}