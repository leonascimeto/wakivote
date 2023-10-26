package tech.leondev.wakivote.associado.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakivote.associado.domain.Associado;

import java.util.UUID;

public interface AssociadoSpringDataJPARepository extends JpaRepository<Associado, UUID> {
}
