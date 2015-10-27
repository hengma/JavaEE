package beo;

import javax.ejb.Local;

import util.JEENamingUtil;

@Local
public interface StudentBEOLocal{
    static final String BEAN_NAME = "StudentBEOBean";
    static final String JNDI_NAME = JEENamingUtil.getInstance().getLocalJndiName(BEAN_NAME, StudentBEOLocal.class);

    void create(StudentVO vo);

    void update(StudentVO vo);

    void remove(java.lang.String pk);

    StudentVO findByPrimaryKey(java.lang.String pk);

}
