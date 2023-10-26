package tech.leondev.wakivote.associado.application.repository;

import tech.leondev.wakivote.associado.domain.Associado;

import java.util.List;

public interface AssociadoRepository {
    Associado salva(Associado associado);

    List<Associado> lista();
}
