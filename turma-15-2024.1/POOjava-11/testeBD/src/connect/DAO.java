package connect;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DAO {

	private String usuario = "postgres";
	private String dbnome = "grupo2db";
	private String senha = "Wi95907135.";
	private String url = "jdbc:postgresql://localhost:5432/";

	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
	    	conn = DriverManager.getConnection(url + dbnome, usuario, senha);
			}
		catch(Exception erro){
			System.out.println(erro);
			}
		
		return conn;
	}
	// the name of the DAO must be the same name of the table;
	// the attributes of the DAO must be the same as in the table;
	// no capitalization allowed
	
	/**
	 * finds first by the targetField value. targetField is the name of the field
	 * @param targetField
	 * @return the object or null
	 */
	
	public DAO findByFieldValue(String targetField) {
		
		Class<? extends DAO> objectClass = this.getClass();
		
		Field[] fields = objectClass.getDeclaredFields();
	    	     
		String tableName = getClassNameAsString(objectClass);
		
		String sql = "SELECT * FROM " + tableName + " WHERE " + targetField + " = ?";
		
		try (var connection = connect()){
			
			var statement = connection.prepareStatement(sql);

	        // Get the value of the target field from the provided DAO instance
			
	        Field queryField = objectClass.getDeclaredField(targetField);
	        queryField.setAccessible(true);
	        Object fieldValue = queryField.get(this);

	        // Set the value of the target field to the PreparedStatement
	        statement.setObject(1, fieldValue);
	    
		    var response = statement.executeQuery();

		    if(response.next()) {
		        // Create a new instance of DAO
		        DAO daoInstance = objectClass.getDeclaredConstructor().newInstance();

		        // Set the values of fields
		        for (Field field : fields) {
		            field.setAccessible(true);
		            String columnName = field.getName().toLowerCase();
		            Object value = response.getObject(columnName);
		            field.set(daoInstance, value);
		        }
		        
		        return daoInstance;
		    }
		} catch (SQLException e) {
		    System.err.println("SQL Exception occurred: " + e.getMessage());
		} catch (ReflectiveOperationException e) {
		    System.err.println("Error occurred while reflecting: " + e.getMessage());
		}
		return null;
		
	}
	
	/**
	 * finds 'recent' objects, that is, the five last inserted id
	 * this assumes your id is serial
	 * @param howMany
	 * @return
	 */
	 public ArrayList<DAO> findRecent(int howMany) {
		
		Class<? extends DAO> objectClass = this.getClass();
	    
		Field[] fields = objectClass.getDeclaredFields();
		
		String tableName = getClassNameAsString(objectClass);
		
		// sql to get all games
		String sql = "SELECT * FROM " + tableName + " ORDER by id DESC LIMIT " + howMany;
		
	
		ArrayList<DAO> objects = new ArrayList<DAO>();
		
		try (var connection =  connect()){
		    var statement = connection.createStatement();
		    var response = statement.executeQuery(sql);

		    while(response.next()) {
		        // Create a new instance of DAO
		        DAO daoInstance = objectClass.getDeclaredConstructor().newInstance();

		        // Set the values of fields
		        for (Field field : fields) {
		            field.setAccessible(true);
		            String columnName = field.getName().toLowerCase();
		            Object value = response.getObject(columnName);
		            field.set(daoInstance, value);
		        }

		        // Add the DAO instance to the list
		        objects.add(daoInstance);
		    }
		} catch (SQLException e) {
		    System.err.println("SQL Exception occurred: " + e.getMessage());
		} catch (ReflectiveOperationException e) {
		    System.err.println("Error occurred while reflecting: " + e.getMessage());
		}
		return objects;
	}
	
	/**
	 * finds all by another DAO field value.
	 * @param other the other DAO
	 * @param targetField the field which will the value be extracted from
	 * @return
	 */
	public ArrayList<DAO> findAllByAnotherDAOField(DAO other, String targetField) {
		
		// this assumes the database has a 
		// relational table in the format
		// tableName_otherTableName
		// targetField should be lower case, of course
		
		Class<? extends DAO> objectClass = this.getClass();
	    
		Field[] fields = objectClass.getDeclaredFields();
	     
		String tableName = getClassNameAsString(objectClass);
		
		Class<? extends DAO> otherClass = other.getClass();
		
		String otherTableName = getClassNameAsString(otherClass);
		
		String joinTableName = tableName + "_" + otherTableName;
		
		String tableId = tableName + ".id";
		
		String otherTableId = otherTableName + ".id";
		
		String thisTableIdInTheJoinTable = "id" + tableName;
		
		String otherTableIdInTheJoinTable = "id" + otherTableName;
		
		String whereField = otherTableName + "." + targetField;
		
		String sql = "SELECT * FROM " + tableName
				+ " INNER JOIN "+ joinTableName + " ON "+tableId+" = "+joinTableName+"."+thisTableIdInTheJoinTable
				+ " INNER JOIN "+  otherTableName + " ON "+joinTableName+"."+otherTableIdInTheJoinTable+" = "+otherTableId
				+ " WHERE " + whereField + " = ?" ;
		
		// Concatenate the value extracted from the field
		
		ArrayList<DAO> objects = new ArrayList<DAO>();
				
		try (var connection =  connect()){
			
			var statement = connection.prepareStatement(sql);

	        // Get the value of the target field from the provided DAO instance
			
	        Field otherField = otherClass.getDeclaredField(targetField);
	        otherField.setAccessible(true);
	        Object targetFieldValue = otherField.get(other);

	        // Set the value of the target field to the PreparedStatement
	        statement.setObject(1, targetFieldValue);
	    
		    var response = statement.executeQuery();

		    while(response.next()) {
		        // Create a new instance of DAO
		        DAO daoInstance = objectClass.getDeclaredConstructor().newInstance();

		        // Set the values of fields
		        for (Field field : fields) {
		            field.setAccessible(true);
		            String columnName = field.getName().toLowerCase();
		            Object value = response.getObject(columnName);
		            field.set(daoInstance, value);
		        }

		        // Add the DAO instance to the list
		        objects.add(daoInstance);
		    }
		} catch (SQLException e) {
		    System.err.println("SQL Exception occurred: " + e.getMessage());
		} catch (ReflectiveOperationException e) {
		    System.err.println("Error occurred while reflecting: " + e.getMessage());
		}
		return objects;
	}
	
	/**
	 * Finds all objects in the database ordered by id
	 * @return array list of all objects
	 */
	public ArrayList<DAO> findAll() {
		
		Class<? extends DAO> objectClass = this.getClass();
	    
		Field[] fields = objectClass.getDeclaredFields();
	     
		String tableName = getClassNameAsString(objectClass);
		
		String columnNames = getDeclaredFieldsAsColumnsString(fields);
		
		String sql = "SELECT id,"
				+ columnNames
				+ " FROM "
				+ tableName
				+ " ORDER BY id";
		
		ArrayList<DAO> objects = new ArrayList<DAO>();
		
		try (var connection =  connect()){
		    var statement = connection.createStatement();
		    var response = statement.executeQuery(sql);

		    while(response.next()) {
		        // Create a new instance of DAO
		        DAO daoInstance = objectClass.getDeclaredConstructor().newInstance();

		        // Set the values of fields
		        for (Field field : fields) {
		            field.setAccessible(true);
		            String columnName = field.getName().toLowerCase();
		            Object value = response.getObject(columnName);
		            field.set(daoInstance, value);
		        }

		        // Add the DAO instance to the list
		        objects.add(daoInstance);
		    }
		} catch (SQLException e) {
		    System.err.println("SQL Exception occurred: " + e.getMessage());
		} catch (ReflectiveOperationException e) {
		    System.err.println("Error occurred while reflecting: " + e.getMessage());
		}
		return objects;
	}
	
	
	
	/**
	 * Add the object to the database
	 * @return -1 if unsuccessful, the id of the table in the db
	 */
	public int add() {
	    return add(getClassNameAsString(this.getClass()));
	}

	/**
	 * Overload that passes a custom tableName!!! Use with caution
	 * the idea is to have a discarded table for tags or something
	 * @param tableName
	 * @return
	 */
	public int add(String tableName) {
		// to add we need to extract the fields from the class
		
	    Class<? extends DAO> objectClass = this.getClass();
	    
		Field[] fields = objectClass.getDeclaredFields();
	     
		String columnNames = getDeclaredFieldsAsColumnsString(fields);
		
		String statementPlaceholders = replaceWithQuestionMarks(columnNames);
		
		String sql = "INSERT INTO "
		+ tableName
		+ "("
		+ columnNames
		+ ") "
		+ "VALUES"
		+ "("
		+ statementPlaceholders
		+ ")";
		
		
		return executeFullInsertStatement(sql, fields);
	}
	
	
	/**
	 * Executes a full insert as it is expected by the add method
	 * @param sql
	 * @param fields
	 * @return
	 */
	private int executeFullInsertStatement(String sql, Field[] fields) {
	    try (var connection = connect()) {
	        
	        // we use a prepared statement for the insertion
	        var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        
	        // bind the values
	        int index = 1;
	        for (Field field : fields) {
	            field.setAccessible(true); // To access private fields
	            try {
	                // retrieve the value of the field from your object instance
	                Object value = field.get(this);
	                // set the value to the prepared statement parameter
	                preparedStatement.setObject(index++, value);
	            } catch (IllegalAccessException e) {
	                System.err.println("Access to field denied: " + e.getMessage());
	            }
	        }
	        // execute the insert statement and get the inserted id
	        int insertedRow = preparedStatement.executeUpdate();
	        if(insertedRow > 0) {
	            var response = preparedStatement.getGeneratedKeys();
	            if(response.next()) {
	                return response.getInt(1);
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println(e.getMessage());
	    }
	    return -1;
	}
	
	/**
	 * Take the fields array and generates 
	 * 
	 * @param fields
	 * @return
	 */
	private static String getDeclaredFieldsAsColumnsString(Field[] fields) {
        StringBuilder result = new StringBuilder();
        for (Field field : fields) {
            // Convert field name to lowercase and append it to the result string
            result.append(field.getName().toLowerCase());
            result.append(",");
        }

        // Remove the trailing comma if there are any fields
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
	
	/**
	 * Returns the class simple name
	 * @param object
	 * @return
	 */
	private static String getClassNameAsString(Class<? extends DAO> object) {
	    return object.getSimpleName().toLowerCase();
	}
	
	/**
	 * Replace the string generated by getDeclaredFieldsAsColumnsString with ?, ?, 
	 * for the sql statement
	 * @param fieldsString
	 * @return
	 */
	private static String replaceWithQuestionMarks(String fieldsString) {
	    // Split the fieldsString by commas
	    String[] fields = fieldsString.split(",");
	    StringBuilder result = new StringBuilder();

	    // Iterate through each field and replace with '?'
	    for (@SuppressWarnings("unused") String field : fields) {
	        result.append("?,");
	    }

	    // Remove the trailing comma if there are any fields
	    if (result.length() > 0) {
	        result.deleteCharAt(result.length() - 1);
	    }

	    return result.toString();
	}
}
