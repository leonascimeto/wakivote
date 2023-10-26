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

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    AssociadoResponseDTO buscaPorCpf(@PathVariable String cpf);

    @PatchMapping("/{idAssociado}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alteraAssociado(@PathVariable UUID idAssociado, @RequestBody @Valid AssociadoRequestDTO associadoRequestDTO);

    @DeleteMapping("/{idAssociado}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaAssociado(@PathVariable UUID idAssociado);
}
