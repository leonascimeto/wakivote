package tech.leondev.wakivote.sessao_votacao.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Sessões", description = "Recurso para gerenciamento das sessões de votações.")
@RestController
@RequestMapping("v1/sessao-votacoes")
public interface SessaoVotacaoAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SessaoVotacaoResponseDTO abreSessao(@RequestBody @Valid SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO);

    @PostMapping("/votos")
    @ResponseStatus(HttpStatus.CREATED)
    VotoResponseDTO adicionaVoto(@RequestBody @Valid VotoRequestDTO votoRequestDTO);

    @GetMapping("{idSessaoVotacao}/resultado")
    @ResponseStatus(HttpStatus.OK)
    SessaoVotacaoResultadoResponseDTO apuraResultadoSessao(@PathVariable UUID idSessaoVotacao);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<SessaoVotacaoResponseDTO> listaSessao();

    @GetMapping("/{idSessaoVotacao}")
    @ResponseStatus(HttpStatus.OK)
    SessaoVotacaoResponseDTO buscaSessao(@PathVariable UUID idSessaoVotacao);

    @DeleteMapping("/{idSessaoVotacao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaSessao(@PathVariable UUID idSessaoVotacao);
}
