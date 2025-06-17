
# 📑 Documentação do Modelo de Dados 

Versão: MVP

---

## 🗃️ Tabelas e Campos

---

### Tabela: Cliente

| Campo | Tipo | PK/FK | Obrigatório | Observações |
|---|---|---|---|---|
| id | UUID / SERIAL | PK | S |  |
| nome | VARCHAR |  | S |  |
| telefone | VARCHAR |  | N |  |
| email | VARCHAR |  | N |  |
| endereco | TEXT |  | N |  |

---

### Tabela: Projeto

| Campo | Tipo | PK/FK | Obrigatório | Observações |
|---|---|---|---|---|
| id | UUID / SERIAL | PK | S |  |
| nome | VARCHAR |  | S |  |
| tipo_projeto | VARCHAR |  | N | Ex: Residencial, Comercial, Reforma |
| status | VARCHAR |  | N | Ex: Em andamento, Concluído, Orçado |
| orçamento_previsto | DECIMAL |  | N |  |
| orçamento_realizado | DECIMAL |  | N |  |
| cronograma | DATE |  | N |  |
| cliente_id | UUID / SERIAL | FK | S | Ref → Cliente(id) |

---

### Tabela: Tarefa

| Campo | Tipo | PK/FK | Obrigatório | Observações |
|---|---|---|---|---|
| id | UUID / SERIAL | PK | S |  |
| descricao | TEXT |  | S |  |
| prazo | DATE |  | N |  |
| status | VARCHAR |  | N | Ex: Aberta, Concluída, Cancelada |
| projeto_id | UUID / SERIAL | FK | S | Ref → Projeto(id) |

---

### Tabela: Financeiro

| Campo | Tipo | PK/FK | Obrigatório | Observações |
|---|---|---|---|---|
| id | UUID / SERIAL | PK | S |  |
| tipo | VARCHAR |  | S | Receita / Despesa |
| valor | DECIMAL |  | S |  |
| descricao | TEXT |  | N |  |
| data | DATE |  | S |  |
| projeto_id | UUID / SERIAL | FK | S | Ref → Projeto(id) |

---

### Tabela: EventoAgenda

| Campo | Tipo | PK/FK | Obrigatório | Observações |
|---|---|---|---|---|
| id | UUID / SERIAL | PK | S |  |
| titulo | VARCHAR |  | S | Ex: Reunião, Entrega de Etapa |
| descricao | TEXT |  | N |  |
| data_hora_inicio | TIMESTAMP |  | S |  |
| data_hora_fim | TIMESTAMP |  | N |  |
| projeto_id | UUID / SERIAL | FK | N | Ref → Projeto(id) (Opcional) |

---

### Tabela: Documento

| Campo | Tipo | PK/FK | Obrigatório | Observações |
|---|---|---|---|---|
| id | UUID / SERIAL | PK | S |  |
| nome_arquivo | VARCHAR |  | S | Nome original do arquivo |
| caminho_arquivo | VARCHAR |  | S | Caminho de armazenamento |
| tipo | VARCHAR |  | N | Ex: PDF, JPG, DWG |
| data_upload | TIMESTAMP |  | S |  |
| projeto_id | UUID / SERIAL | FK | S | Ref → Projeto(id) |

---

## 🗺️ Diagrama ER
![Diagrama ER](./docs/modelo_er.png)

---

## ✅ Observações Gerais:

- Todas as chaves primárias (PK) podem ser UUID ou SERIAL.
- Todos os campos de relacionamento estão marcados como FK.
- O relacionamento principal é: Cliente → Projeto → Tarefas / Financeiro / Eventos / Documentos.
