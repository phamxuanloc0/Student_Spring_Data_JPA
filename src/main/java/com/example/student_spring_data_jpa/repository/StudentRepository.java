package com.example.student_spring_data_jpa.repository;


import com.example.student_spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {





    public List<Student> findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);




//--------------------CRUD JPQL--------------------------------------------------
    @Query("select e from Student e where e.id = ?1")
    public Student findByCustomId(Long id);

    @Transactional
    @Modifying
    @Query("update Student e set e.firstName = ?2 where e.id = ?1 ")
    public void updateById(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student e WHERE e.id = ?1")
    public void deleleStudentJPQL(Long id);


    //-----------------------CRUD Native---------------------------------------------------------
    @Query(value = "select * from tbl_student", nativeQuery = true)
    public List<Student> findAllStudentNative();

    @Query(value = "select * from tbl_student where id = ?1"
    ,nativeQuery = true)
    public Student findByStudentNative(Long id);

    @Transactional
    @Modifying
    @Query(value = "update tbl_student e set e.last_name = ?2 where e.id = ?1", nativeQuery = true)
    public void  updateStudentNative(Long id, String lastName);



    @Modifying
    @Query(value = "insert into tbl_student (id,first_name, last_name, mail) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    @Transactional
     public void AddStudent(Long id,String firstName, String lastName, String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_student WHERE id = ?1", nativeQuery = true)
    public void deleleStudent(Long id);



}
