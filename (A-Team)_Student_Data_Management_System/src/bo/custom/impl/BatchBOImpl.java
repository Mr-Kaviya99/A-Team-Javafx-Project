package bo.custom.impl;

import bo.custom.BatchBO;
import dao.DaoFactory;
import dao.custom.BatchDAO;
import dto.BatchDTO;
import entity.BatchEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BatchBOImpl implements BatchBO {


    private BatchDAO batchDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.BATCH);

    @Override
    public ArrayList<BatchDTO> getAll() throws Exception {
        List<BatchEntity> tList = batchDAO.getAll();
        ArrayList<BatchDTO> dtoList = new ArrayList();
        for (BatchEntity T : tList){
            dtoList.add(new BatchDTO(T.getBatchId(),
                    T.getBatchName()));
        }

        return dtoList;
    }

    @Override
    public int getId(String batchName) throws Exception {
        return batchDAO.getId(batchName);
    }

}
