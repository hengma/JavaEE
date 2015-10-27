package facades;

import java.util.List;

import javax.ejb.Local;

import beo.StudentVO;

import util.JEENamingUtil;

//@Remote
@Local
public interface StudentFacadeSessionLocal {
	static final String BEAN_NAME = "StudentFacadeSessionBean";
	static final String JNDI_NAME = JEENamingUtil.getInstance().getLocalJndiName(BEAN_NAME, StudentFacadeSessionLocal.class);

    List<StudentVO> findStudents(String id, String name, String gender);
    void create(StudentVO studentVO);
    void update(StudentVO studentVO);
    void delete(String id);
    StudentVO findById(String id);
    List<StudentVO> getAllStudents();
}