# Tratamento de Exceções em Java

Este repositório demonstra a evolução das boas práticas no tratamento de exceções em Java, comparando três abordagens — da pior para a melhor.

---

## 📁 Estrutura do Projeto

```
src/
├── ExExceptionPers1/   → ❌ Forma muito ruim
├── ExExceptionPers2/   → ⚠️ Forma ruim
└── ExExceptionPers3/   → ✅ Forma correta
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

## 💡 Lição Principal

> Sempre que uma exceção representa um erro de **domínio/negócio**, crie uma classe dedicada para ela. Isso torna o código mais expressivo, fácil de manter e alinhado com boas práticas de orientação a objetos.

---

## 🛠️ Tecnologias

- Java 25 | IntelliJ IDEA

## **👨🏻‍💻** Autor

Feito por **André Peixoto Cano**
