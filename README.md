# Campo Minado
 
Jogo de Campo Minado no terminal, feito em **Java** com testes automatizados em **JUnit**.
 
Projeto desenvolvido durante o curso **Java COMPLETO: Do Zero ao Profissional** (Leonardo Leitão / Cod3r), com foco em orientação a objetos, tratamento de exceções, Stream API e testes unitários.
 
---
 
## Como jogar
 
Ao iniciar, o tabuleiro aparece com todos os campos fechados:
 
```
   0  1  2  3  4  5
0  ?  ?  ?  ?  ?  ?
1  ?  ?  ?  ?  ?  ?
2  ?  ?  ?  ?  ?  ?
3  ?  ?  ?  ?  ?  ?
4  ?  ?  ?  ?  ?  ?
5  ?  ?  ?  ?  ?  ?
```
 
1. Digite a posição no formato `linha, coluna` (ex: `3, 2`)
2. Escolha a ação:
   - `1` → abrir o campo
   - `2` → marcar ou desmarcar o campo
3. Digite `sair` a qualquer momento para encerrar
**Objetivo:** abrir todos os campos sem mina e marcar todos os campos minados.
 
### Legenda
 
| Símbolo | Significado |
|:-------:|-------------|
| `?` | Campo fechado |
| `X` | Campo marcado |
| `*` | Mina (aparece quando você perde) |
| `1` a `8` | Quantidade de minas nos campos vizinhos |
| (vazio) | Campo aberto sem minas por perto |
 
Ao abrir um campo sem minas na vizinhança, os vizinhos são abertos automaticamente.
 
---
 
## Tecnologias
 
- **Java 21**
- **Maven**
- **JUnit Jupiter 6.1.2**
---
 
## Estrutura
 
```
src/
├── main/java/br/com/javaprojects/
│   ├── Aplicacao.java              # Ponto de entrada do jogo
│   ├── model/
│   │   ├── Campo.java              # Regras de cada campo (abrir, marcar, vizinhos)
│   │   └── Tabuleiro.java          # Gera os campos, sorteia minas e controla a partida
│   ├── view/
│   │   └── TabuleiroConsole.java   # Interação com o jogador pelo terminal
│   └── exceptions/
│       ├── ExplosaoException.java  # Lançada ao abrir um campo minado
│       └── SairException.java      # Lançada quando o jogador digita "sair"
└── test/java/br/com/javaprojects/
    └── model/
        └── CampoTest.java          # Testes das regras do Campo
```
 
O projeto separa **regras do jogo** (`model`) da **interface com o jogador** (`view`). Assim, a mesma lógica pode ser reaproveitada em outra interface no futuro, como uma versão gráfica.
 
---
 
## Como executar
 
**Pré-requisitos:** Java 21 e Maven instalados.
 
```bash
# Clonar o repositório
git clone https://github.com/EngSoftFilipe/campo-minado.git
cd campo-minado
 
# Compilar
mvn compile
 
# Rodar o jogo
java -cp target/classes br.com.javaprojects.Aplicacao
```
 
Ou abra o projeto na IDE e execute a classe `Aplicacao`.
 
---
 
## Testes
 
```bash
mvn test
```
 
Os testes do `CampoTest` cobrem:
 
- Regras de vizinhança (campos ao lado e na diagonal)
- Marcar e desmarcar campos
- Abrir campos com e sem mina, marcados e não marcados
- Explosão ao abrir campo minado (`assertThrows`)
- Abertura automática dos vizinhos seguros
---
 
## O que pratiquei neste projeto
 
- Orientação a objetos e encapsulamento
- Exceções personalizadas (`extends RuntimeException`) e `try/catch` em camadas
- Stream API e lambdas (`filter`, `noneMatch`, `allMatch`, `count`, `forEach`)
- Testes unitários com JUnit (`@Test`, `@BeforeEach`, `@DisplayName`, `assertTrue`, `assertFalse`, `assertThrows`)
- Cobertura de testes para encontrar trechos não testados
- Separação entre modelo e visão (MVC)