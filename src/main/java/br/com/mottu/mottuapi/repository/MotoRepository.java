package br.com.mottu.mottuapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mottu.mottuapi.model.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    Page<Moto> findByPlacaContainingIgnoreCase(String placa, Pageable pageable);
}
