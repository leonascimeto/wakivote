package tech.leondev.wakivote.associado.application.repository;

import tech.leondev.wakivote.associado.domain.Associado;

import java.util.List;
import java.util.UUID;

public interface AssociadoRepository {
    Associado salva(Associado associado);

    List<Associado> lista();

    Associado buscaPorId(UUID idAssociado);

    Associado buscaPorCpf(String cpf);
}
