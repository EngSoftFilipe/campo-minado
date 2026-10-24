package br.com.javaprojects.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.javaprojects.exceptions.ExplosaoException;
import br.com.javaprojects.exceptions.SairException;
import br.com.javaprojects.model.Tabuleiro;

public class TabuleiroConsole {
    
    private Tabuleiro tabuleiro;
    private Scanner sc = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;

        executarJogo();
    }

    private void executarJogo(){
        try{
            boolean continuar = true;
            while (continuar) {
                loopDoJogo();

                System.out.println("Outra partida? (S/n)");
                String resposta = sc.nextLine();

                if("n".equalsIgnoreCase(resposta)){
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch(SairException e){
            System.out.println("Até logo...");
        } finally {
            sc.close();
        }
    }

    private void loopDoJogo(){
        try{
            while (!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);

                try{
                    String digitado = capturarValorDigitado("Digite (linha, coluna): ");
                    Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(e -> Integer.parseInt(e.trim())).iterator();

                    digitado = capturarValorDigitado("1 - Abrir | 2 - Marcar ou desmarcar: ");

                    if("1".equals(digitado)){
                        tabuleiro.abrir(xy.next(), xy.next());
                    } else if ("2".equals(digitado)){
                        tabuleiro.marcar(xy.next(), xy.next());
                    }
                } catch(NumberFormatException | NoSuchElementException e){
                    System.out.println("Entrada inválida! Use o formato: linha, coluna");
                }
            }

            System.out.println(tabuleiro);
            System.out.println("Você Ganhou!!!");
        } catch(ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("Você Perdeu!");
        }
    }

    private String capturarValorDigitado(String texto){
        System.out.print(texto);
        String digitado = sc.nextLine();

        if("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }
        return digitado;
    }
}