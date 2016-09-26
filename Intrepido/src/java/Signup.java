import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author SIDDIQ SAMI
 */
public  class Signup extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fn = request.getParameter("fname");
        String uname = request.getParameter("user");
        String pwd = request.getParameter("pass");
        String cpwd = request.getParameter("c_pass");
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String n4 = request.getParameter("n4");
      try
      {

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Intrepido1","root","aysha");
   
        PreparedStatement ps =con.prepareStatement("insert into Register (Full_Name,User_name,Password,C_Password,ENo1,ENo2,ENo3,ENo4) values(?,?,?,?,?,?,?,?)");
         if(fn.isEmpty() || uname.isEmpty() || pwd.isEmpty()  || cpwd.isEmpty() || n1.isEmpty())
       {
     out.println("<html><head></head><body onload=\"alert('REGISTRATION INCOMPLETE')\"></body></html>");
      }
         else 
            {
                if(!pwd.equals(cpwd))
                {
             out.println("<html><head></head><body onload=\"alert('PASSWORD DOESNT MATCH')\"></body></html>");
                  }
                else
                {
                    if(pwd.length()<=6)
                        {
              out.println("<html><head></head><body onload=\"alert('PASSWORD SHOULD BE ALTEAST 6 CHARACTER')\"></body></html>");  
                        }
                    else
                    {
                         ps.setString(1,fn);
         ps.setString(2,uname);
         ps.setString(3,pwd);
         ps.setString(4,cpwd);  
         ps.setString(5,n1);
         ps.setString(6,n2);
         ps.setString(7,n3);
         ps.setString(8,n4);
             int st =ps.executeUpdate();  
             if(st>0)
         
             {
        
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
                    out.println("<html><head></head><body onload=\"alert('REGISTRATION SUCCESSFULL')\"></body></html>");
            
          }
        }
     }
         

         

        
           
 }
      
 }
      catch(ClassNotFoundException | SQLException e)
      {
           e.printStackTrace();
      
      }
    }

   
      
   
     
    }
