package tech.leondev.wakivote.voto.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.domain.Associado;
import tech.leondev.wakivote.sessao_votacao.application.repository.SessaoVotacaoRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;
import tech.leondev.wakivote.voto.application.api.VotoRequestDTO;
import tech.leondev.wakivote.voto.application.api.VotoResponseDTO;
import tech.leondev.wakivote.voto.application.repository.VotoRepository;
import tech.leondev.wakivote.voto.domain.Voto;

@Log4j2
@RequiredArgsConstructor
@Service
public class VotoApllicationService implements VotoService{
    private final VotoRepository votoRepository;
    private final AssociadoRepository associadoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    @Override
    public VotoResponseDTO adicionaVoto(VotoRequestDTO votoRequestDTO) {
        log.info("[start] VotoApllicationService - salva");
        Associado associado = associadoRepository.buscaPorCpf(votoRequestDTO.getCpf());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(votoRequestDTO.getIdSessaoVotacao());
        sessaoVotacao.validaHorarioSessaoParaVotar();
        sessaoVotacao.validaAssociadoJaVotou(associado);
        Voto voto = new Voto(associado, sessaoVotacao, votoRequestDTO.getVoto());
        sessaoVotacao.adicionarVoto(voto);
        sessaoVotacaoRepository.salva(sessaoVotacao);
        log.info("[end] VotoApllicationService - salva");
        return new VotoResponseDTO(voto);
    }
}
