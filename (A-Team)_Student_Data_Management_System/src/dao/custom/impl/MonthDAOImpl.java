package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.MonthDAO;
import entity.MonthEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonthDAOImpl implements MonthDAO {
    @Override
    public List<MonthEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM month");
        ArrayList<MonthEntity> monthList = new ArrayList<>();
        while (resultSet.next()){
            monthList.add(
                    new MonthEntity(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
        }
        return monthList;
    }

    @Override
    public int getId(String monthName) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM month WHERE name=?",monthName);
        int monthId = 0;
        if (resultSet.next()){
            monthId = resultSet.getInt(1);
        }
        return monthId;
    }

    @Override
    public String getName(int monthId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT name FROM month WHERE id=?",monthId);
        String monthName = "";
        if (resultSet.next()){
            monthName = resultSet.getString(1);
        }
        return monthName;
    }
}
