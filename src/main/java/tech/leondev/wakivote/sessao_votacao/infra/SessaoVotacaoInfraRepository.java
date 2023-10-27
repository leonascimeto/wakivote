package tech.leondev.wakivote.sessao_votacao.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.sessao_votacao.application.repository.SessaoVotacaoRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

@Log4j2
@RequiredArgsConstructor
@Repository
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
    private final SessaoVtacaoSpringDataJPARepository sessaoVtacaoSpringDataJPARepository;

    @Override
    public SessaoVotacao abreSessao(SessaoVotacao sessaoVotacaoSalva) {
        log.info("[start] SessaoVotacaoInfraRepository - salva");
        SessaoVotacao sessaoVotacao = sessaoVtacaoSpringDataJPARepository.save(sessaoVotacaoSalva);
        log.info("[end] SessaoVotacaoInfraRepository - salva");
        return sessaoVotacao;
    }
}
