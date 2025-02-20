package com.kafka.generador_alertas.consumer;

import com.kafka.generador_alertas.dto.AlertDTO;

import com.kafka.generador_alertas.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AlertaConsumer {

    @Autowired
    private AlertaService alertaService;

    @KafkaListener(topics = "alert", groupId = "alert-group")
    public void consumirAlerta(AlertDTO alerta) {
        System.out.println("Recibido: " + alerta);
        alertaService.saveAlert(alerta);
        System.out.println("Alerta generada y enviada a la bd: " + alerta);
    }
}
