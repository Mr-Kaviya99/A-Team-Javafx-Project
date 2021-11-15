package bo.custom.impl;

import bo.custom.ExamBO;
import dao.DaoFactory;
import dao.custom.ExamDAO;
import dto.ExamDTO;
import entity.ExamEntity;
import entity.StudentEntity;


public class ExamBOImpl implements ExamBO {

    ExamDAO examDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.EXAM);

    @Override
    public boolean Save(ExamDTO examDTO) throws Exception {
        return examDAO.save(new ExamEntity(examDTO.getExamID(),
                examDTO.getExamName()
        ));
    }

    @Override
    public int getNextId() throws Exception {
        return examDAO.getNextId();
    }
}
