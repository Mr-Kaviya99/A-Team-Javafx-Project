package dao.custom;

import dao.CrudDAO;
import entity.StudentEntity;

public interface RegistrationDAO extends CrudDAO<StudentEntity,String> {
    public int getNextId() throws Exception;
}
