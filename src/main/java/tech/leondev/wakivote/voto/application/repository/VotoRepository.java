package tech.leondev.wakivote.voto.application.repository;

import tech.leondev.wakivote.voto.domain.Voto;

public interface VotoRepository {
    Voto salva(Voto voto);
}
