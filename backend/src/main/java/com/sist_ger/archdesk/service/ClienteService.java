package com.sist_ger.archdesk.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist_ger.archdesk.model.Cliente;
import com.sist_ger.archdesk.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(UUID id) {
        return clienteRepository
                .findById(id)
                .orElseThrow();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
