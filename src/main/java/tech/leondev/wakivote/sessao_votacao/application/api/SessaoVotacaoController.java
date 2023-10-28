package tech.leondev.wakivote.sessao_votacao.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakivote.sessao_votacao.application.service.SessaoVotacaoService;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class SessaoVotacaoController implements SessaoVotacaoAPI{
    private final SessaoVotacaoService sessaoVotacaoService;

    @Override
    public SessaoVotacaoResponseDTO abreSessao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO) {
        log.info("[start] SessaoVotacaoController - salva");
        SessaoVotacaoResponseDTO sessaoVotacao = sessaoVotacaoService.abreSessao(sessaoVotacaoRequestDTO);
        log.info("[end] SessaoVotacaoController - salva");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacaoResponseDTO buscaSessao(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoController - buscaSessaso");
        SessaoVotacaoResponseDTO sessaoVotacao = sessaoVotacaoService.buscaPorId(idSessaoVotacao);
        log.info("[end] SessaoVotacaoController - buscaSessaso");
        return sessaoVotacao;
    }

    @Override
    public List<SessaoVotacaoResponseDTO> listaSessao() {
        log.info("[start] SessaoVotacaoController - listaSessao");
        List<SessaoVotacaoResponseDTO> sessoes = sessaoVotacaoService.lista();
        log.info("[end] SessaoVotacaoController - listaSessao");
        return sessoes;
    }
}
