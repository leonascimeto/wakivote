package tech.leondev.wakivote.pauta.application.repository;

import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;
import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);

    List<Pauta> lista();

    Pauta buscaPorId(UUID idPauta);
}
