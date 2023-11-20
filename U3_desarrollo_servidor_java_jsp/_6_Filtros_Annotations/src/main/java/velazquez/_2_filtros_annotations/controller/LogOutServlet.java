package velazquez._2_filtros_annotations.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LogOutServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession sesion = request.getSession();
    sesion.invalidate();
    response.sendRedirect(request.getContextPath() + "/");
  }
}
