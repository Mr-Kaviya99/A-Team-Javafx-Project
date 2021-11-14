package dao;

import dao.custom.impl.BatchDAOImpl;
import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.ExamDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DaoFactory()) : daoFactory ;
    }

    public enum DAOType {
       STUDENT,BATCH,COURSE
    }

    public <T extends SuperDAO> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case BATCH:
                return (T) new BatchDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            default:
                return null;
        }
    }
}
