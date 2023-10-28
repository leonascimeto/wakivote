package tech.leondev.wakivote.voto.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;
import tech.leondev.wakivote.voto.domain.VotoEnum;

import java.util.UUID;

@Value
public class VotoRequestDTO {
    private UUID idSessaoVotacao;
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    private VotoEnum voto;
}
