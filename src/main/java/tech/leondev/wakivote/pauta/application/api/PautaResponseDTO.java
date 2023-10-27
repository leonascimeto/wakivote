package tech.leondev.wakivote.pauta.application.api;

import lombok.Value;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PautaResponseDTO {
    private UUID idPauta;
    private String descricao;

    public PautaResponseDTO(Pauta pauta) {
        this.idPauta = pauta.getIdPauta();
        this.descricao = pauta.getDescricao();
    }

    public static List<PautaResponseDTO> convertePautasParaListaDTO(List<Pauta> pautas) {
        return pautas.stream().map(PautaResponseDTO::new).collect(Collectors.toList());
    }
}
