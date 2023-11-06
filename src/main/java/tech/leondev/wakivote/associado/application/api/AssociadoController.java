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
public class AssociadoController implements AssociadoAPI{
    private final AssociadoService associadoService;
    @Override
    public AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO) {
        log.info("[start] AssociadoController - salva");
        AssociadoResponseDTO associadoResponseDTO = associadoService.salva(associadoRequestDTO);
        log.info("[end] AssociadoController - salva");
        return associadoResponseDTO;
    }

    @Override
    public List<AssociadoResponseDTO> lista() {
        log.info("[start] AssociadoController - lista");
        List<AssociadoResponseDTO> associados = associadoService.lista();
        log.info("[end] AssociadoController - lista");
        return associados;
    }

    @Override
    public AssociadoResponseDTO buscarPorId(UUID idAssociado) {
        log.info("[start] AssociadoController - buscarPorId");
        AssociadoResponseDTO associado = associadoService.buscaPorId(idAssociado);
        log.info("[end] AssociadoController - buscarPorId");
        return associado;
    }

    @Override
    public AssociadoResponseDTO buscaPorCpf(String cpf) {
        log.info("[start] AssociadoController - buscaPorCpf");
        AssociadoResponseDTO associado = associadoService.buscaPorCpf(cpf);
        log.info("[end] AssociadoController - buscaPorCpf");
        return associado;
    }

    @Override
    public void alteraAssociado(UUID idAssociado, AssociadoRequestDTO associadoRequestDTO) {
        log.info("[start] AssociadoController - alteraAssociado");
        associadoService.altera(idAssociado, associadoRequestDTO);
        log.info("[end] AssociadoController - alteraAssociado");
    }

    @Override
    public void deletaAssociado(UUID idAssociado) {
        log.info("[start] AssociadoController - deletaAssociado");
        associadoService.deleta(idAssociado);
        log.info("[end] AssociadoController - deletaAssociado");
    }
}
