package tech.leondev.wakivote.voto.application.service;

import tech.leondev.wakivote.voto.application.api.VotoRequestDTO;
import tech.leondev.wakivote.voto.application.api.VotoResponseDTO;

public interface VotoService {
    VotoResponseDTO adicionaVoto(VotoRequestDTO votoRequestDTO);
}
