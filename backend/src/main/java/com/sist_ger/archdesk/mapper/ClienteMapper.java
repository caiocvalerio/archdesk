package com.sist_ger.archdesk.mapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sist_ger.archdesk.dto.ClienteDTO;
import com.sist_ger.archdesk.model.Cliente;

@Component
public class ClienteMapper {

    public List<ClienteDTO> converterLista(List<Cliente> clienteList) {
        if (clienteList == null || clienteList.isEmpty()) {
            return List.of();
        }

        return clienteList.stream()
                .map(cliente -> new ClienteDTO(
                        cliente.getId(),
                        cliente.getNome().toUpperCase(),
                        cliente.getEmail(),
                        cliente.getTelefone()))
                .toList();
    }

    public ClienteDTO converterEntidade(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone());
    }

    public ClienteDTO converterEntidade(Optional<Cliente> clienteOptional) {
        if (clienteOptional == null) {
            return null;
        }

        return clienteOptional
                .map(cliente -> new ClienteDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getTelefone()))
                .orElse(null);
    }

    public Cliente converterDTO(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }

        return new Cliente(
                UUID.randomUUID(),
                clienteDTO.getNome().toUpperCase(),
                clienteDTO.getTelefone(),
                clienteDTO.getEmail().toUpperCase());
    }
}
