package tech.leondev.wakivote.pauta.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakivote.pauta.application.service.PautaService;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PautaController implements PautaAPI{
    private final PautaService pautaService;

    @Override
    public PautaResponseDTO salva(PautaRequestDTO pautaRequestDTO) {
        log.info("[start] PautaController - salva");
        PautaResponseDTO pauta = pautaService.salva(new Pauta(pautaRequestDTO));
        log.info("[end] PautaController - salva");
        return pauta;
    }

    @Override
    public List<PautaResponseDTO> lista() {
        log.info("[start] PautaController - lista");
        List<PautaResponseDTO> pautas = pautaService.lista();
        log.info("[end] PautaController - lista");
        return pautas;
    }
}
