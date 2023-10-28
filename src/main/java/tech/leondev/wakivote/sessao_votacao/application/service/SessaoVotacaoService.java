package tech.leondev.wakivote.sessao_votacao.application.service;

import tech.leondev.wakivote.sessao_votacao.application.api.*;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoService {
    VotoResponseDTO adicionaVoto(VotoRequestDTO votoRequestDTO);

    SessaoVotacaoResponseDTO abreSessao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO);
    SessaoVotacaoResponseDTO buscaPorId(UUID idSessaoVotacao);

    List<SessaoVotacaoResponseDTO> lista();

    void deleta(UUID idSessaoVotacao);

    SessaoVotacaoResultadoResponseDTO apuraResultado(UUID idSessaoVotacao);
}
