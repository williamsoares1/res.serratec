package pricipal;

import java.sql.Connection;

import connect.DBalternativo;

public class DBalternativoMain{

    public static void main(String[] args) {
        DBalternativo db=new DBalternativo();
        Connection conn=db.connect_to_db("tutdb","postgres","abhi1234");
        //db.createTable(conn,"employee");
        //db.insert_row(conn,"employee","Rajat","India");
        //db.update_name(conn,"employee","Rahul","Raj");
        //db.search_by_name(conn,"employee","abhishek");
        //db.delete_row_by_name(conn,"employee","abhishek");
        //db.delete_row_by_id(conn,"employee",4);
        //db.read_data(conn,"employee");
        db.delete_table(conn,"employee");
	// write your code here
    }

}
