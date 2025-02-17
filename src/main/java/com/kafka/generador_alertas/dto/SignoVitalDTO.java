package com.kafka.generador_alertas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignoVitalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long patientId;
    private String type;
    private Double value;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    // Constructor vacío (necesario para la serialización)
    public SignoVitalDTO() {}

    // Constructor con parámetros
    public SignoVitalDTO(Long patientId, String type, Double value, LocalDateTime timestamp) {
        this.patientId = patientId;
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    // Getters y Setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
