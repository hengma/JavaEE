package facades;

import java.util.List;

import javax.ejb.Remote;

import beo.StudentVO;

import util.JEENamingUtil;

@Remote
public interface StudentFacadeSessionRemote {
	static final String BEAN_NAME = "StudentFacadeSessionBean";
	static final String JBOSS_JNDI_NAME = JEENamingUtil.getInstance().getJbossRemoteJndiName(BEAN_NAME, StudentFacadeSessionRemote.class);
	
	List<StudentVO> findStudents(String id, String name, String gender);
    void create(StudentVO studentVO);
    void update(StudentVO studentVO);
    void delete(String id);
    StudentVO findById(String id);
    List<StudentVO> getAllStudents();
}