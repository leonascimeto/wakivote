package tech.leondev.wakivote.sessao_votacao.application.repository;

import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

public interface SessaoVotacaoRepository {
    SessaoVotacao abreSessao(SessaoVotacao sessaoVotacaoSalva);
}
