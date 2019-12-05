import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GetNumber extends HttpServlet
{
    int x=0;
    int y=1;
    String ans="";
    String calc="";
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
    {
        response.setContentType("text/html");
        try
        {    
            PrintWriter out=response.getWriter();
            out.print("<!DOCTYPE html>");
            out.print("<html lang=\"en\">");
            out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>");
            out.print("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>ChooseOption</title>");
            out.print("</head>");
            out.print("<body style=\"background: #F09819;background: -webkit-linear-gradient(to right, #EDDE5D, #F09819);background: linear-gradient(to right, #EDDE5D, #F09819);\">");
            out.print("<center>");
            
            String clicked;
            clicked=request.getParameter("button");
            boolean c=false;

            if(clicked!=null && clicked.equals("YES")) 
            {
                c=true;
                x=new Integer(request.getParameter("x"));                
                y=new Integer(request.getParameter("y"));                
                x+=y;
                y*=2;
                // ans+="1";
                // calc+=String.valueOf(y)+"+";   
                
                // out.print("<h1>ON YES</h1>"); 
                
                // out.print("<h1> You choose "+x+"</h1>");
                
            }
            else if(clicked!=null && clicked.equals("NO"))
            {   
                c=true;
                // ans+="0";    
                // out.print("<h1>ON NO</h1>");
                // out.print("<h1> You choose "+x+"</h1>");
                // out.println("binary "+(ans));
                // out.println("dec "+(x));
                // out.println("calc "+(calc));
                y=new Integer(request.getParameter("y"));             
                y*=2;
            }
            else
            {
                x=0;
                y=1;
                ans="";
                calc="";
            }
            boolean getResult=false;
            if(y==64)
            {
                out.print("<h1> You choose "+x+"</h1>");
                // out.println("binary "+(ans));
                // out.println("dec "+(x));
                // out.println("calc "+(calc));
                // ans="";
                // calc="";
                getResult=true;
                out.print("<form method=\"POST\" action=\"Processed\"><input type=\"submit\" value=\"replay\" name=\"replaybutton\"></form>");
                
            }   
            else
            {
                out.print("<p><h1>Is your number is in below number?</h1><br><h1></h1><b>");
                boolean comma=false;
                for(int i=0;i<64;i++)
                {
                    if((i&y)!=0 && comma==true)
                    {
                        out.print(","+i);   
                    }
                    else if((i&y)!=0)
                    {
                        out.print(i);
                        comma=true;
                    }
                }
                
                out.print("</b></p>");   
                out.print("<br>");
                out.print("<form method=\"POST\"  action=\"Processed\">");
                out.print("<input type=\"submit\" value=\"YES\" class=\"btn btn-success\" name=\"button\">");
                out.print("<input type=\"submit\" value=\"NO\" class=\"btn btn-success\" name=\"button\">");
                out.print("<input type=\"hidden\" value=\""+y+"\" name=\"y\">");
                out.print("<input type=\"hidden\" value=\""+x+"\" name=\"x\">");
                out.print("</form>");
                out.print("</center>");
                out.print("</body>");
                out.print("</html>");
                out.close();
            }
            if(getResult)
            {
                y=1;
                x=0;
            }
        }
        catch(Exception e)
        {
            try
            {
                PrintWriter out=response.getWriter();
                out.print(e);
                out.close();
            }
            catch(Exception e1)
            {
            }
        }
    }
}
