package tech.leondev.wakivote.associado.application.api;

import lombok.Value;
import tech.leondev.wakivote.associado.domain.Associado;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class AssociadoResponseDTO {
    private UUID idAssociado;
    private String nome;
    private String cpf;

    public AssociadoResponseDTO(Associado associado) {
        this.idAssociado = associado.getIdAssociado();
        this.nome = associado.getNome();
        this.cpf = associado.getCpf();
    }

    public static List<AssociadoResponseDTO> converteListaAssociadoParaDTO(List<Associado> associados) {
        return associados.stream().map(AssociadoResponseDTO::new).collect(Collectors.toList());
    }
}
