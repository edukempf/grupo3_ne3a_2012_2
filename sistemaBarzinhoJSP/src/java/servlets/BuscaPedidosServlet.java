/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAOs.PedidoBebidaDAO;
import DAOs.PedidoPratoDAO;
import Modelos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscaPedidosServlet", urlPatterns = {"/BuscaPedidosServlet"})
public class BuscaPedidosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int mesa;
        if (request.getParameter("mesa") == null) {
            response.sendRedirect("index.jsp");

        } else {
            mesa = Integer.parseInt(request.getParameter("mesa"));
            try {
                PedidoBebidaDAO daoPedidoBebida = new PedidoBebidaDAO();
                PedidoPratoDAO daoPedidoPrato = new PedidoPratoDAO();
                List<PedidoBebida> listaPedidosBebida = daoPedidoBebida.buscaPedidoAbertoPorMesa(mesa);
                List<PedidoPrato> listaPedidosPratos = daoPedidoPrato.buscaPedidoAbertoPorMesa(mesa);
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Sistema Barzinho</title>");
                out.println("<style type=\"text/css\">");
                out.println("@import url(\"./estilo.css\");");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Pedidos de Bebidas</h1>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>C&oacute;digo do Pedido</th>");
                out.println("<th>Funcion&aacute;rio do Atendimento</th>");
                out.println("<th>Total do Pedido</th>");
                out.println("</tr>");
                double total = 0;
                for (PedidoBebida pedidoBebida : listaPedidosBebida) {
                    out.println("<tr>");
                    out.println("<td>" + pedidoBebida.getId() + "</td>");
                    out.println("<td>" + pedidoBebida.getIdFuncionario().getNome() + "</td>");
                    total = 0;
                    for (Bebida b : pedidoBebida.getBebidas()) {
                        total += b.getPreco();
                    }
                    out.println("<td>" + total + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<h1>Pedidos de Bebidas</h1>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>C&oacute;digo do Pedido</th>");
                out.println("<th>Funcion&aacute;rio do Atendimento</th>");
                out.println("<th>Total do Pedido</th>");
                out.println("</tr>");
                total = 0;
                for (PedidoPrato pedidoPrato : listaPedidosPratos) {
                    out.println("<tr>");
                    out.println("<td>" + pedidoPrato.getId() + "</td>");
                    out.println("<td>" + pedidoPrato.getIdFuncionario().getNome() + "</td>");
                    total = 0;
                    for (Prato p : pedidoPrato.getPratos()) {
                        total += p.getPreco();
                    }
                    out.println("<td>" + total + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<a href=\"./index.jsp\">voltar ao inicio</a>");
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
