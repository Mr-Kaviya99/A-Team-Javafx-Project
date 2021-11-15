package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ExamDAO;
import entity.ExamEntity;

import java.sql.ResultSet;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {
    @Override
    public int getNextId() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT examId FROM Exam ORDER BY examId DESC LIMIT 1");
        int id = 1;
        if (set.next()) {
            id = set.getInt(1);
            id++;
            return id;
        }
        return id;
    }

    @Override
    public boolean save(ExamEntity exam) throws Exception {
        return CrudUtil.execute("INSERT INTO Exam VALUES(?,?)",
                exam.getExamId(),
                exam.getExamName());
    }

    @Override
    public boolean update(ExamEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public List<ExamEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public ExamEntity get(String key) throws Exception {
        return null;
    }
}
