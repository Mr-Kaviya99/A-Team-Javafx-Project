package bo.custom.impl;

import bo.custom.AttendanceBO;
import dao.DaoFactory;
import dao.custom.AttendanceDAO;
import dto.AttendanceDTO;
import dto.StudentDTO;
import entity.AttendanceEntity;
import entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO attendanceDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ATTENDANCE);

    @Override
    public List<AttendanceDTO> getAllAttendance() throws Exception {
        List<AttendanceEntity> all = attendanceDAO.getAll();
        ArrayList<AttendanceDTO> allAttendance = new ArrayList<>();
        for (AttendanceEntity search:all){
            allAttendance.add(new AttendanceDTO(
                    search.getAttendanceId(),
                    search.getStudentId(),
                    search.getBatchId(),
                    search.getArrivalTime(),
                    search.getLeavingTime()
            ));
        }
        return allAttendance;
    }

    @Override
    public boolean addArrival(AttendanceDTO dto) throws Exception {
        return attendanceDAO.save(new AttendanceEntity(
                dto.getAttId(),
                dto.getStudentId(),
                dto.getBatchId(),
                dto.getArrivalTime(),
                dto.getLeavingTime()
        ));
    }

    @Override
    public boolean addLeaving(AttendanceDTO dto) throws Exception {
        return attendanceDAO.update(new AttendanceEntity(
                dto.getAttId(),
                dto.getStudentId(),
                dto.getBatchId(),
                dto.getArrivalTime(),
                dto.getLeavingTime()
        ));
    }
}
