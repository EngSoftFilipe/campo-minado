# Anotações

- **@Test:** Marca o método como um teste que o JUnit vai rodar.
- **@BeforeEach:** Roda antes de cada teste, então todo teste começa com um campo novo.
- **@DisplayName:** Dá um nome pro teste aparecer no relatório.

# Assertions (Verificações)

- **assertEquals(esperado, real):** Compara o valor esperado com o valor real: se forem iguais, o teste passa (verde); se não, falha (vermelho).
```java
@Test
    void testIfEqualsTwo(){
        int a = 1 + 1;
        assertEquals(2, a);
    }

// O resultado será o esperado, porque 1 + 1 é = 2
```
- **assertNotEquals(naoEsperado, real):** Passa se a condição for verdadeira (assertTrue) ou falsa (assertFalse).
```java
@Test
    void testWithNotEquals(){
        String x = "Filipe";
        assertNotEquals("filipe", x);
    }

// O resultado será o esperado, porque "Filipe" é diferente de "filipe"
```
- **assertTrue & assertFalse:** Passa se a condição for verdadeira ou falsa.
```java
@Test
void testeVizinhoDistancia() {
    Campo vizinho = new Campo(3, 2);
    boolean resultado = campo.adicionarVizinho(vizinho);
    assertTrue(resultado);
}
// Passa, porque (3,2) está do lado de (3,3), então é vizinho
```