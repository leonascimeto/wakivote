package tech.leondev.wakivote.sessao_votacao.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakivote.associado.domain.Associado;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "votos")
@Entity(name = "votos")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idVoto;
    @Enumerated(EnumType.STRING)
    private VotoEnum voto;

    @ManyToOne
    @JoinColumn(name = "associado_id", nullable = false)
    private Associado associado;

    @ManyToOne
    @JoinColumn(name = "sessao_votacao_id", nullable = false)
    private SessaoVotacao sessaoVotacao;

    public Voto(Associado associado, SessaoVotacao sessaoVotacao, VotoEnum voto) {
        this.voto = voto;
        this.associado = associado;
        this.sessaoVotacao = sessaoVotacao;
    }
}
