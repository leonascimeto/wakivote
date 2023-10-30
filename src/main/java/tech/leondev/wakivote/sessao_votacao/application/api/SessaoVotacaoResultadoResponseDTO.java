package tech.leondev.wakivote.sessao_votacao.application.api;

import lombok.Value;
import tech.leondev.wakivote.pauta.application.api.PautaResponseDTO;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;
import tech.leondev.wakivote.sessao_votacao.domain.VotoEnum;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Value
public class SessaoVotacaoResultadoResponseDTO {
    private UUID idSessaoVotacao;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private PautaResponseDTO pauta;
    private Map<VotoEnum, Long> resultado;

    public SessaoVotacaoResultadoResponseDTO(SessaoVotacao sessaoVotacaoSalva, Map<VotoEnum, Long> contagem) {
        this.idSessaoVotacao = sessaoVotacaoSalva.getIdSessaoVotacao();
        this.dataAbertura = sessaoVotacaoSalva.getDataAbertura();
        this.dataFechamento = sessaoVotacaoSalva.getDataFechamento();
        this.pauta = new PautaResponseDTO(sessaoVotacaoSalva.getPauta());
        this.resultado = contagem;
    }
}
