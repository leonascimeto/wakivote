package tech.leondev.wakivote.associado.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.associado.application.api.AssociadoRequestDTO;
import tech.leondev.wakivote.associado.application.api.AssociadoResponseDTO;
import tech.leondev.wakivote.associado.application.repository.AssociadoRepository;
import tech.leondev.wakivote.associado.domain.Associado;
import tech.leondev.wakivote.associado.infra.client.ConsultaCpfResponse;
import tech.leondev.wakivote.associado.infra.client.SerproClientFeign;
import tech.leondev.wakivote.handler.ApiException;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class AssociadoApplicationService implements AssociadoService{
    private final AssociadoRepository associadoRepository;
    private final SerproClientFeign serproClientFeign;

    @Override
    public AssociadoResponseDTO salva(AssociadoRequestDTO associadoRequestDTO) {
        log.info("[start] AssociadoApplicationService - salva");
        Associado associado = associadoRepository.salva(new Associado(associadoRequestDTO));
        log.info("[end] AssociadoApplicationService - salva");
        return new AssociadoResponseDTO(associado);
    }

    @Override
    public List<AssociadoResponseDTO> lista() {
        log.info("[start] AssociadoApplicationService - list");
        List<Associado> associados = associadoRepository.lista();
        log.info("[end] AssociadoApplicationService - list");
        return AssociadoResponseDTO.converteListaAssociadoParaDTO(associados);
    }

    @Override
    public AssociadoResponseDTO buscaPorId(UUID idAssociado) {
        log.info("[start] AssociadoApplicationService - buscaPorId");
        Associado associado = associadoRepository.buscaPorId(idAssociado);
        log.info("[end] AssociadoApplicationService - buscaPorId");
        return new AssociadoResponseDTO(associado);
    }

    @Override
    public AssociadoResponseDTO buscaPorCpf(String cpf) {
        log.info("[start] AssociadoApplicationService - buscaPorCpf");
        Associado associado = associadoRepository.buscaPorCpf(cpf);
        log.info("[end] AssociadoApplicationService - buscaPorCpf");
        return new AssociadoResponseDTO(associado);
    }

    @Override
    public void altera(UUID idAssociado, AssociadoRequestDTO associadoRequestDTO) {
        log.info("[start] AssociadoApplicationService - altera");
        Associado associado = associadoRepository.buscaPorId(idAssociado);
        associado.altera(associadoRequestDTO);
        associadoRepository.salva(associado);
        log.info("[end] AssociadoApplicationService - altera");
    }

    @Override
    public void deleta(UUID idAssociado) {
        log.info("[start] AssociadoApplicationService - deleta");
        Associado associado = associadoRepository.buscaPorId(idAssociado);
        associadoRepository.deleta(associado);
        log.info("[end] AssociadoApplicationService - deleta");
    }

    @Override
    public void validaAssociadoAptoVoto(String cpf) {
        log.info("[start] AssociadoApplicationService - validaAssociadoAptoVoto");
        ConsultaCpfResponse consultaCpfResponse = serproClientFeign.consultaCpf(TOKEN, cpf);
        valida(consultaCpfResponse);
        log.info("[end] AssociadoApplicationService - validaAssociadoAptoVoto");
    }

    private void valida(ConsultaCpfResponse consultaCpfResponse) {
        if(consultaCpfResponse.isInvalid()){
            throw ApiException.build(HttpStatus.UNPROCESSABLE_ENTITY, "Cpf Inválido");
        }
    }
    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
}
