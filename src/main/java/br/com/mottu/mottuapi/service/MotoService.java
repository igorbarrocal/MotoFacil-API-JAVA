package br.com.mottu.mottuapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mottu.mottuapi.dto.MotoRequestDTO;
import br.com.mottu.mottuapi.dto.MotoResponseDTO;
import br.com.mottu.mottuapi.model.Moto;
import br.com.mottu.mottuapi.model.Patio;
import br.com.mottu.mottuapi.repository.MotoRepository;
import br.com.mottu.mottuapi.repository.PatioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PatioRepository patioRepository;

    public MotoResponseDTO salvar(MotoRequestDTO dto) {
        Patio patio = patioRepository.findById(dto.getPatioId())
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));
        validarCoordenadas(dto.getCoordenadaX(), dto.getCoordenadaY(), patio);

        Moto moto = new Moto();
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setMarca(dto.getMarca());
        moto.setLigada(dto.getLigada());
        moto.setCoordenadaX(dto.getCoordenadaX());
        moto.setCoordenadaY(dto.getCoordenadaY());
        moto.setPatio(patio);

        return toResponseDTO(motoRepository.save(moto));
    }

    @Cacheable("motos")
    public Page<MotoResponseDTO> listarTodas(Pageable pageable) {
        return motoRepository.findAll(pageable).map(this::toResponseDTO);
    }

    public Page<MotoResponseDTO> buscarPorPlaca(String placa, Pageable pageable) {
        return motoRepository.findByPlacaContainingIgnoreCase(placa, pageable)
                .map(this::toResponseDTO);
    }

    public MotoResponseDTO buscarPorId(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));
        return toResponseDTO(moto);
    }

    public MotoResponseDTO atualizar(Long id, MotoRequestDTO dto) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));

        Patio patio = patioRepository.findById(dto.getPatioId())
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));

        validarCoordenadas(dto.getCoordenadaX(), dto.getCoordenadaY(), patio);

        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setMarca(dto.getMarca());
        moto.setLigada(dto.getLigada());
        moto.setCoordenadaX(dto.getCoordenadaX());
        moto.setCoordenadaY(dto.getCoordenadaY());
        moto.setPatio(patio);

        return toResponseDTO(motoRepository.save(moto));
    }

    public void deletar(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new EntityNotFoundException("Moto não encontrada");
        }
        motoRepository.deleteById(id);
    }

    private void validarCoordenadas(Integer x, Integer y, Patio patio) {
        if (x != null && y != null) {
            if (x < 0 || y < 0 || x >= patio.getTamanhoX() || y >= patio.getTamanhoY()) {
                throw new IllegalArgumentException("Coordenadas fora dos limites do pátio");
            }
        }
    }

    private MotoResponseDTO toResponseDTO(Moto moto) {
        MotoResponseDTO dto = new MotoResponseDTO();
        dto.setId(moto.getId());
        dto.setPlaca(moto.getPlaca());
        dto.setModelo(moto.getModelo());
        dto.setMarca(moto.getMarca());
        dto.setLigada(moto.getLigada());
        dto.setCoordenadaX(moto.getCoordenadaX());
        dto.setCoordenadaY(moto.getCoordenadaY());
        dto.setPatioNome(moto.getPatio().getNome());
        return dto;
    }
}
