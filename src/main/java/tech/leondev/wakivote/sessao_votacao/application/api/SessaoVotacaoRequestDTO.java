package tech.leondev.wakivote.sessao_votacao.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class SessaoVotacaoRequestDTO {
    @NotNull
    private LocalDateTime dataAbertura;
    @NotNull
    private LocalDateTime dataFechamento;
    @NotNull
    private UUID idPauta;
}
