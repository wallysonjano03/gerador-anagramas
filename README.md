# Gerador de Anagramas

Um programa Java que gera todas as combinações possíveis de anagramas a partir de um conjunto de letras distintas.

## 🚀 Como executar

### Pré-requisitos
- Java 11+ instalado
- Maven instalado (opcional)

### Via IDE (STS/Eclipse)
1. Importe o projeto Maven
2. Execute a classe `Main` em:  
   `src/main/java/br/com/techsolucoes/anagramas/Main.java`

### Via Terminal
```bash
# Compilar e executar
mvn clean package
java -jar target/gerador-anagramas-1.0.0-SNAPSHOT.jar

# Ou executar diretamente
mvn exec:java -Dexec.mainClass="br.com.techsolucoes.anagramas.Main"