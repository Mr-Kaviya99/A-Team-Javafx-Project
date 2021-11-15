package bo.custom;

import dto.BatchDTO;

import java.util.ArrayList;

public interface BatchBO {
    public ArrayList<BatchDTO> getAll()throws Exception;
    public  int getId(String batchName)throws Exception;
    public  String getName(int batchId)throws Exception;
}
