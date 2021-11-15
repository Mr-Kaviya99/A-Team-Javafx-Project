package bo.custom.impl;

import bo.BoFactory;
import bo.custom.BatchBO;
import bo.custom.CourseBO;
import bo.custom.StudentBO;
import dao.DaoFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDENT);


    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return studentDAO.save(new StudentEntity(dto.getStudentId(),
                dto.getStudentName(),
                dto.getDob(),
                dto.getCourseId(),
                dto.getBatchId(),
                dto.getAddress(),
                dto.getGuardianName(),
                dto.getGuardianContact()
        ));
    }


    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return studentDAO.update(new StudentEntity(dto.getStudentId(),
                dto.getStudentName(),
                dto.getDob(),
                dto.getBatchId(),
                dto.getCourseId(),
                dto.getAddress(),
                dto.getGuardianName(),
                dto.getGuardianContact()
                ));
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        StudentEntity s=studentDAO.get(id);
        return new StudentDTO(s.getStudentId(),
                s.getStudentName(),
                s.getDob(),
                s.getBatchId(),
                s.getCourseId(),
                s.getAddress(),
                s.getGuardianName(),
                s.getGuardianContact()
        );
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {
        return null;
    }

    @Override
    public String getStudentId() throws Exception {
        return null;
    }

    @Override
    public int getCount() throws Exception {
        return studentDAO.getCount();
    }
}
