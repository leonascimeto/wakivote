package tech.leondev.wakivote.associado.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/associados")
public interface AssociadoAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AssociadoResponseDTO salva(@RequestBody @Valid AssociadoRequestDTO associadoRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<AssociadoResponseDTO> lista();

    @GetMapping("/{idAssociado}")
    @ResponseStatus(HttpStatus.OK)
    AssociadoResponseDTO buscarPorId(@PathVariable UUID idAssociado);
}
