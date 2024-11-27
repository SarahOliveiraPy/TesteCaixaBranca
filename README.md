## Teste de Caixa Branca

### GRAFO CÓDIGO

![image](https://github.com/user-attachments/assets/d854b698-6852-4114-883a-a581507cca25)


### Abaixo estão os erros encontrados nesse código, que não o deixam eficiente.

🗯️Vulnerabilidade a SQL Injection:
Os valores de login e senha são adicionados diretamente à consulta SQL, sem nenhuma validação ou proteção, tornando o código inseguro.

🗯️Driver MySQL incorreto:
O nome do driver especificado (com.mysql.Driver.Manager) não é válido. Deveria ser algo como com.mysql.cj.jdbc.Driver.

🗯️Tratamento de exceções vazio:
Os blocos catch não fazem nada. Isso dificulta descobrir e corrigir problemas, já que os erros ficam "silenciados".

🗯️Conexões não fechadas:
A conexão com o banco de dados (conn), o Statement e o ResultSet não são fechados, o que pode gerar vazamentos de recursos.

🗯️URL de conexão desatualizada:
A URL JDBC utilizada não segue os padrões modernos para conexão com o MySQL.

🗯️Checagem de conexão ausente:
O código não verifica se a conexão retornada (conn) é válida antes de usá-la, o que pode gerar erros caso falhe a conexão.

🗯️Uso desnecessário de .newInstance():
A chamada Class.forName(...).newInstance() é obsoleta e desnecessária.


🗯️Inicialização inútil da variável sql:
A variável sql é iniciada com uma string vazia, mas isso não é útil, pois ela é sobrescrita logo em seguida.

🗯️Campo 'nome' sem propósito:
Apesar de capturar o valor do nome no banco, ele não é usado em nenhuma outra parte do código.

### Complexidade Ciclômica
A complexidade ciclômica do método foi calculada como:

\[
M = E - N + 2P = 10 - 8 + 2 = 4
\]

### Caminhos Básicos
Os caminhos básicos identificados no método são:

1. **Caminho 1**: \(P1 → P2 → P3 → P8\)  
   - Fluxo em que a conexão falha.
2. **Caminho 2**: \(P1 → P2 → P3 → P4 → P5 → P6 → P8\)  
   - Conexão válida, mas consulta sem resultados.
3. **Caminho 3**: \(P1 → P2 → P3 → P4 → P5 → P6 → P7 → P8\)  
   - Conexão válida e consulta retorna resultados.
4. **Caminho 4**: Fluxo em que exceções ocorrem (erros não tratados).

![image](https://github.com/user-attachments/assets/fbe09f7d-00a4-4999-8d0b-e21d9625900b)

