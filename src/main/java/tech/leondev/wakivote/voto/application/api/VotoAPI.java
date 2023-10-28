package tech.leondev.wakivote.voto.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/votos")
public interface VotoAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    VotoResponseDTO executaVoto(@RequestBody @Valid VotoRequestDTO votoRequestDTO);
}
