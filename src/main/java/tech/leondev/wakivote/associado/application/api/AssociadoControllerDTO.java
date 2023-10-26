package tech.leondev.wakivote.associado.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakivote.associado.application.service.AssociadoService;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<AssociadoResponseDTO> lista() {
        log.info("[start] AssociadoControllerDTO - lista");
        List<AssociadoResponseDTO> associados = associadoService.lista();
        log.info("[end] AssociadoControllerDTO - lista");
        return associados;
    }

    @Override
    public AssociadoResponseDTO buscarPorId(UUID idAssociado) {
        log.info("[start] AssociadoControllerDTO - buscarPorId");
        AssociadoResponseDTO associado = associadoService.buscaPorId(idAssociado);
        log.info("[end] AssociadoControllerDTO - buscarPorId");
        return associado;
    }
}
