package br.com.mottu.mottuapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mottu.mottuapi.model.Patio;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
}
