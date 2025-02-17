package com.kafka.generador_alertas.consumer;

import com.kafka.generador_alertas.dto.AlertDTO;
import com.kafka.generador_alertas.dto.SignoVitalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SignalConsumer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final double THRESHOLD = 100.0; // Ejemplo: umbral para generar alertas

    @KafkaListener(topics = "signal", groupId = "alert-group")
    public void consumeSignal(SignoVitalDTO signal) {
        System.out.println("Recibido: " + signal);

        // Si el valor de la señal es superior al umbral, genera una alerta
        if (signal.getValue() > THRESHOLD) {
            AlertDTO alert = new AlertDTO(
                signal.getPatientId(),
                signal.getType() + " - ALta",
                "ALERT",
                LocalDateTime.now()
            );

            // Envía la alerta al topic "alert"
            kafkaTemplate.send("alert", alert);
            System.out.println("⚠️ Alerta generada y enviada: " + alert);
        }
    }
}
