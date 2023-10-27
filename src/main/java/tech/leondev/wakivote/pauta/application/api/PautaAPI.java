package tech.leondev.wakivote.pauta.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/pautas")
public interface PautaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    PautaResponseDTO salva(@RequestBody @Valid PautaRequestDTO pautaRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PautaResponseDTO> lista();

    @GetMapping("/{idPauta}")
    @ResponseStatus(HttpStatus.OK)
    PautaResponseDTO buscaPorId(@PathVariable UUID idPauta);
}
