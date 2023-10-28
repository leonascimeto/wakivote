package tech.leondev.wakivote.sessao_votacao.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.pauta.application.repository.PautaRepository;
import tech.leondev.wakivote.pauta.domain.Pauta;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoDetalheResponseDTO;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoRequestDTO;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoResponseDTO;
import tech.leondev.wakivote.sessao_votacao.application.repository.SessaoVotacaoRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

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
        SessaoVotacao sessaoVotacaoSalva = sessaoVotacaoRepository.salva(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - salva");
        return new SessaoVotacaoResponseDTO(sessaoVotacaoSalva);
    }

    @Override
    public SessaoVotacaoDetalheResponseDTO buscaPorId(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoApplicationService - buscaPorId");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(idSessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - buscaPorId");

        return new SessaoVotacaoDetalheResponseDTO(sessaoVotacao, sessaoVotacao.apurarVotos());
    }

    @Override
    public List<SessaoVotacaoResponseDTO> lista() {
        log.info("[start] SessaoVotacaoApplicationService - lista");
        List<SessaoVotacao> sessoes = sessaoVotacaoRepository.lista();
        log.info("[end] SessaoVotacaoApplicationService - lista");
        return SessaoVotacaoResponseDTO.convertListaSessoesParaDTO(sessoes);
    }

    @Override
    public void deleta(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoApplicationService - deleta");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(idSessaoVotacao);
        sessaoVotacaoRepository.deleta(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - deleta");
    }
}
