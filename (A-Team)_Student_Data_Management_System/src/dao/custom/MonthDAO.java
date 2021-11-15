package dao.custom;

import dao.SuperDAO;
import entity.MonthEntity;

import java.util.List;

public interface MonthDAO extends SuperDAO<MonthEntity, String> {
    List<MonthEntity> getAll() throws Exception;
    public  int getId(String monthName)throws Exception;
    String getName(int monthId) throws Exception;
}
