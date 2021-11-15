package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.ExamEntity;

public interface ExamDAO  extends CrudDAO<ExamEntity,String> {
    public int getNextId()throws Exception;
}
