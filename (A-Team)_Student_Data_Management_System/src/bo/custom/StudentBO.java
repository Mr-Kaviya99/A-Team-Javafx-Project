package bo.custom;

import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO {
    public boolean saveStudent(StudentDTO dto)throws Exception;
    public boolean updateStudent(StudentDTO dto)throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public List<StudentDTO> getAllStudent()throws Exception;
    public String getStudentId()throws Exception;
    public  int getCount() throws Exception;
}
