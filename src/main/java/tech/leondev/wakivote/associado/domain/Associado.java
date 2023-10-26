package tech.leondev.wakivote.associado.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 caracteres")
    @Column(unique = true)
    private String cpf;

    public Associado(AssociadoRequestDTO associadoRequestDTO){
        this.nome = associadoRequestDTO.getNome();
        this.cpf = associadoRequestDTO.getCpf();
    }

    public void altera(AssociadoRequestDTO associadoRequestDTO) {
        this.nome = associadoRequestDTO.getNome();
        this.cpf = associadoRequestDTO.getCpf();
    }
}
