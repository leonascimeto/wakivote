package tech.leondev.wakivote.pauta.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakivote.pauta.application.api.PautaRequestDTO;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "pautas")
@Entity(name = "pautas")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idPauta;
    @NotBlank
    @Size(min = 6)
    private String descricao;

    @OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SessaoVotacao> sessoesDeVotacao;

    public Pauta(PautaRequestDTO pautaRequestDTO) {
        this.descricao = pautaRequestDTO.getDescricao();
    }

    public void altera(PautaRequestDTO pautaRequestDTO) {
        this.descricao = pautaRequestDTO.getDescricao();
    }
}
