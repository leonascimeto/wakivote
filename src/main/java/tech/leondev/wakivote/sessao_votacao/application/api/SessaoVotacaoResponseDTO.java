package tech.leondev.wakivote.sessao_votacao.application.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakivote.pauta.application.api.PautaResponseDTO;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public static List<SessaoVotacaoResponseDTO> convertListaSessoesParaDTO(List<SessaoVotacao> sessoes) {
        return sessoes.stream().map(SessaoVotacaoResponseDTO::new).collect(Collectors.toList());
    }
}
