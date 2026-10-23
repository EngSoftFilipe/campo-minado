package br.com.javaprojects.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.javaprojects.exceptions.ExplosaoException;

// CampoTest ao invés de CampoTeste porque o Maven (mvn test), por padrão só executa classes que terminam com "Test", "Tests" ou "TestCase"
// Sempre testar com "Teste com cobertura" para ver quais linhas foram testadas, quais não foram e quais foram parcialmente testadas
public class CampoTest {
    
    private Campo campo;

    // Os vizinhos serão as 8 posições do array ao redor de (3,3)
    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3, 3);
    }

    // vizinhos começam em (2,2) e terminam em (4,4), sendo (3,3) o centro
    @Test 
    @DisplayName("Apenas vizinhos entre (2,2) e (4,4)")
    void testeVizinhoDistancia(){
        Campo vizinho = new Campo(4, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test 
    void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }

    @Test 
    void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test 
    void testeAlternarMarcacaoDuasChamadas(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test 
    void testeAbrirSemMinaSemMarcacao(){
        assertTrue(campo.abrir());
    }
    
    @Test 
    void testeAbrirSemMinaMarcado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test 
    void testeAbrirMinadoMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    // Lança a explosão caso acione um local minado
    @Test 
    void testeAbrirMinadoSemMarcacao(){
        campo.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test 
    void testeAbrirComVizinhos1(){
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test 
    void testeAbrirComVizinhos2(){
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 2);
        campo12.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();
        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
}