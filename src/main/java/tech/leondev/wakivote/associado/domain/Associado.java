package tech.leondev.wakivote.associado.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
