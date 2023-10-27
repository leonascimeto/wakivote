package tech.leondev.wakivote.pauta.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
