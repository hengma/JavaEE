package bpo;

import java.util.List;

import javax.ejb.Local;

import beo.StudentVO;

import util.JEENamingUtil;

@Local
public interface StudentBPOLocal {
	static final String BEAN_NAME = "StudentBPOBean";
	static final String JNDI_NAME = JEENamingUtil.getInstance().getLocalJndiName(BEAN_NAME, StudentBPOLocal.class);

	List<StudentVO> getAllStudents();
	List<StudentVO> findStudents(String id, String name, String gender);
}