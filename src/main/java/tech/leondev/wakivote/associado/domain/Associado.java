package tech.leondev.wakivote.associado.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakivote.associado.application.api.AssociadoRequestDTO;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "associados")
@Entity(name = "associados")
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idAssociado;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    private String cpf;

    public Associado(AssociadoRequestDTO associadoRequestDTO){
        this.nome = associadoRequestDTO.getNome();
        this.cpf = associadoRequestDTO.getCpf();
    }
}
