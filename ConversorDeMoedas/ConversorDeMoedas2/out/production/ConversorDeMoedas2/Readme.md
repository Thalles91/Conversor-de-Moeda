# Conversor de Moedas

Este é um simples conversor de moedas escrito em Java que utiliza a API da ExchangeRate-API para obter taxas de câmbio atualizadas. O usuário pode escolher uma moeda de origem, inserir um valor a ser convertido, escolher uma moeda de destino e obter o valor convertido. O programa permite realizar múltiplas conversões até que o usuário opte por sair.

## Funcionalidades

- Seleção de moedas de origem e destino.
- Conversão de valores baseada nas taxas de câmbio atuais.
- Opção para realizar múltiplas conversões.

## Pré-requisitos

- Java 11 ou superior
- Biblioteca `Gson` para parsing de JSON

## Como Usar

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/conversor-de-moedas.git
    cd conversor-de-moedas
    ```

2. Adicione a biblioteca `Gson` ao seu projeto. Você pode baixá-la [aqui](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.6/gson-2.8.6.jar) ou usar um gerenciador de dependências como Maven ou Gradle.

3. Compile e execute o programa:

    ```bash
    javac -cp gson-2.8.6.jar Main.java
    java -cp .:gson-2.8.6.jar Main
    ```

4. Siga as instruções exibidas no console para realizar suas conversões de moeda.

## Exemplo de Uso

1. O programa solicita ao usuário para escolher uma moeda de origem.
2. O usuário insere o código da moeda (por exemplo, "USD" para Dólar Americano).
3. O programa exibe as taxas de câmbio atuais para as moedas suportadas.
4. O usuário insere o valor a ser convertido.
5. O programa solicita ao usuário para escolher uma moeda de destino.
6. O valor convertido é exibido.
7. O programa pergunta se o usuário deseja realizar outra conversão.

## Suporte a Moedas

- ARS - Peso Argentino
- BOB - Boliviano Boliviano
- BRL - Real Brasileiro
- CLP - Peso Chileno
- COP - Peso Colombiano
- USD - Dólar Americano

```

Certifique-se de ajustar a seção de instalação conforme o método que você está utilizando para gerenciar dependências, como Maven ou Gradle.