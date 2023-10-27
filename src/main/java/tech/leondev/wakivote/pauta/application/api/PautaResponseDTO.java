package tech.leondev.wakivote.pauta.application.api;

import lombok.Value;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.UUID;

@Value
public class PautaResponseDTO {
    private UUID idPauta;
    private String descricao;

    public PautaResponseDTO(Pauta pauta) {
        this.idPauta = pauta.getIdPauta();
        this.descricao = pauta.getDescricao();
    }
}
