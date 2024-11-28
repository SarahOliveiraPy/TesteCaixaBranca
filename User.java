
/**
 * Classe responsável por gerenciar usuários e verificar sua autenticação
 * no banco de dados.
 */
public class User {

    /**
     * Método para estabelecer uma conexão com o banco de dados.
     * 
     * @return Connection Objeto de conexão se bem-sucedido ou null em caso de
     *         falha.
     */
    public Connection conectarBD() {
        try {
            // Tentativa de conexão com o banco de dados
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db", // URL do banco
                    "user", // Nome de usuário
                    "password" // Senha do banco
            );
            return conn; // Retorna a conexão se bem-sucedida
        } catch (SQLException e) {
            /*
             * Captura e exibe exceções que ocorrem ao tentar se conectar
             * ao banco de dados.
             */
            e.printStackTrace();
            return null; // Retorna null se houver erro na conexão
        }
    }

    /**
     * Método para verificar se um usuário está registrado no banco de dados.
     * 
     * @param email O email do usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return Retorna uma mensagem informando o status da autenticação
     *         e o nome do usuário (se encontrado).
     */
    public String verificarUsuario(String email, String senha) {
        // Mensagem padrão indicando que o usuário não foi encontrado
        String result = "Usuário não encontrado";
        String nome = ""; // Variável para armazenar o nome do usuário

        try {
            // Chama o método para obter a conexão com o banco de dados
            Connection conn = conectarBD();

            // Verifica se a conexão foi estabelecida com sucesso
            if (conn == null) {
                // Retorna erro caso a conexão não seja bem-sucedida
                return "Erro ao conectar ao banco de dados.";
            }

            // Monta a consulta SQL para buscar o usuário no banco de dados
            String sql = "SELECT * FROM usuarios WHERE email='" + email + "' AND senha='" + senha + "'";

            // Cria um objeto Statement para executar a consulta
            Statement st = conn.createStatement();

            // Executa a consulta SQL e obtém o resultado
            ResultSet rs = st.executeQuery(sql);

            // Verifica se o resultado contém registros
            if (rs.next()) {
                // Atualiza as variáveis com os dados retornados
                result = "Usuário encontrado";
                nome = rs.getString("nome");
            }

            // Fecha a conexão com o banco de dados
            conn.close();
        } catch (SQLException e) {
            /*
             * Captura e exibe exceções que ocorrem durante a execução da
             * consulta SQL.
             */
            e.printStackTrace();
            result = "Erro ao executar a consulta.";
        }

        // Retorna o resultado da operação junto com o nome do usuário, se disponível
        return result + " Nome: " + nome;
    }
}
