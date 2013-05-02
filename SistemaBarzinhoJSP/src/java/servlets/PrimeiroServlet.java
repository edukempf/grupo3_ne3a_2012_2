
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrimeiroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        if (request.getSession().getAttribute("numero")==null)
            request.getSession().setAttribute("numero", 10);
        else{
            Integer num = (Integer) request.getSession().getAttribute("numero");
            num++;
            request.getSession().setAttribute("numero", num);
        }
            

        String nome = request.getParameter("nome");
        String end = request.getParameter("endereco");

        if (nome == null || nome.equals("")) {
            //response.sendRedirect("index.jsp");            
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {

            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Sistema Barzinho</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>");
                out.println("Nome: " + nome + "</br>");
                out.println("Endereço: " + end);
                out.println("</h1>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
