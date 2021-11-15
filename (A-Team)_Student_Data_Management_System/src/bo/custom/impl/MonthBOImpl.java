package bo.custom.impl;

import bo.custom.MonthBO;
import dao.DaoFactory;
import dao.custom.MonthDAO;
import dto.MonthDTO;
import entity.MonthEntity;

import java.util.ArrayList;
import java.util.List;

public class MonthBOImpl implements MonthBO {

    private MonthDAO monthDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.MONTH);


    @Override
    public ArrayList<MonthDTO> getAll() throws Exception {
        List<MonthEntity> tList = monthDAO.getAll();
        ArrayList<MonthDTO> dtoList = new ArrayList();
        for (MonthEntity T : tList){
            dtoList.add(new MonthDTO(T.getId(),
                    T.getName()));
        }

        return dtoList;
    }

    @Override
    public int getId(String monthName) throws Exception {
        return monthDAO.getId(monthName);
    }

    @Override
    public String getName(int monthId) throws Exception {
        return monthDAO.getName(monthId);
    }
}
