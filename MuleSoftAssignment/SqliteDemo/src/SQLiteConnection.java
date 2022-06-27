import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
   
public class SQLiteConnection{  
    
	
		   
		public static void createNewTable() {  
	         
	        String url = "jdbc:sqlite:C://sqlite/smd.db";  
	          
	      
	        String sql = "create table movie_s(mname varchar(20),hero varchar(20),heroine varchar(20),Director varchar(20),Year varchar(4))";  
	          
	        try{  
	            Connection con = DriverManager.getConnection(url);  
	            Statement s = con.createStatement();
				s.execute(sql);
				PreparedStatement ps = con.prepareStatement("insert into movie_s(mname,hero,heroine,Director,Year) values(?,?,?,?,?);");
				ps.setString(1, "BAHUBALI");
				ps.setString(2, "PRABHAS");
				ps.setString(3, "TAMANNA");
				ps.setString(4, "RAJAMOULI");
				ps.setString(4, "2017");
	
				ps.executeUpdate();
				Statement query = con.createStatement();
				ResultSet rs = query.executeQuery("select * from movie_s;");
				
				while(rs.next()) {
					System.out.println("Movie : "+rs.getString(1)+"Hero : "+rs.getString(2)+"Heroine : "+rs.getString(3)+"Director : "+rs.getString(4)+"Year : "+rs.getString(5));
				}
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	   
	   
	    public static void main(String[] args) {  
	        createNewTable();  
	    } 
}
