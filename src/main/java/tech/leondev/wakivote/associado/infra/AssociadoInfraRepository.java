package tech.leondev.wakivote.associado.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.domain.Associado;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Associado> lista() {
        log.info("[start] AssociadoInfraRepository - lista");
        List<Associado> associados = associadoSpringDataJPARepository.findAll();
        log.info("[end] AssociadoInfraRepository - lista");
        return associados;
    }

    @Override
    public Associado buscaPorId(UUID idAssociado) {
        log.info("[start] AssociadoInfraRepository - buscaPorId");
        Associado associado = associadoSpringDataJPARepository.findById(idAssociado)
                        .orElseThrow(() -> new RuntimeException("Associado não encontrado"));
        log.info("[end] AssociadoInfraRepository - buscaPorId");
        return associado;
    }
}
