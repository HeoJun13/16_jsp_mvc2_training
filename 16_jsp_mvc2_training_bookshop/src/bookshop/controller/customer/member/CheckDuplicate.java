package bookshop.controller.customer.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.dao.MemberDAO;
@WebServlet("/checkDuplicate")
public class CheckDuplicate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		
		if (MemberDAO.getInstance().checkDuplicate(request.getParameter("memberId"))) {
			pw.print("isDuple");	// AJAX의 success 콜백 함수 파라메타로 반환
		}
		else {
			pw.print("isNotDuple"); // AJAX의 success 콜백 함수 파라메타로 반환
		}
	}


}
