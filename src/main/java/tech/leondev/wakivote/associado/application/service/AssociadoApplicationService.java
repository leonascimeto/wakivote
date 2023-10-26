package tech.leondev.wakivote.associado.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.associado.application.api.AssociadoRequestDTO;
import tech.leondev.wakivote.associado.application.api.AssociadoResponseDTO;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.domain.Associado;

@Log4j2
@RequiredArgsConstructor
@Service
public class AssociadoApplicationService implements AssociadoService{
    private final AssociadoRepository associadoRepository;
    @Override
    public AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO) {
        log.info("[start] AssociadoApplicationService - salva");
        Associado associado = associadoRepository.salva(new Associado(associadoRequestDTO));
        log.info("[end] AssociadoApplicationService - salva");
        return new AssociadoResponseDTO(associado);
    }
}