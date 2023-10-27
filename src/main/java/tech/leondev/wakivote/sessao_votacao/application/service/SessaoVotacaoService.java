package tech.leondev.wakivote.sessao_votacao.application.service;

import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoRequestDTO;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoResponseDTO;

public interface SessaoVotacaoService {
    SessaoVotacaoResponseDTO abreSessao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO);
}
