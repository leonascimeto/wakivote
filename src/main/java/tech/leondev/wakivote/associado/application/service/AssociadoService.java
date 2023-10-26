package tech.leondev.wakivote.associado.application.service;

import tech.leondev.wakivote.associado.application.api.AssociadoRequestDTO;
import tech.leondev.wakivote.associado.application.api.AssociadoResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AssociadoService {
    AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO);

    List<AssociadoResponseDTO> lista();

    AssociadoResponseDTO buscaPorId(UUID idAssociado);

    AssociadoResponseDTO buscaPorCpf(String cpf);

    void altera(UUID idAssociado, AssociadoRequestDTO associadoRequestDTO);
}
