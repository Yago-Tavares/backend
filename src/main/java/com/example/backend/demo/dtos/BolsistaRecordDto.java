package com.example.backend.demo.dtos;


import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BolsistaRecordDto(@NotBlank String nome, @NotBlank String tipo_id, @NotNull int num_id, @NotNull Date data_matricula, @NotNull int cod_banco, @NotNull int num_agencia, @NotNull int num_conta) {
    
}
