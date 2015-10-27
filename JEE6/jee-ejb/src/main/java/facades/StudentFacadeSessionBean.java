/*
 * GarantieSessionBean.java
 *
 * Created on October 23, 2003, 3:27 PM
 */

package facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import beo.StudentBEOLocal;
import beo.StudentVO;
import bpo.StudentBPOLocal;
import bpo.StudentBPOUtil;

//@Stateful
@Stateless
public class StudentFacadeSessionBean implements StudentFacadeSessionLocal, StudentFacadeSessionRemote {
	
	@EJB
	StudentBEOLocal studentBEOLocal;
	
	private StudentBPOLocal getStudentBPOLocal() {
		try {
			return StudentBPOUtil.getLocal();
		} catch (NamingException e) {
			System.out.print("Error :" + e.getMessage());
			return null;
		}
	}
	@Override
	public void create(StudentVO studentVO) {
		studentBEOLocal.create(studentVO);
	}
	@Override
	public void update(StudentVO studentVO) {
		studentBEOLocal.update(studentVO);
	}
	@Override
	public void delete(String id) {
		studentBEOLocal.remove(id);
	}
	@Override
	public StudentVO findById(String id) {
		return studentBEOLocal.findByPrimaryKey(id);
	}
	@Override
	public List<StudentVO> getAllStudents() {
		return getStudentBPOLocal().getAllStudents();
	}
	@Override
	public List<StudentVO> findStudents(String id, String name, String gender) {
		return getStudentBPOLocal().findStudents(id, name, gender);
	}
}
