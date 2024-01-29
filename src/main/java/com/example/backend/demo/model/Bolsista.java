package com.example.backend.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bolsistas")
public class Bolsista implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id_bolsista;
    private String nome;
    private String tipo_id;
    private int num_id;
    private Date data_matricula;
    private int cod_banco;
    private int num_agencia;
    private int num_conta;

    public UUID getId_bolsista() {
        return this.id_bolsista;
    }

    public void setId_bolsista(UUID id_bolsista) {
        this.id_bolsista = id_bolsista;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_id() {
        return this.tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getNum_id() {
        return this.num_id;
    }

    public void setNum_id(int num_id) {
        this.num_id = num_id;
    }

    public Date getData_matricula() {
        return this.data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public int getCod_banco() {
        return this.cod_banco;
    }

    public void setCod_banco(int cod_banco) {
        this.cod_banco = cod_banco;
    }

    public int getNum_agencia() {
        return this.num_agencia;
    }

    public void setNum_agencia(int num_agencia) {
        this.num_agencia = num_agencia;
    }

    public int getNum_conta() {
        return this.num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }


     
}
