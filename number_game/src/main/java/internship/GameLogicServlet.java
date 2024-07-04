package internship;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GameLogicServlet
 */
@WebServlet("/GameLogicServlet")
public class GameLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer randomNumber =(Integer)session.getAttribute("randomNumber");
		Integer attempts =(Integer)session.getAttribute("attempts");
		Integer maxAttempts = (Integer)session.getAttribute("maxAttempts");
		
		if(attempts ==null || maxAttempts ==null) {
			response.sendRedirect("GenerateNumberServlet");
			return;
		}
		String message ="";
		if(request.getParameter("guess")!=null){
			int guess =Integer.parseInt(request.getParameter("guess"));
			attempts++;
			session.setAttribute("attempts", attempts);
			if(guess<randomNumber) {
				message="The Number is too small";
				System.out.println(message+randomNumber);
			}else if(guess>randomNumber) {
				message="The Number is too large";
				System.out.println(message+randomNumber);
			}else {
				response.sendRedirect("complete.jsp");
				return;
			}
			request.setAttribute("message", message);
            request.getRequestDispatcher("game.jsp").forward(request, response);
		}
	}

}
