package com.vitor.crudjava.modules.cliente.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitor.crudjava.modules.cliente.models.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long>{
    List<ClienteEntity> findAllBy(Pageable pageable);
} 