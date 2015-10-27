package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beo.StudentVO;


public class StudentDAOImp extends AbstractDAO implements StudentDAO {

	@Override
	public List<StudentVO> findStudents(String id, String name, String gender) throws SQLException {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		String req = "SELECT id, name, gender FROM student WHERE 1 = 1 ";
		if(id != null) {
			req = req + "AND id = '" + id + "'";
		}
		if (name != null) {
			req = req + "AND name = '" + name + "'";
		}
		if(gender != null) {
			req = req + "AND gender = '" + gender + "'";
		}
		getConnection();
		ResultSet rs = executeSelect(req);
		while(rs.next()) {
			StudentVO student = new StudentVO();
			student.setId(rs.getString("id"));
			student.setName(rs.getString("name"));
			student.setGender(rs.getString("gender"));
			studentList.add(student);
		}
		return studentList;
	}
	
	@Override
	public List<StudentVO> getAllStudents()
			throws SQLException {
		
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		String req = "SELECT id, name, gender FROM student";
		getConnection();
		ResultSet rs = executeSelect(req);
		while(rs.next()) {
			StudentVO student = new StudentVO();
			student.setId(rs.getString("id"));
			student.setName(rs.getString("name"));
			student.setGender(rs.getString("gender"));
			studentList.add(student);
		}
		return studentList;
	}

}
