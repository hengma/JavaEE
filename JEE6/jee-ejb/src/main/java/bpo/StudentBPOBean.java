package bpo;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import beo.StudentVO;

import dao.StudentDAOImp;

@Stateless
public class StudentBPOBean implements StudentBPOLocal {

	@Override
	public List<StudentVO> getAllStudents() {
		
		try {
			return new StudentDAOImp().getAllStudents();
		} catch (SQLException e) {
			System.out.print("Error :" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<StudentVO> findStudents(String id, String name, String gender) {
		
		try {
			return new StudentDAOImp().findStudents(id, name, gender);
		} catch (SQLException e) {
			System.out.print("Error :" + e.getMessage());
			return null;
		}
	}
}
