package tech.leondev.wakivote.sessao_votacao.application.repository;

import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacaoSalva);

    SessaoVotacao buscaPorId(UUID idSessaoVotacao);

    List<SessaoVotacao> lista();

    void deleta(SessaoVotacao sessaoVotacao);
}
