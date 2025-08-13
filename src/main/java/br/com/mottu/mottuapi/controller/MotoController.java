package br.com.mottu.mottuapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mottu.mottuapi.dto.MotoRequestDTO;
import br.com.mottu.mottuapi.dto.MotoResponseDTO;
import br.com.mottu.mottuapi.service.MotoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @PostMapping
    public ResponseEntity<MotoResponseDTO> criar(@Valid @RequestBody MotoRequestDTO dto) {
        return ResponseEntity.status(201).body(motoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<MotoResponseDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(motoService.listarTodas(pageable));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<MotoResponseDTO>> buscarPorPlaca(
            @RequestParam String placa,
            Pageable pageable) {
        return ResponseEntity.ok(motoService.buscarPorPlaca(placa, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody MotoRequestDTO dto) {
        return ResponseEntity.ok(motoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
