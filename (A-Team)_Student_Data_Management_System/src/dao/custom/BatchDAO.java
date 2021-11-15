package dao.custom;

import dao.SuperDAO;
import entity.BatchEntity;

import java.util.List;

public interface BatchDAO  extends SuperDAO<BatchEntity,String> {
    List<BatchEntity> getAll() throws Exception;
    public  int getId(String batchName)throws Exception;
    public int getNextId() throws Exception;
    String getName(int batchId) throws Exception;
}

