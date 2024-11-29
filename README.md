# Projeto de Login (TESTE DE CAIXA BRANCA)
O que é este projeto?
Este projeto é um exemplo básico de como implementar um sistema de login utilizando Java e MySQL. Ele se conecta a um banco de dados para verificar se o nome de usuário e a senha estão corretos.

## Abaixo estão os erros encontrados nesse código, que não o deixam eficiente.

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

![image](https://github.com/user-attachments/assets/c455e0b5-8d12-4a96-98e4-c05b6ab3bc31)

