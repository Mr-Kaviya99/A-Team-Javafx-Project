package dao.custom.impl;

import dao.CrudUtil;
import dao.DaoFactory;
import dao.custom.BatchDAO;
import entity.BatchEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BatchDAOImpl implements BatchDAO {

    @Override
    public List<BatchEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Batch");
        ArrayList<BatchEntity> batchList = new ArrayList<>();
        while (resultSet.next()){
            batchList.add(
                    new BatchEntity(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
        }
        return batchList;
    }

    @Override
    public int getId(String batchName) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT batchId FROM Batch WHERE batchName=?",batchName);
        int batchId = 0;
        if (resultSet.next()){
            batchId = resultSet.getInt(1);
        }
        return batchId;
    }

    @Override
    public int getNextId() throws Exception {
        return 0;
    }

    @Override
    public String getName(int batchId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT batchName FROM Batch WHERE batchId=?",batchId);
        String batchName = "";
        if (resultSet.next()){
            batchName = resultSet.getString(1);
        }
        return batchName;
    }
}
