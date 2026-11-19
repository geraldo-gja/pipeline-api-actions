# Pipeline API Actions 🚀

API REST desenvolvida com Spring Boot voltada para demonstração e validação de pipelines de CI/CD utilizando GitHub Actions.

---

## 🛠️ Tecnologias e Versões

| Componente | Versão |
| :--- | :--- |
| **Java** | 25 |
| **Spring Boot** | 4.1.2 |
| **Gradle** | 9.9.1 (Kotlin DSL) |
| **JUnit** | 5 (JUnit Platform) |

---

## 📋 Pré-requisitos

- **JDK 25** instalado e configurado na variável de ambiente `JAVA_HOME`.
- Não é necessário ter o Gradle instalado globalmente; utilize o **Gradle Wrapper** incluído no projeto (`gradlew` / `gradlew.bat`).

---

## 🚀 Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/<seu-usuario>/pipeline-api-actions.git
cd pipeline-api-actions
```

### 2. Rodar a aplicação

**No Windows (PowerShell / CMD):**
```powershell
.\gradlew.bat bootRun
```

**No Linux / macOS:**
```bash
./gradlew bootRun
```

A aplicação iniciará por padrão na porta **`8080`**.

---

## 🧪 Como Executar os Testes

Para executar os testes unitários e de integração:

**No Windows:**
```powershell
.\gradlew.bat test
```

**No Linux / macOS:**
```bash
./gradlew test
```

> O relatório detalhado de testes é gerado em: `build/reports/tests/test/index.html`.

---

## 📦 Como Gerar o Pacote (JAR)

Para compilar, rodar os testes e gerar o artefato executável (`.jar`):

```powershell
# Windows
.\gradlew.bat build

# Linux / macOS
./gradlew build
```

O arquivo gerado ficará disponível em:
```
build/libs/api_actions-0.0.1-SNAPSHOT.jar
```

Para rodar diretamente o `.jar` gerado:
```bash
java -jar build/libs/api_actions-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Endpoints Disponíveis

| Método | Rota | Descrição | Resposta de Exemplo |
| :--- | :--- | :--- | :--- |
| **GET** | `/` | Endpoint raiz com status da API | `"Projeto GitHub Actions - V1: API ativa e operando com sucesso!"` |
| **GET** | `/status` | Validação de status e versão | `"Projeto GitHub Actions - V1: API ativa e operando com sucesso!"` |
| **GET** | `/api/status` | Alias para verificação de saúde | `"Projeto GitHub Actions - V1: API ativa e operando com sucesso!"` |

### Exemplos de Requisição:

**Via Navegador:**
Acesse [http://localhost:8080/status](http://localhost:8080/status)

**Via cURL:**
```bash
curl -X GET http://localhost:8080/status
```

**Via PowerShell:**
```powershell
Invoke-RestMethod -Uri http://localhost:8080/status
```

---

## 🏗️ Estrutura do Projeto

```
pipeline-api-actions/
├── .github/              # Workflows do GitHub Actions (CI/CD)
├── gradle/wrapper/       # Configuração e binários do Gradle Wrapper
├── src/
│   ├── main/
│   │   ├── java/com/pipeline/api_actions/
│   │   │   ├── ApiActionsApplication.java   # Classe principal
│   │   │   └── controller/
│   │   │       └── PipelineController.java  # Controller REST (GET)
│   │   └── resources/
│   │       └── application.yaml             # Configurações da aplicação
│   └── test/
│       └── java/com/pipeline/api_actions/
│           ├── ApiActionsApplicationTests.java
│           └── controller/
│               └── PipelineControllerTest.java # Testes unitários com MockMvc
├── build.gradle.kts      # Script de build do Gradle
└── gradlew / gradlew.bat # Scripts executáveis do Gradle Wrapper
```

---

## 🔄 Integração com GitHub Actions

Este projeto foi estruturado para integração contínua (CI). Em uma pipeline típica do GitHub Actions:
1. O runner instala o Java 25.
2. O Gradle Wrapper executa a validação e compilação: `./gradlew check`.
3. Os testes automatizados em `PipelineControllerTest` validam a estabilidade antes do deploy ou merge.
