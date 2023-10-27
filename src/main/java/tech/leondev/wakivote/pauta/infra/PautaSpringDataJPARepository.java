package tech.leondev.wakivote.pauta.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID> {
}
