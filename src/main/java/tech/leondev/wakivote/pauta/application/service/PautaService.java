package tech.leondev.wakivote.pauta.application.service;

import tech.leondev.wakivote.pauta.application.api.PautaResponseDTO;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;
import java.util.UUID;

public interface PautaService {
    PautaResponseDTO salva(Pauta pauta);

    List<PautaResponseDTO> lista();

    PautaResponseDTO buscaPorId(UUID idPauta);
}
