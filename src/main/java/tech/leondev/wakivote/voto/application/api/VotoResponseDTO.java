package tech.leondev.wakivote.voto.application.api;

import lombok.Value;
import tech.leondev.wakivote.associado.application.api.AssociadoResponseDTO;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoResponseDTO;
import tech.leondev.wakivote.voto.domain.Voto;
import tech.leondev.wakivote.voto.domain.VotoEnum;

import java.util.UUID;

@Value
public class VotoResponseDTO {
    private SessaoVotacaoResponseDTO sessao;
    private AssociadoResponseDTO associado;
    private VotoEnum voto;

    public VotoResponseDTO(Voto votoSalvo) {
        this.sessao = new SessaoVotacaoResponseDTO(votoSalvo.getSessaoVotacao());
        this.associado = new AssociadoResponseDTO(votoSalvo.getAssociado());
        this.voto = votoSalvo.getVoto();
    }
}
