package dao;

import entity.SuperEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

    public interface CrudDAO <T extends SuperEntity,ID extends Serializable> extends SuperDAO {

        boolean save(T entity)throws Exception;

        boolean update(T entity)throws Exception;

        boolean delete(ID key)throws Exception;

        List<T> getAll() throws Exception;

        T get(ID key)throws Exception;
}
