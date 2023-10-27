package tech.leondev.wakivote.sessao_votacao.application.service;

import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoRequestDTO;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoResponseDTO;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoVotacaoResponseDTO abreSessao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO);
    SessaoVotacaoResponseDTO buscaPorId(UUID idSessaoVotacao);
}
