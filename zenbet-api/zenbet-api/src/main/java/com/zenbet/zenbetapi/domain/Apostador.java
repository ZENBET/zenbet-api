package com.zenbet.zenbetapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="apostadores")
public class Apostador extends Usuario {
    @Column(name = "saldo")
    private float saldo;
}
