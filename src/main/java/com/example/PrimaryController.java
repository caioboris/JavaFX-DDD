package com.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML TextField txtNome;
    @FXML TextField txtTurma;
    @FXML TextField txtRm;
    @FXML ListView<Aluno> lista;
    @FXML RadioButton optOrdenarPorNome;
    @FXML RadioButton optOrdenarPorTurma;
    
    ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(){
        
        var aluno = new Aluno(
            txtNome.getText(),
            txtTurma.getText(),
            Integer.valueOf(txtRm.getText())
        );

        alunos.add(aluno);
        
        txtNome.clear();
        txtTurma.clear();
        txtRm.clear();
        
        atualizarTela();
    }
    
    private void atualizarTela() {
        ordenar();
        lista.getItems().clear();
        for(var aluno: alunos){
            lista.getItems().add(aluno);
        }
    }

    private void ordenar() {
        //anonymous class
        if(optOrdenarPorNome.isSelected())
            alunos.sort( (o1, o2) -> o1.nome().compareToIgnoreCase(o2.nome()) );
            
        if(optOrdenarPorTurma.isSelected())
            alunos.sort( (o1, o2) -> o1.turma().compareToIgnoreCase(o2.turma()) );
    }

    public void apagar(){
        var aluno = lista.getSelectionModel().getSelectedItem();

        Alert mensAlert = new Alert(AlertType.CONFIRMATION);
        mensAlert.setHeaderText("Atenção!");
        mensAlert.setContentText("Você tem certeza que deseja excluir o aluno "+ aluno.rm() + " da lista?");
        var resposta = mensAlert.showAndWait();

        if(resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
            alunos.remove(aluno);
            atualizarTela();
        }
    }

}



