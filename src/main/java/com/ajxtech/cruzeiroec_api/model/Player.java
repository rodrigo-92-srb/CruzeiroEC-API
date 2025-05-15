package com.ajxtech.cruzeiroec_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 50, message = "Age must be at most 50")
    private int age;

    @DecimalMin(value = "1.50", message = "Height must be at least 1.50m")
    @DecimalMax(value = "2.50", message = "Height must be at most 2.50m")
    private double height;

    @DecimalMin(value = "50.0", message = "Weight must be at least 50kg")
    @DecimalMax(value = "120.0", message = "Weight must be at most 120kg")
    private double weight;

    @NotBlank(message = "Role is required")
    private String role;
}
