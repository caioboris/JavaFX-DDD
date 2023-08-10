package com.example;

import java.util.ArrayList;
import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextArea txtAlunos;
    @FXML TextField txtNome;
    
    ArrayList<String> alunos = new ArrayList<>();

    public void adicionarAluno(){
        alunos.add(txtNome.getText());
        txtNome.clear();
        atualizarTela();
    }
    
    private void atualizarTela() {
        ordenar();
        txtAlunos.clear();
        for(var aluno: alunos){
            txtAlunos.appendText(aluno + "\n");
        }
    }

    private void ordenar() {
        //anonymous class
        alunos.sort( (o1, o2) -> o1.compareToIgnoreCase(o2) );
    }

}



