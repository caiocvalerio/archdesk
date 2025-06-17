package com.sist_ger.archdesk.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
}
