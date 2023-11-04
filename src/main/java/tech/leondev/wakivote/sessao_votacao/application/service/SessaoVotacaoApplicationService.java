package tech.leondev.wakivote.sessao_votacao.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.application.service.AssociadoService;
import tech.leondev.wakivote.associado.domain.Associado;
import tech.leondev.wakivote.pauta.application.repository.PautaRepository;
import tech.leondev.wakivote.pauta.domain.Pauta;
import tech.leondev.wakivote.sessao_votacao.application.api.*;
import tech.leondev.wakivote.sessao_votacao.application.repository.SessaoVotacaoRepository;
import tech.leondev.wakivote.sessao_votacao.domain.SessaoVotacao;
import tech.leondev.wakivote.sessao_votacao.domain.Voto;
import tech.leondev.wakivote.sessao_votacao.domain.VotoEnum;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class SessaoVotacaoApplicationService implements SessaoVotacaoService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final AssociadoRepository associadoRepository;
    private final PautaRepository pautaRepository;
    private final AssociadoService associadoService;

    @Override
    public SessaoVotacaoResponseDTO abreSessao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO) {
        log.info("[start] SessaoVotacaoApplicationService - salva");
        Pauta pauta = pautaRepository.buscaPorId(sessaoVotacaoRequestDTO.getIdPauta());
        SessaoVotacao sessaoVotacao = new SessaoVotacao(sessaoVotacaoRequestDTO);
        sessaoVotacao.adicionarPauta(pauta);
        SessaoVotacao sessaoVotacaoSalva = sessaoVotacaoRepository.salva(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - salva");
        return new SessaoVotacaoResponseDTO(sessaoVotacaoSalva);
    }

    @Override
    public VotoResponseDTO adicionaVoto(VotoRequestDTO votoRequestDTO) {
        log.info("[start] SessaoVotacaoApplicationService - adicionaVoto");
        Associado associado = associadoRepository.buscaPorCpf(votoRequestDTO.getCpf());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(votoRequestDTO.getIdSessaoVotacao());
        sessaoVotacao.validaHorarioSessaoParaVotar();
        sessaoVotacao.validaAssociado(associado, associadoService);
        Voto voto = new Voto(associado, sessaoVotacao, votoRequestDTO.getVoto());
        sessaoVotacao.adicionarVoto(voto);
        sessaoVotacaoRepository.salva(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - adicionaVoto");
        return new VotoResponseDTO(voto);
    }

    @Override
    public SessaoVotacaoResponseDTO buscaPorId(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoApplicationService - buscaPorId");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(idSessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - buscaPorId");

        return new SessaoVotacaoResponseDTO(sessaoVotacao);
    }

    @Override
    public List<SessaoVotacaoResponseDTO> lista() {
        log.info("[start] SessaoVotacaoApplicationService - lista");
        List<SessaoVotacao> sessoes = sessaoVotacaoRepository.lista();
        log.info("[end] SessaoVotacaoApplicationService - lista");
        return SessaoVotacaoResponseDTO.convertListaSessoesParaDTO(sessoes);
    }

    @Override
    public void deleta(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoApplicationService - deleta");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(idSessaoVotacao);
        sessaoVotacaoRepository.deleta(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - deleta");
    }

    @Override
    public SessaoVotacaoResultadoResponseDTO apuraResultado(UUID idSessaoVotacao) {
        log.info("[start] SessaoVotacaoApplicationService - deleta");
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.buscaPorId(idSessaoVotacao);
        Map<VotoEnum, Long> resultado = sessaoVotacao.apurarVotos();
        sessaoVotacao.fechaSessao();
        sessaoVotacaoRepository.salva(sessaoVotacao);
        log.info("[end] SessaoVotacaoApplicationService - deleta");
        return new SessaoVotacaoResultadoResponseDTO(sessaoVotacao, resultado);
    }
}
