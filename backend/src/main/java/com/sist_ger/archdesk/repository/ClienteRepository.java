package com.sist_ger.archdesk.repository;

import org.springframework.stereotype.Repository;

import com.sist_ger.archdesk.model.Cliente;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
