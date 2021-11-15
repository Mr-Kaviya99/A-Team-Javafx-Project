package bo.custom;

import dto.MonthDTO;

import java.util.ArrayList;

public interface MonthBO {
    public ArrayList<MonthDTO> getAll()throws Exception;
    public  int getId(String monthName)throws Exception;
    public  String getName(int monthId)throws Exception;
}
