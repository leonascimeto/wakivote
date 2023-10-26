package tech.leondev.wakivote.associado.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakivote.associado.application.service.AssociadoService;

@Log4j2
@RequiredArgsConstructor
@RestController
public class AssociadoControllerDTO implements AssociadoAPI{
    private final AssociadoService associadoService;
    @Override
    public AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO) {
        log.info("[start] AssociadoControllerDTO - salva");
        AssociadoResponseDTO associadoResponseDTO = associadoService.salva(associadoRequestDTO);
        log.info("[end] AssociadoControllerDTO - salva");
        return associadoResponseDTO;
    }
}
