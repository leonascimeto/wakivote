package tech.leondev.wakivote.pauta.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakivote.pauta.application.api.PautaResponseDTO;
import tech.leondev.wakivote.pauta.application.repository.PautaRepository;
import tech.leondev.wakivote.pauta.domain.Pauta;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class PautaApplicationService implements PautaService{
    private final PautaRepository pautaRepository;

    @Override
    public PautaResponseDTO salva(Pauta pauta) {
        log.info("[start] PautaApplicationService - salva");
        Pauta pautaSaved = pautaRepository.salva(pauta);
        log.info("[end] PautaApplicationService - salva");
        return new PautaResponseDTO(pautaSaved);
    }

    @Override
    public List<PautaResponseDTO> lista() {
        log.info("[start] PautaApplicationService - lista");
        List<Pauta> pautas = pautaRepository.lista();
        log.info("[end] PautaApplicationService - lista");
        return PautaResponseDTO.convertePautasParaListaDTO(pautas);
    }
}
