package tech.leondev.wakivote.associado.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.domain.Associado;
import tech.leondev.wakivote.handler.ApiException;

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
                        .orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Associado não encontrado"));
        log.info("[end] AssociadoInfraRepository - buscaPorId");
        return associado;
    }

    @Override
    public Associado buscaPorCpf(String cpf) {
        log.info("[start] AssociadoInfraRepository - buscaPorCpf");
        Associado associado = associadoSpringDataJPARepository.findByCpf(cpf)
                .orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Associado não encontrado"));
        log.info("[end] AssociadoInfraRepository - buscaPorCpf");
        return associado;
    }

    @Override
    public void deleta(Associado associado) {
        log.info("[start] AssociadoInfraRepository - deleta");
        associadoSpringDataJPARepository.delete(associado);
        log.info("[end] AssociadoInfraRepository - deleta");
    }
}
