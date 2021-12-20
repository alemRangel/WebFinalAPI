package Api.Usuarios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import persistence.DbManager;

public class getUsuarios extends HttpServlet {

    private PrintWriter out;
    private DbManager manageConnection;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        manageConnection = new DbManager();
        out = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
            StringBuilder json = new StringBuilder();
            json.append("{");            
    try
    {
    //Class.forName("com.mysql.jdbc.Driver");
    //Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3307/web_test","root", "1234");
    //Statement s = db.createStatement();        
    //ResultSet rs=s.executeQuery("select * from preguntas;");
        String query = "Select * from usuario where id = 1";
        ResultSet rs = manageConnection.selectResultSet(query);
        while(rs.next())
    {
    String id=rs.getString("id");
    String nombre = rs.getString("nombre");
    String apellido = rs.getString("apellido");
    String email = rs.getString("email");
    String pass = rs.getString("pass");
    String sexo = rs.getString("sexo");
    byte[] foto = rs.getBytes("photo");
    json.append("id:").append(id).append(",");
    json.append("nombre:'").append(nombre).append("',");
    json.append("apellido:'").append(apellido).append("',");
    json.append("email:'").append(email).append("',");
    json.append("pass:'").append(pass).append("',");
    json.append("sexo:'").append(sexo).append("'");
    json.append("foto:'").append(foto).append("'");
    }
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    json.append("}");
    System.out.println(json.toString());
    out.write(json.toString());
    }

}
