package br.com.mottu.mottuapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mottu.mottuapi.dto.PatioRequestDTO;
import br.com.mottu.mottuapi.dto.PatioResponseDTO;
import br.com.mottu.mottuapi.service.PatioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patios")
public class PatioController {

    @Autowired
    private PatioService patioService;

    @PostMapping
    public ResponseEntity<PatioResponseDTO> criar(@Valid @RequestBody PatioRequestDTO dto) {
        PatioResponseDTO response = patioService.salvar(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PatioResponseDTO>> listar() {
        return ResponseEntity.ok(patioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(patioService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        patioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
