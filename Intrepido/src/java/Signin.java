import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author SIDDIQ SAMI
 */
public class Signin extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("user");
        String pwd = request.getParameter("pass");
       
         if(checkUser(uname, pwd))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Start");
            rs.forward(request, response);
            

        }
        else
        {
           
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
           out.println("<html><head></head><body onload=\"alert('Username or Password incorrect')\"></body></html>");
        }
    }  
    public static boolean checkUser(String uname,String pwd) 
     {
      boolean st=false;   
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Intrepido1","root","aysha");
         PreparedStatement ps =con.prepareStatement("select User_name,Password from Register where User_name=? and Password=?");
 if(uname.isEmpty() || pwd.isEmpty())
 {
  }
 else
 {
         ps.setString(1, uname);
         ps.setString(2, pwd);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
         return st;
 }      
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   

}