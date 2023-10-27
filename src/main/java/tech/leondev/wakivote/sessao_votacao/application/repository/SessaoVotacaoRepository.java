package tech.leondev.wakivote.sessao_votacao.application.repository;

import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.util.UUID;

public interface SessaoVotacaoRepository {
    SessaoVotacao abreSessao(SessaoVotacao sessaoVotacaoSalva);

    SessaoVotacao buscaPorId(UUID idSessaoVotacao);
}