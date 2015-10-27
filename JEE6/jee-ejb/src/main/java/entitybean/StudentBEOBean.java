package entitybean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentBEOBean implements StudentBEOLocal {
	
    /* setting a persistence context*/
    @PersistenceContext(unitName = "jeeDatasource")
    private EntityManager em;
    @Override
    public void create(StudentVO vo) {
    	StudentEntity entity = StudentVOToStudentEntityTransformer.toEntity(vo);
        em.persist(entity);
    }
    @Override
    public void update(StudentVO vo) {
    	StudentEntity entity = StudentVOToStudentEntityTransformer.toEntity(vo);
        em.merge(entity);
    }
    @Override
    public void remove(java.lang.String pk) {
    	StudentEntity toremove = em.find(StudentEntity.class, pk);
        em.remove(toremove);
    }
    @Override
    public StudentVO findByPrimaryKey(java.lang.String pk) {
    	StudentEntity found =  em.find(StudentEntity.class, pk);
        if (found != null) {
             return StudentVOToStudentEntityTransformer.toValueObject(found);
        } else {
             return null;
        }
    }
    
    
    
    
    
    
    /*public List <StudentVO> findByGender(String gender) {
        List <StudentVO> resultList = new ArrayList <StudentVO>();
        Collection <StudentEntity> jpaResult = null;
        jpaResult =  em.createQuery("SELECT OBJECT(student) FROM StudentEntity student WHERE student.gender = :gender")
            .setParameter("gender", gender)
            .getResultList();
        Iterator <StudentEntity> itJpaResult = jpaResult.iterator();
        while (itJpaResult.hasNext()) {
            resultList.add(StudentVOToStudentEntityTransformer.toValueObject(itJpaResult.next()));
        }
        return resultList;
    }


    public StudentVO findById(String id) {
    	StudentVO result = null;
        StudentEntity jpaResult = null;
        jpaResult =  (StudentEntity) em.createQuery("SELECT OBJECT(student) FROM StudentEntity student WHERE student.id = :id")
            .setParameter("id", id)
            .getSingleResult();
        result = StudentVOToStudentEntityTransformer.toValueObject(jpaResult);
        return result;
    }*/
}
