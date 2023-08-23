package com.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField nmUsuario;
    @FXML TextField cdEquipamento;
    @FXML RadioButton catComputador;
    @FXML RadioButton catImpressora;
    @FXML RadioButton catRede;
    @FXML CheckBox atvPrimeiroContato;
    @FXML CheckBox atvAtendido;
    @FXML CheckBox atvEncerrado;

    @FXML ListView<Chamado> lista;
    
    ArrayList<Chamado> chamados = new ArrayList<>();

    public void adicionarChamado(){
        
        var categoria = Categoria.Computador;
        var atividades = new ArrayList<Atividade>();

        if(atvPrimeiroContato.isSelected())
            atividades.add(Atividade.PrimeiroContato);
        if(atvAtendido.isSelected())
            atividades.add(Atividade.Atendido);
        if(atvEncerrado.isSelected())
            atividades.add(Atividade.Encerrado);

        if(catImpressora.isSelected())
            categoria = Categoria.Impressora;
        if(catRede.isSelected())
            categoria = Categoria.Rede;

        var chamado = new Chamado(
            nmUsuario.getText(),
            cdEquipamento.getText(),
            categoria,
            atividades
        );

        chamados.add(chamado);
        
        nmUsuario.clear();
        cdEquipamento.clear();
        
        atualizarTela();
    }
    
    private void atualizarTela() {
        lista.getItems().clear();
        for(var chamado: chamados){
            lista.getItems().add(chamado);
        }
    }

    public void apagar(){
        var chamado = lista.getSelectionModel().getSelectedItem();

        Alert mensAlert = new Alert(AlertType.CONFIRMATION);
        mensAlert.setHeaderText("Atenção!");
        mensAlert.setContentText("Você tem certeza que deseja excluir o chamado da lista?");
        var resposta = mensAlert.showAndWait();

        if(resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
            chamados.remove(chamado);
            atualizarTela();
        }
    }

    public void editar(){
        var chamado = lista.getSelectionModel().getSelectedItem();

        
        nmUsuario.setText(chamado.nmUsuario());
        cdEquipamento.setText(chamado.cdEquipamento());
        
        if(chamado.categoria() == Categoria.Computador)
            catComputador.setSelected(true);
        if(chamado.categoria() == Categoria.Impressora)
            catImpressora.setSelected(true);
        if(chamado.categoria() == Categoria.Computador)
            catRede.setSelected(true);

        chamado.atividades().forEach((atividade) ->{
            if(atividade == Atividade.Atendido){
                atvAtendido.setSelected(true);
            }
            if(atividade == Atividade.PrimeiroContato){
                atvPrimeiroContato.setSelected(true);
            }
            if(atividade == Atividade.Encerrado){
                atvAtendido.setSelected(true);
            }
        });
        
        Alert mensAlert = new Alert(AlertType.CONFIRMATION);
        mensAlert.setHeaderText("Atenção!");
        mensAlert.setContentText("Você tem certeza que deseja editar o chamado da lista?");
        var resposta = mensAlert.showAndWait();
        

        if(resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
            chamados.remove(chamado);
            atualizarTela();
        }
    }

}



