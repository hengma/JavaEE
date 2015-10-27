package dao;

import java.sql.SQLException;
import java.util.List;

import beo.StudentVO;


public interface StudentDAO {
	List<StudentVO> getAllStudents() throws SQLException;
	List<StudentVO> findStudents(String id, String name, String gender) throws SQLException;
}
