# Tratamento de Exceções em Java

Repositório criado para documentar a evolução das boas práticas no tratamento de exceções em Java, combinando três abordagens comparativas e dois exercícios desenvolvidos de forma independente.

---

## 📁 Estrutura do Projeto
```
src/
├── ExExceptionPers1/      → ❌ Forma muito ruim
├── ExExceptionPers2/      → ⚠️ Forma ruim
├── ExExceptionPers3/      → ✅ Forma correta
├── ExExceptionFixacao/    → 🏋️ Exercício 1 — Conta Bancária
└── ExExceptionFixacao2/   → 🏋️ Exercício 2 — Sistema de Pagamentos
```

---

## ❌ ExExceptionPers1 — Forma Muito Ruim

Nesta abordagem, o tratamento de exceções é feito de maneira totalmente inadequada. Os principais problemas são:

- Erros de lógica e de validação são ignorados ou tratados de forma genérica, sem nenhuma separação de responsabilidades.
- Não há distinção entre tipos de erro, tornando o código difícil de depurar e manter.
- Mensagens de erro pouco informativas para o usuário final.
- O código mistura regras de negócio com o tratamento de exceções diretamente na classe principal.

---

## ⚠️ ExExceptionPers2 — Forma Ruim

Uma tentativa de melhoria, mas ainda com problemas relevantes:

- Apesar de haver alguma separação, as exceções ainda não são encapsuladas de forma adequada.
- A classe principal ainda carrega responsabilidades que não deveriam ser dela.
- O código começa a ficar mais legível, mas a arquitetura ainda não está bem definida.

---

## ✅ ExExceptionPers3 — Forma Correta

Esta é a abordagem recomendada. As melhorias em relação às anteriores são:

- Foi criada uma classe dedicada exclusivamente para representar a exceção de domínio (`DomainException`), seguindo o princípio de **responsabilidade única (SRP)**.
- A exceção personalizada estende a hierarquia correta, permitindo tratamento específico e semântico dos erros.
- O código fica mais limpo, reutilizável e fácil de manter.
- A separação entre **entidades**, **exceções** e a **classe principal** reflete uma arquitetura mais profissional.

### Estrutura do ExExceptionPers3

```
ExExceptionPers3/
└── model/
    ├── entities/
    │   └── Reservation3.java       → Entidade de reserva
    └── exceptions/
        └── DomainException.java    → Exceção de domínio personalizada
ExExceptionPers3.java               → Classe principal
```

---

## 🏋️ ExExceptionFixacao — Exercício 1: Conta Bancária

Exercício desenvolvido de forma independente praticando exceções customizadas com regras de negócio reais.

- Criação da exceção `WithdrawException` para representar erros de saque
- Validação de limite de saque e saldo insuficiente com `throw`
- Método `withdraw()` declarado com `throws WithdrawException`
- `try/catch` com múltiplos catches no `Main.java`
- Separação em pacotes `model.entities` e `model.exceptions`

### Estrutura do ExExceptionFixacao

```
ExExceptionFixacao/
└── model/
    ├── entities/
    │   └── Account.java            → Entidade de conta bancária
    └── exceptions/
        └── WithdrawException.java  → Exceção de saque personalizada
Main.java                           → Classe principal
```

---

## 🏋️ ExExceptionFixacao2 — Exercício 2: Sistema de Pagamentos

Exercício desenvolvido de forma independente combinando **classes abstratas**, **polimorfismo** e **exceções customizadas** num único sistema.

- Classe abstrata `Employee` com método abstrato `payment()`
- Subclasses `Outsourced` e `Effective` com regras de cálculo diferentes
- Exceção `PaymentException` lançada quando o pagamento for inválido
- Lista polimórfica `List<Employee>` armazenando os dois tipos
- `try/catch` dentro do loop de exibição para tratar cada funcionário individualmente
- Total acumulado de pagamentos exibido ao final

### Estrutura do ExExceptionFixacao2

```
ExExceptionFixacao2/
└── model/
    ├── entities/
    │   ├── Employee.java           → Classe abstrata base
    │   ├── Outsourced.java         → Funcionário terceirizado
    │   └── Effective.java          → Funcionário efetivo
    └── exceptions/
        └── PaymentException.java   → Exceção de pagamento personalizada
Main.java                           → Classe principal
```

---

## 💡 Lição Principal

> Sempre que uma exceção representa um erro de **domínio/negócio**, crie uma classe dedicada para ela. Isso torna o código mais expressivo, fácil de manter e alinhado com boas práticas de orientação a objetos.

---

## 🛠️ Tecnologias

Java 25 · IntelliJ IDEA · Git e GitHub

---

## 👨🏻‍💻 Autor

Feito por **André Peixoto Cano**
