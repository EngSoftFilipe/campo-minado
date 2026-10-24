package br.com.javaprojects;

import br.com.javaprojects.model.Tabuleiro;
import br.com.javaprojects.view.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        new TabuleiroConsole(tabuleiro);
    }
}