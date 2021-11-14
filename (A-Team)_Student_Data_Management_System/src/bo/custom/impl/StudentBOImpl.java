package bo.custom.impl;

import bo.BoFactory;
import bo.custom.BatchBO;
import bo.custom.CourseBO;
import bo.custom.StudentBO;
import dao.DaoFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.StudentEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {


    ObservableList<String> batchList= FXCollections.observableArrayList();
    ObservableList<String> courseList=FXCollections.observableArrayList();

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
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {

        List<StudentEntity> TList = studentDAO.getAll();
        ArrayList<StudentDTO> dtoList = new ArrayList();
        for (StudentEntity T: TList) {
            dtoList.add(new StudentDTO(
                    T.getStudentId(),
                    T.getStudentName(),
                    T.getDob(),
                    T.getCourseId(),
                    T.getBatchId(),
                    T.getAddress(),
                    T.getGuardianName(),
                    T.getGuardianContact()
                    ));

        }
        return dtoList;
    }

    @Override
    public String getStudentId() throws Exception {
        return null;
    }
}
