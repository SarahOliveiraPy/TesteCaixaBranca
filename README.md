# Projeto de Login (TESTE DE CAIXA BRANCA)
O que é este projeto?
Este projeto é um exemplo básico de como implementar um sistema de login utilizando Java e MySQL. Ele se conecta a um banco de dados para verificar se o nome de usuário e a senha estão corretos.

## Grafo de Fluxo
## O grafo abaixo representa os fluxos lógicos do método verificarUsuario, destacando as ações, decisões e saídas:

![image](https://github.com/user-attachments/assets/139b7349-aad6-45d5-bffd-5ca775ff5705)


# Legenda dos Pontos Numerados
Aqui estão os principais pontos do método verificarUsuario:

1. **Ponto 1**:Inicializa a variável result como false.

2. **Ponto 2**:Conecta ao banco de dados chamando o método conectarBD.

3. **Ponto 3**:Verifica se a conexão (conn) é null.

4. **Ponto 4**: Retorna false se a conexão falhar.

5. **Ponto 5**:Cria a consulta SQL para buscar o usuário com login e senha.

6. **Ponto 6**:Cria um Statement para executar a consulta SQL.

7. **Ponto 7**:Executa a consulta SQL e obtém o ResultSet.

8. **Ponto 8**: Verifica se o ResultSet contém dados.

9. **Ponto 9**: Atualiza result para true se os dados forem encontrados.

10. **Ponto 10**: Atualiza o nome do usuário com o valor do banco.

11. **Ponto 11**:Fecha o ResultSet.

12. **Ponto 12**:Fecha o Statement.

13. **Ponto 13**:Fecha a conexão com o banco de dados.

14. **Ponto 14**:Trata exceções que podem ocorrer durante o processo.

15. **Ponto 15**:Imprime a exceção usando e.printStackTrace().

16. **Ponto 16**:Retorna o valor de result.

# Complexidade Ciclômica
A complexidade ciclomática é 4, o que indica que existem 4 caminhos básicos no método.

# Caminhos Básicos
Os caminhos básicos do método verificarUsuario são:

Caminho 1: Start → Ponto 1 → Ponto 2 → Ponto 3 (Sim) → Ponto 4 → End.
Caminho 2: Start → Ponto 1 → Ponto 2 → Ponto 3 (Não) → Ponto 5 → Ponto 6 → Ponto 7 → Ponto 14 → Ponto 15 → End.
Caminho 3: Start → Ponto 1 → Ponto 2 → Ponto 3 (Não) → Ponto 5 → Ponto 6 → Ponto 7 → Ponto 8 (Não) → Ponto 11 → Ponto 12 → Ponto 13 → Ponto 16 → End.
Caminho 4: Start → Ponto 1 → Ponto 2 → Ponto 3 (Não) → Ponto 5 → Ponto 6 → Ponto 7 → Ponto 8 (Sim) → Ponto 9 → Ponto 10 → Ponto 11 → Ponto 12 → Ponto 13 → Ponto 16 → End.

Abaixo estão os erros encontrados nesse código, que não o deixam eficiente.

## Vulnerabilidade a SQL Injection:
Os valores de login e senha são adicionados diretamente à consulta SQL, sem nenhuma validação ou proteção, tornando o código inseguro.

## Driver MySQL incorreto:
O nome do driver especificado (com.mysql.Driver.Manager) não é válido. Deveria ser algo como com.mysql.cj.jdbc.Driver.

## Tratamento de exceções vazio: 
Os blocos catch não fazem nada. Isso dificulta descobrir e corrigir problemas, já que os erros ficam "silenciados".

## Conexões não fechadas:
A conexão com o banco de dados (conn), o Statement e o ResultSet não são fechados, o que pode gerar vazamentos de recursos.

## URL de conexão desatualizada:
A URL JDBC utilizada não segue os padrões modernos para conexão com o MySQL.

## Checagem de conexão ausente:
O código não verifica se a conexão retornada (conn) é válida antes de usá-la, o que pode gerar erros caso falhe a conexão.

## Uso desnecessário de .newInstance():
A chamada Class.forName(...).newInstance() é obsoleta e desnecessária.


## Inicialização inútil da variável sql:
A variável sql é iniciada com uma string vazia, mas isso não é útil, pois ela é sobrescrita logo em seguida.

## Campo 'nome' sem propósito:
Apesar de capturar o valor do nome no banco, ele não é usado em nenhuma outra parte do código.



