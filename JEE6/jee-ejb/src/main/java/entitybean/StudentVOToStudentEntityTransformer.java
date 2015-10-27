package entitybean;

import entitybean.StudentEntity;
import entitybean.StudentVO;


public class StudentVOToStudentEntityTransformer {

    public static StudentEntity toEntity(StudentVO vo) {
        StudentEntity entity = new StudentEntity();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        entity.setGender(vo.getGender());
        return entity;
    }

    public static StudentVO toValueObject(StudentEntity entity) {
    	StudentVO vo = new StudentVO();
    	vo.setId(entity.getId());
    	vo.setName(entity.getName());
    	vo.setGender(entity.getGender());
        return vo;
    }

    public static java.lang.String getPrimaryKey(StudentVO vo) {
        return vo.getId();
    }

}
