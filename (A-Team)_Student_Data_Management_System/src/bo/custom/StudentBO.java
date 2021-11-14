package bo.custom;

import dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO {
    public boolean saveStudent(StudentDTO dto)throws Exception;
    public boolean updateStudent(StudentDTO dto)throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public ArrayList<StudentDTO> getAllStudent()throws Exception;
    public String getStudentId()throws Exception;

}
