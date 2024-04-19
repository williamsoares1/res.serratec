package connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FuncoesBD{
	private String url = "jdbc:postgresql://localhost:5432/";
	
	public Connection connect_to_user(String user,String senha){
        Connection conn = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(this.url, user, senha);
            
            if(conn != null){
                System.out.println("Conectado em " + user);
            }
            else{
                System.out.println("Não foi possivel conectar ao usuario");
            }
        }catch (Exception e){
            System.out.println(e + "\nResumindo... Foi não");
        }
        
        return conn;
    }

	public Connection connect_to_db(String nomeDB,String user,String senha){
        
		Connection conn = null;
        
		try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(this.url + nomeDB, user, senha);
            
            if(conn != null){
                System.out.println("Conectado em " + nomeDB);
            }
            else{
                System.out.println("Não foi possivel conectar ao database");
            }
            
        }catch (Exception e){
        	System.out.println(e + "\nResumindo... Foi não");
        }
        return conn;
    }
	
	public void createDB(Connection conn, String nomeDB){
        Statement statement;
        try{
            String comando = "create database " + nomeDB;
            
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Database criada com sucesso");
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
	
    public void createTable(Connection conn, String nomeTB, String dadosTB){
        Statement statement;
        try{
        		//Deve-se informar os parametros manualmente no Main caso precise
            String comando = "create table " + nomeTB + "(" + dadosTB + ");";
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Tabela criada com sucesso");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn,String nomeTB,String nome, String cpf, Date data, String nacionalidade){
        Statement statement;
        try {
            String comando = String.format("insert into %s(nome, cpf, dtnascimento, endereco) values('%s', '%s', '%s', '%s');", nomeTB, cpf, nome, data, nacionalidade);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            
            System.out.println("Dados inseridos");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void read_data_cliente(Connection conn, String nomeTB){
        Statement statement;
        ResultSet rs = null;
        
        int j = 1, i;
        try {
            String comando = String.format("select * from %s",nomeTB);
            statement = conn.createStatement();
            rs = statement.executeQuery(comando);
            
            while(rs.next()){
        		System.out.println("Id: " + rs.getString("idCliente") + " ");
            }
        }
        
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void update_name(Connection conn, String nomeTB, String old_name, String new_name){
        Statement statement;
        try {
            String comando = String.format("update %s set nome='%s' where nome='%s'", nomeTB, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Dado alterado");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void search_name(Connection conn, String nomeTB, String name){
        Statement statement;
        ResultSet rs = null;
        try {
            String comando = String.format("select * from %s where nome = '%s'", nomeTB, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(comando);
            
            while(rs.next() == true){
            	System.out.println("Id: " + rs.getString("idPessoa"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Nacionalidade: " + rs.getString("nacionalidade") + "\n");
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void search_id(Connection conn, String nomeTB, int id){
        Statement statement;
        ResultSet rs = null;
        try {
            String comando = String.format("select * from %s where idPessoa= %s", nomeTB, id);
            statement = conn.createStatement();
            rs = statement.executeQuery(comando);
            while (rs.next()){
            	System.out.println("Id: " + rs.getString("idPessoa"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Nacionalidade: " + rs.getString("nacionalidade") + "\n");

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_name(Connection conn, String nomeTB, String name){
        Statement statement;
        try{
            String comando = String.format("delete from %s where nome ='%s'", nomeTB, name);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Dado deletado");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection conn, String nomeTB){
        Statement statement;
        try {
            String comando = String.format("drop table %s cascade ", nomeTB);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Tabela deletada");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
