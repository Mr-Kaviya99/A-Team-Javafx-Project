package dao;

import dao.custom.impl.*;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DaoFactory()) : daoFactory ;
    }

    public enum DAOType {
       STUDENT,BATCH,COURSE,ATTENDANCE,MONTH,PAYMENT,EXAM
    }

    public <T extends SuperDAO> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case BATCH:
                return (T) new BatchDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case ATTENDANCE:
                return (T) new AttendanceDAOImpl();
            case MONTH:
                return (T) new MonthDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case EXAM:
                return (T) new ExamDAOImpl();
            default:
                return null;
        }
    }
}
