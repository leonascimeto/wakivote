package tech.leondev.wakivote.voto.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakivote.voto.application.service.VotoService;
import tech.leondev.wakivote.voto.domain.Voto;

@Log4j2
@RequiredArgsConstructor
@RestController
public class VotoController implements VotoAPI {
    private final VotoService votoService;
    @Override
    public VotoResponseDTO executaVoto(VotoRequestDTO votoRequestDTO) {
        log.info("[start] VotoController - executaVoto");
        VotoResponseDTO voto = votoService.salva(votoRequestDTO);
        log.info("[end] VotoController - executaVoto");
        return voto;
    }
}
