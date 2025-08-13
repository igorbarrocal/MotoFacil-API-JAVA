package br.com.mottu.mottuapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mottu.mottuapi.dto.PatioRequestDTO;
import br.com.mottu.mottuapi.dto.PatioResponseDTO;
import br.com.mottu.mottuapi.model.Patio;
import br.com.mottu.mottuapi.repository.PatioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    public PatioResponseDTO salvar(PatioRequestDTO dto) {
        Patio patio = new Patio();
        patio.setNome(dto.getNome());
        patio.setEndereco(dto.getEndereco());
        patio.setTamanhoX(dto.getTamanhoX());
        patio.setTamanhoY(dto.getTamanhoY());

        patio = patioRepository.save(patio);
        return toResponseDTO(patio);
    }

    public List<PatioResponseDTO> listarTodos() {
        return patioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PatioResponseDTO buscarPorId(Long id) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));
        return toResponseDTO(patio);
    }

    public void deletar(Long id) {
        if (!patioRepository.existsById(id)) {
            throw new EntityNotFoundException("Pátio não encontrado");
        }
        patioRepository.deleteById(id);
    }

    private PatioResponseDTO toResponseDTO(Patio patio) {
        PatioResponseDTO dto = new PatioResponseDTO();
        dto.setId(patio.getId());
        dto.setNome(patio.getNome());
        dto.setEndereco(patio.getEndereco());
        dto.setTamanhoX(patio.getTamanhoX());
        dto.setTamanhoY(patio.getTamanhoY());
        return dto;
    }
}
