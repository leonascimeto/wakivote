package tech.leondev.wakivote.sessao_votacao.application.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakivote.pauta.application.api.PautaResponseDTO;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class SessaoVotacaoResponseDTO {
    private UUID idSessaoVotacao;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private PautaResponseDTO pauta;

    public SessaoVotacaoResponseDTO(SessaoVotacao sessaoVotacaoSalva) {
        this.idSessaoVotacao = sessaoVotacaoSalva.getIdSessaoVotacao();
        this.dataAbertura = sessaoVotacaoSalva.getDataAbertura();
        this.dataFechamento = sessaoVotacaoSalva.getDataFechamento();
        this.pauta = new PautaResponseDTO(sessaoVotacaoSalva.getPauta());
    }
}
