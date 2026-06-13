# livebflow-calculadora

Descrição curta: Aplicação MVC (Spring Boot + Thymeleaf) para calcular fianças locatícias.

Estrutura de pastas (principal):

 - src/main/java/com/example/demo/
   - CalculadoraFinController.java (REST controller)
   - controller/ViewController.java (serve views)
   - service/CalculadoraFinService.java (lógica de negócio)
 - src/main/resources/templates/
   - calculadora-fianca.html (view Thymeleaf)
 - src/test/java/... (testes unitários)
 - pom.xml

Classes principais:

 - `CalculadoraFinService` — métodos: calcularPacoteLocacao, calcularSeguroFianca, calcularSeguroMensal, verificarRendaMinima, comprometimentoMaximoRenda
 - `CalculadoraFinController` — endpoints REST que expõem os métodos da service
 - `ViewController` — mapeia `/` para a view `calculadora-fianca.html`

Funcionalidades:

 - Cálculo de pacote (aluguel + condomínio + IPTU)
 - Cálculo de seguro anual e parcela mensal
 - Verificação de renda mínima (multiplicador 3x–4x)
 - Cálculo de comprometimento percentual da renda
 - Front-end simples com chamadas AJAX para os endpoints

Como rodar:

1. Compilar e executar com Maven:

```bash
mvn clean install
mvn spring-boot:run
```

2. Abrir no navegador:

```
http://localhost:8080/
```

3. Rodar testes:

```bash
mvn test
```

