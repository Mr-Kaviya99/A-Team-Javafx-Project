package bo.custom;

import dto.AttendanceDTO;
import dto.ExamDTO;

import java.util.List;

public interface ExamBO {
    public boolean Save(ExamDTO examDTO)throws Exception;
    public int getNextId()throws Exception;
}
