package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.AttendanceEntity;
import entity.StudentEntity;

public interface AttendanceDAO  extends CrudDAO<AttendanceEntity,String> {
    AttendanceEntity get() throws Exception;
}

