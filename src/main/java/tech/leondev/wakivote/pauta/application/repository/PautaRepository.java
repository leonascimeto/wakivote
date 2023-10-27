package tech.leondev.wakivote.pauta.application.repository;

import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;

public interface PautaRepository {
    Pauta salva(Pauta pauta);

    List<Pauta> lista();
}
