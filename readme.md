# 🛡️ Sistema de Gestão de Estética Automotiva - Wise Dree

## 🎯 Task: WD-104 - Motor de Agendamento e Prevenção de Overbooking

### 📝 Descrição do Desafio
O objetivo desta task é implementar o núcleo de inteligência da agenda. Em um ambiente real de estética automotiva, o erro mais comum (e caro) é o **overbooking**: agendar dois serviços que exigem o mesmo espaço (Box) ou o mesmo profissional para o mesmo horário.

Esta implementação foca em integridade de dados, cálculos de tempo dinâmicos e controle de concorrência.

---

### 🚀 Critérios de Aceite

| Requisito | Descrição |
| :--- | :--- |
| **Cálculo Dinâmico** | O sistema deve calcular automaticamente o `horarioFim` baseado na duração do serviço. |
| **Validação de Conflito** | Impedir agendamentos que se sobreponham no mesmo `Box` ou com o mesmo `Profissional`. |
| **Concorrência** | Garantir que dois agendamentos simultâneos não ocupem a última vaga disponível. |
| **Resposta da API** | Retornar `409 Conflict` quando houver choque de horários. |

---

### 🏗️ Estrutura de Dados Sugerida (Entidades)

- **Serviço**: `id`, `nome`, `duracao_minutos` (ex: Polimento Técnico - 240min).
- **Agendamento**: `id`, `veiculo_id`, `profissional_id`, `box_id`, `data_inicio`, `data_fim`, `status`.

---

### 🛠️ Lógica de Negócio (O "Pulo do Gato")

Para validar se um horário está ocupado, a lógica de SQL recomendada para o intervalo de tempo é:
```sql
-- Um horário conflita se o novo início for antes do fim de um existente 
-- E o novo fim for depois do início de um existente.
(novo_inicio < agendamento_existente.data_fim) AND (novo_fim > agendamento_existente.data_inicio)