# Teste de Caixa Branca

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

![Grafo de Fluxo]
## O grafo abaixo representa os fluxos lógicos do método verificarUsuario, destacando as ações, decisões e saídas:

![image](https://github.com/user-attachments/assets/fd317842-af20-4cfb-a820-07cb9eb02e45)
