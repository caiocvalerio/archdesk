package com.sist_ger.archdesk.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @PrePersist
    public void idGerado() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
