package tech.leondev.wakivote.pauta.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.pauta.application.repository.PautaRepository;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Repository
public class PautaInfraRepository implements PautaRepository {
    private final PautaSpringDataJPARepository pautaSpringDataJPARepository;
    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[start] PautaInfraRepository - salva");
        Pauta pautaSaved = pautaSpringDataJPARepository.save(pauta);
        log.info("[end] PautaInfraRepository - salva");
        return pautaSaved;
    }

    @Override
    public List<Pauta> lista() {
        log.info("[start] PautaInfraRepository - lista");
        List<Pauta> pautas = pautaSpringDataJPARepository.findAll();
        log.info("[end] PautaInfraRepository - lista");
        return pautas;
    }
}
