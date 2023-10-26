package tech.leondev.wakivote.associado.application.api;

import lombok.Value;
import tech.leondev.wakivote.associado.domain.Associado;

@Value
public class AssociadoResponseDTO {
    private String nome;
    private String cpf;

    public AssociadoResponseDTO(Associado associado) {
        this.nome = associado.getNome();
        this.cpf = associado.getCpf();
    }
}
