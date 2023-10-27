package tech.leondev.wakivote.pauta.application.service;

import tech.leondev.wakivote.pauta.application.api.PautaResponseDTO;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;

public interface PautaService {
    PautaResponseDTO salva(Pauta pauta);

    List<PautaResponseDTO> lista();
}
