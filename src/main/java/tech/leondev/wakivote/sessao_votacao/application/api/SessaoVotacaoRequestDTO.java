package tech.leondev.wakivote.sessao_votacao.application.api;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class SessaoVotacaoRequestDTO {
    @Nullable
    private Long duracaoMinutos;
    @NotNull
    private UUID idPauta;
}
