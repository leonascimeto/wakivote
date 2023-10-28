package tech.leondev.wakivote.sessao_votacao.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;

import java.util.UUID;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID> {
}
