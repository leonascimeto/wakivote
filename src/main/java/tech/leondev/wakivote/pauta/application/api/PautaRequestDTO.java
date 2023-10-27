package tech.leondev.wakivote.pauta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class PautaRequestDTO {
    @NotBlank
    @Size(min = 6)
    private String descricao;
}
