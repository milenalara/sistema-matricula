# Requisitos funcionais e não funcionais  
 
## Requisitos funcionais  
| ID     | Descrição do Requisito | Prioridade |  Depende de |
|--------|------------------------|------------|-------------|  
| RF-001 | O sistema deve permitir o gerenciamento de disciplinas, devendo conter informações sobre nome, carga horária, ementa e status (indefinido, ativa ou cancelada). | ALTA |  |
| RF-002 | O sistema deve permitir o gerenciamento de cursos, devendo conter informações sobre nome, número de créditos e disciplinas. | ALTA | RF-001 |
| RF-003 | O sistema deve permitir o gerenciamento de alunos, devendo conter informações sobre nome completo, senha de acesso, número de matrícula e CPF. | ALTA |  |
| RF-004 | O sistema deve permitir o gerenciamento do período de matrícula, devendo conter informações sobre data e hora de início e data e hora de fim. | ALTA |  |
| RF-005 | O sistema deve permitir que funcionários administrativos, alunos e professores acessem o sistema somente mediante autenticação com usuário e senha. No caso de alunos, o usuário deve ser o número de matrícula. | ALTA |  |
| RF-006 | O sistema deve permitir que alunos efetuem a matrícula em disciplinas dentro do período estabelecido. Os alunos devem poder incluir ou cancelar disciplinas. | ALTA | RF-004, RF-005 |
| RF-007 | Terminado o período de matrícula, o sistema deverá alterar o status das disciplinas de indefinido para ativa (nos casos em que haja pelo menos 3 alunos matriculados) ou cancelada (nos casos em que haja menos de 3 alunos matriculados). | MÉDIA | RF-004 |
| RF-008 | O sistema deve permitir que professores visualizem a lista de alunos matriculados nas disciplinas que ministram. | MÉDIA | RF-005 |
| RF-009 | O sistema de matrícula deve notificar o sistema de cobranças sobre as disciplinas em que cada aluno foi matriculado. | MÉDIA | RF-006, RF-007 |

  
## Requisitos não funcionais  
| ID | Descrição do Requisito | Prioridade |  
|--|--|--|  
| RNF-001 | O sistema deverá ser desenvolvido em Java | ALTA |  
| RFN-002 | O sistema deverá ser uma aplicação de console | ALTA |  
| RFN-003 | Os dados das entidades do sistema devem ser salvos em listas | |  
