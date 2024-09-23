import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class koneksi {
    private static Connection con;
    
    public static Connection configDB() throws SQLException{
        try{
            String url ="jdbc:mysql://localhost/aplikasileo";
            String user ="root";
            String pass ="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con=DriverManager.getConnection(url,user,pass);
            //Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Koneksi Berhasil");
        }catch (Exception e){
            System.err.println("Koneksi gagal"+e.getMessage());
        }
        
        return con;
    }
}
