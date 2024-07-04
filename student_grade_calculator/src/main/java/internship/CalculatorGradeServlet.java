package internship;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalculatorGradeServlet
 */

@WebServlet("/CalculatorGradeServlet")
public class CalculatorGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorGradeServlet() {
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
		// TODO Auto-generated method stub
		int maths = Integer.parseInt(request.getParameter("maths"));
		int science = Integer.parseInt(request.getParameter("science"));
		int english = Integer.parseInt(request.getParameter("english"));
		int cs = Integer.parseInt(request.getParameter("cs"));
		int os = Integer.parseInt(request.getParameter("os"));
		
		int totalMarks = maths + science + english + cs + os;
		float percentage =  ((totalMarks*100.0f)/500);
		String grade = getGrade(percentage);
		
		request.setAttribute("totalMarks", totalMarks);
		request.setAttribute("Percentage", percentage);
		request.setAttribute("grade", grade);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}
	
	private String getGrade(float percentage) {
		if(percentage>=90) {
			return "A1";
		}else if(percentage>=80) {
			return "A2";
		}else if(percentage>=70) {
			return "B1";
		}else if(percentage>=60) {
			return "B2";
		}else if(percentage>=50) {
			return "C1";
		}else if(percentage>=40) {
			return "C2";
		}else if(percentage>=33) {
			return "D";
		}else {
			return "F";
		}
	}

}
