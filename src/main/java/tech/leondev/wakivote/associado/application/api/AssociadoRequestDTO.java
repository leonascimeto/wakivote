package tech.leondev.wakivote.associado.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class AssociadoRequestDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
}
