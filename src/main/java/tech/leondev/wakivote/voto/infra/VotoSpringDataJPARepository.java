package tech.leondev.wakivote.voto.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakivote.voto.domain.Voto;

import java.util.UUID;

public interface VotoSpringDataJPARepository extends JpaRepository<Voto, UUID> {
}
