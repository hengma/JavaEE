package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;
import bd.StudentBD;
import beo.StudentVO;

@WebServlet(name = "MainServlet", 
	urlPatterns = "/MainServlet"
)
public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7286787282449057796L;


	private final String SEARCH = "SEARCH";
	private final String SAVE = "SAVE";
	private final String UPDATE = "UPDATE";
	private final String DELETE = "DELETE";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = StringUtils.nullIfEmpty(request.getParameter("txtId"));
		String name = StringUtils.nullIfEmpty(request.getParameter("txtName"));
		String gender = StringUtils.nullIfEmpty(request.getParameter("cmbGender"));
		String task = StringUtils.nullIfEmpty(request.getParameter("task"));
		if(task == null) {
			task = SEARCH;
		}
		
		HttpSession session = request.getSession(true);
		StudentBD studentBD = new StudentBD();
		
		List<StudentVO> students = null;
		if (SEARCH.equals(task)) {
			if(id != null || name != null || gender != null) {
				students = studentBD.findStudents(id, name, gender);
			} else {
				students = studentBD.getAllStudents();
			}
		} else if (SAVE.equals(task)) {
			StudentVO studentVO = new StudentVO();
			studentVO.setId(id);
			studentVO.setName(name);
			studentVO.setGender(gender);
			studentBD.save(studentVO);
			students = studentBD.getAllStudents();
		} else if (UPDATE.equals(task)) {
			if(id != null) {
				StudentVO studentVO = studentBD.findById(id);
				if(studentVO != null) {
					if(name != null) {
						studentVO.setName(name);
					}
					if(gender != null) {
						studentVO.setGender(gender);
					}
					studentBD.update(studentVO);
				}
			}
			students = studentBD.getAllStudents();
		} else if (DELETE.equals(task)) {
			String selecteditem = request.getParameter("selecteditem");
			if(selecteditem != null) {
				studentBD.delete(selecteditem);
			}
			students = studentBD.getAllStudents();
		}
		
		session.setAttribute("students", students);
		
		getServletContext().getRequestDispatcher("/student.jsp")
        .forward(request, response);
	}

}
