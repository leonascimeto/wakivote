package tech.leondev.wakivote.associado.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.domain.Associado;

@Log4j2
@RequiredArgsConstructor
@Repository
public class AssociadoInfraRepository implements AssociadoRepository {
    private final AssociadoSpringDataJPARepository associadoSpringDataJPARepository;

    @Override
    public Associado salva(Associado associado) {
        log.info("[start] AssociadoInfraRepository - salva");
        Associado associadoSaved = associadoSpringDataJPARepository.save(associado);
        log.info("[end] AssociadoInfraRepository - salva");
        return associadoSaved;
    }
}
