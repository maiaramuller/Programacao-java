package br.edu.unicesumar.mapa.view.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "GerarAtestadoServlet", urlPatterns = {"/GerarAtestado"})
public class GerarAtestadoServlet extends HttpServlet {

    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String medico = request.getParameter("medico");
        String paciente = request.getParameter("paciente");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        int doenca = Integer.parseInt(request.getParameter("doenca"));

        int numeroDiasAfastamento = 0;
        
        switch (doenca) {
        case 1 -> numeroDiasAfastamento = 2;
        case 2 -> numeroDiasAfastamento = 1;
        case 3 -> numeroDiasAfastamento = 3;
        case 4 -> numeroDiasAfastamento = 60;
        case 5 -> numeroDiasAfastamento = 5;
        default ->{
            }
    }

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualFormatada = LocalDate.now().format(formatter);
    
            try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Atestado Médico</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1><b>LOGO\n</b></h1><h2><b>\nATESTADO\n</b></h2>");
        out.println("Atesto para devido fins que " + paciente + ", residente e domiciliado(a) à " + endereco +
                    " não se encontra em condições de trabalho por " + numeroDiasAfastamento + " dia(s).");
        out.println("<br>" + cidade + " - " + dataAtualFormatada);
        out.println("<br>_________________________");
        out.println("<br>" + medico);
        out.println("</body>");
        out.println("</html>");
        }
    }
}
