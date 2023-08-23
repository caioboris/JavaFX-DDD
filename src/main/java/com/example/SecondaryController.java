package com.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML TextField txtPalavra;
    @FXML TextArea txtLista;
    @FXML Label mensagem;

    private ArrayList<String> palavras = new ArrayList();

  public void testar(){
    //pegar a palavra
    String palavra = txtPalavra.getText();

    //verificar se é palindromo

    String reverseStr = "";
    int strLength = palavra.length();

    for (int i = (strLength - 1); i >=0; --i) {
        reverseStr = reverseStr + palavra.charAt(i);
    }

    if (palavra.toLowerCase().equals(reverseStr.toLowerCase())) {
        palavras.sort((p1,p2) ->{
            return Integer.compare(p1.length(), p2.length());
        });
        atualizar();
    }
    else {
        mensagem.setText("Não é um palindromo!");
    }

    //ordenar por tamanho

    //adicionar na textArea
  }

private void atualizar() {

    palavras.forEach((palavra)->{
        txtLista.appendText(palavra);
    });
}
}