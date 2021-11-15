package bo.custom;

import dto.AttendanceDTO;
import dto.StudentDTO;

import java.util.List;

public interface AttendanceBO {
    public List<AttendanceDTO> getAllAttendance()throws Exception;
    public boolean addArrival(AttendanceDTO dto)throws Exception;
    public boolean addLeaving(AttendanceDTO dto)throws Exception;
}
