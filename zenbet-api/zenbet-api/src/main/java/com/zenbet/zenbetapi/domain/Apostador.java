package com.zenbet.zenbetapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="apostadores")
@Getter
@Setter
public class Apostador extends Usuario {
    @Column(name = "saldo")
    private float saldo;
}
