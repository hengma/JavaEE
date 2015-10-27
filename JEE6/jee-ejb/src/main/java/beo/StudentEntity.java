package beo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="StudentEntity")
@Table(name="STUDENT")
public class StudentEntity {
	
    @Id
    //@SequenceGenerator(name="SEQ_STUDENT", sequenceName="SEQ_STUDENT", allocationSize=0)
    //@GeneratedValue(generator="SEQ_STUDENT", strategy = GenerationType.SEQUENCE)
    @Column(name="ID", length=100)
    String id;
    @Column(name="NAME", length=100)
    String name;
    @Column(name="GENDER", length=6)
    String gender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.lang.String getPrimaryKey() {
        return id;
    }
	
	
	/*
	Foreign Table: 
	 			@ManyToOne
  				@JoinColumn(name="SUBJECT_ID")
  				private SubjectEntity subject;
  				
	 Relationship
	 Parent Table: 
	 			@OneToMany(mappedBy="subject")
	 			private List<StudentEntity> students;
	 
	 */
}