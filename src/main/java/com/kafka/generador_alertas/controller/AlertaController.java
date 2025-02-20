package com.kafka.generador_alertas.controller;

import com.kafka.generador_alertas.dto.AlertDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPICO_ALERTA = "alert";

    @PostMapping("/enviar")
    public String enviarAlerta(@RequestBody AlertDTO alerta) {
        kafkaTemplate.send(TOPICO_ALERTA, alerta);
        return "Alerta enviada correctamente";
    }
}
