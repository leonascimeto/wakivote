package tech.leondev.wakivote.associado.application.service;

import tech.leondev.wakivote.associado.application.api.AssociadoRequestDTO;
import tech.leondev.wakivote.associado.application.api.AssociadoResponseDTO;

public interface AssociadoService {
    AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO);
}
