package tech.leondev.wakivote.sessao_votacao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakivote.pauta.domain.Pauta;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoRequestDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name= "sessao_votacoes")
@Entity(name= "sessao_votacoes")
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idSessaoVotacao;
    @NotNull
    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;
    @NotNull
    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @ManyToOne
    @JoinColumn(name = "pauta_id", nullable = false)
    private Pauta pauta;

    public SessaoVotacao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO) {
        this.dataAbertura = sessaoVotacaoRequestDTO.getDataAbertura();
        this.dataFechamento = sessaoVotacaoRequestDTO.getDataFechamento();
    }

    public void adicionarPauta(Pauta pauta) {
        this.pauta = pauta;
    }
}
