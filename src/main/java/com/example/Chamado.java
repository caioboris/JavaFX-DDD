package com.example;

import java.util.ArrayList;

public record Chamado(String nmUsuario, String cdEquipamento, Categoria categoria, ArrayList<Atividade> atividades) {
    
    @Override
    public String toString(){
        var strAtividades = "";
        return nmUsuario + ": " + cdEquipamento + " - "+ categoria+ " - " + atividades;
    }
}

enum Categoria 
{
    Computador,
    Impressora,
    Rede
}

enum Atividade 
{
    PrimeiroContato,
    Atendido,
    Encerrado
}

