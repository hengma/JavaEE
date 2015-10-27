package bd;

import java.util.List;

import javax.naming.NamingException;

import beo.StudentVO;

import facades.StudentFacadeSessionLocal;
import facades.StudentFacadeSessionUtil;

public class StudentBD {

	public StudentBD() {
	}
	
	public List<StudentVO> findStudents(String id, String name, String gender) {
		return getStudentFacadeSessionLocal().findStudents(id, name, gender);
	}
	
	public StudentVO findById(String id) {
		return getStudentFacadeSessionLocal().findById(id);
	}
	
	public void save(StudentVO studentVO) {
		getStudentFacadeSessionLocal().create(studentVO);
	}
	
	public void update(StudentVO studentVO) {
		getStudentFacadeSessionLocal().update(studentVO);
	}
	
	public void delete(String id) {
		getStudentFacadeSessionLocal().delete(id);
	}
	
	public List<StudentVO> getAllStudents() {
		return getStudentFacadeSessionLocal().getAllStudents();
	}
	
	public StudentFacadeSessionLocal getStudentFacadeSessionLocal() {
		try {
			return StudentFacadeSessionUtil.getLocal();
		} catch (NamingException e) {
			return null;
		}
	}
}
