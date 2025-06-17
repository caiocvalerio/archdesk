package com.sist_ger.archdesk.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist_ger.archdesk.dto.ClienteDTO;
import com.sist_ger.archdesk.mapper.ClienteMapper;
import com.sist_ger.archdesk.model.Cliente;
import com.sist_ger.archdesk.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        List<ClienteDTO> clienteDTOs = clienteMapper.converterLista(clientes);
        return ResponseEntity.ok(clienteDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable UUID id) {
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteDTO clienteDTO = clienteMapper.converterEntidade(cliente);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.converterDTO(clienteDTO);
        Cliente clienteSalvo = clienteService.salvar(cliente);
        ClienteDTO clienteResposta = clienteMapper.converterEntidade(clienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResposta);
    }
}
