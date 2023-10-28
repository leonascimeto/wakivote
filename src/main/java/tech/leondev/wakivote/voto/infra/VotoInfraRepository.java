package tech.leondev.wakivote.voto.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.voto.application.repository.VotoRepository;
import tech.leondev.wakivote.voto.domain.Voto;

@Log4j2
@RequiredArgsConstructor
@Repository
public class VotoInfraRepository implements VotoRepository {
    private final VotoSpringDataJPARepository votoSpringDataJPARepository;

    @Override
    public Voto salva(Voto voto) {
        log.info("[start] VotoInfraRepository - salva");
        Voto votoSalvo = votoSpringDataJPARepository.save(voto);
        log.info("[end] VotoInfraRepository - salva");
        return votoSalvo;
    }
}
