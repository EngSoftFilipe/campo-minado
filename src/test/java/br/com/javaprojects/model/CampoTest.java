package br.com.javaprojects.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// CampoTest ao invés de CampoTeste porque o Maven (mvn test), por padrão só executa classes que terminam com "Test", "Tests" ou "TestCase"
public class CampoTest {
    
    private Campo campo;

    // Os vizinhos serão as 8 posições do array ao redor de (3,3)
    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3, 3);
    }

    // vizinhos começam em (2,2) e terminam em (4,4), sendo (3,3) o centro
    @Test 
    void testeVizinhoDistancia(){
        Campo vizinho = new Campo(4, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }
}
