package tech.leondev.wakivote.associado.application.service;

import tech.leondev.wakivote.associado.application.api.AssociadoRequestDTO;
import tech.leondev.wakivote.associado.application.api.AssociadoResponseDTO;

import java.util.List;

public interface AssociadoService {
    AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO);

    List<AssociadoResponseDTO> lista();
}
