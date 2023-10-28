package tech.leondev.wakivote.sessao_votacao.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.handler.ApiException;
import tech.leondev.wakivote.sessao_votacao.application.repository.SessaoVotacaoRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
    private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;

    @Override
    public SessaoVotacao abreSessao(SessaoVotacao sessaoVotacaoSalva) {
        log.info("[start] SessaoVotacaoInfraRepository - salva");
        SessaoVotacao sessaoVotacao = sessaoVotacaoSpringDataJPARepository.save(sessaoVotacaoSalva);
        log.info("[end] SessaoVotacaoInfraRepository - salva");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacao buscaPorId(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoInfraRepository - buscaPorId");
        SessaoVotacao sessaoVotacao = sessaoVotacaoSpringDataJPARepository.findById(idSessaoVotacao)
                        .orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Sessão de votação não encontrada"));
        log.info("[end] SessaoVotacaoInfraRepository - buscaPorId");
        return sessaoVotacao;
    }

    @Override
    public List<SessaoVotacao> lista() {
        log.info("[start] SessaoVotacaoInfraRepository - lista");
        List<SessaoVotacao> sessoes = sessaoVotacaoSpringDataJPARepository.findAll();
        log.info("[end] SessaoVotacaoInfraRepository - lista");
        return sessoes;
    }

    @Override
    public void deleta(SessaoVotacao sessaoVotacao) {
        log.info("[start] SessaoVotacaoInfraRepository - deleta");
        sessaoVotacaoSpringDataJPARepository.delete(sessaoVotacao);
        log.info("[end] SessaoVotacaoInfraRepository - deleta");
    }
}
