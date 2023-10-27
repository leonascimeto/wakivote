package tech.leondev.wakivote.sessao_votacao.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.pauta.application.repository.PautaRepository;
import tech.leondev.wakivote.pauta.domain.Pauta;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoRequestDTO;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoResponseDTO;
import tech.leondev.wakivote.sessao_votacao.application.repository.SessaoVotacaoRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

@Log4j2
@RequiredArgsConstructor
@Service
public class SessaoVotacaoApplicationService implements SessaoVotacaoService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaRepository pautaRepository;

    @Override
    public SessaoVotacaoResponseDTO abreSessao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO) {
        log.info("[start] SessaoVotacaoApplicationService - salva");
        Pauta pauta = pautaRepository.buscaPorId(sessaoVotacaoRequestDTO.getIdPauta());
        SessaoVotacao sessaoVotacao = new SessaoVotacao(sessaoVotacaoRequestDTO);
        sessaoVotacao.adicionarPauta(pauta);
        SessaoVotacao sessaoVotacaoSalva = sessaoVotacaoRepository.abreSessao(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - salva");
        return new SessaoVotacaoResponseDTO(sessaoVotacaoSalva);
    }
}
