package tech.leondev.wakivote.sessao_votacao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import tech.leondev.wakivote.associado.domain.Associado;
import tech.leondev.wakivote.handler.ApiException;
import tech.leondev.wakivote.pauta.domain.Pauta;
import tech.leondev.wakivote.sessao_votacao.application.api.SessaoVotacaoRequestDTO;
import tech.leondev.wakivote.voto.domain.Voto;
import tech.leondev.wakivote.voto.domain.VotoEnum;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Voto> votos;

    public SessaoVotacao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO) {
        this.dataAbertura = LocalDateTime.now();
        long minutosParaAdicionar = sessaoVotacaoRequestDTO.getDuracaoMinutos() == null ? 1 : sessaoVotacaoRequestDTO.getDuracaoMinutos();
        this.dataFechamento = this.dataAbertura.plusMinutes(minutosParaAdicionar);
    }

    public void adicionarPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public void validaHorarioSessaoParaVotar(){
        LocalDateTime now = LocalDateTime.now();
        if(now.isBefore(dataAbertura)) throw ApiException.build(HttpStatus.BAD_REQUEST, "A sessão de votação ainda não foi aberta");
        if(now.isAfter(dataFechamento)) throw ApiException.build(HttpStatus.BAD_REQUEST, "A sessão de votação já foi encerrada");
    }

    public void adicionarVoto(Voto voto) {
        votos.add(voto);
    }

    public void validaAssociadoJaVotou(Associado associado) {
        boolean associadoJaVotou = votos.stream()
                .anyMatch(voto -> voto.getAssociado().equals(associado));
        if(associadoJaVotou)
            throw ApiException.build(HttpStatus.BAD_REQUEST, "O associado já votou nesta sessão de votação.");
    }

    public Map<VotoEnum, Long> apurarVotos(){
        Map<VotoEnum, Long> resultado = new HashMap<>();
        for(VotoEnum votoEnum: VotoEnum.values()){
            long contagem = votos.stream()
                    .filter(voto -> votoEnum.equals(voto.getVoto()))
                    .count();
            resultado.put(votoEnum, contagem);
        }
        return resultado;
    }
}
