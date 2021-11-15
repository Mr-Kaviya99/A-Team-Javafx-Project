package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DaoFactory;
import dao.custom.CourseDAO;
import dto.BatchDTO;
import dto.CourseDTO;
import entity.CourseEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    private CourseDAO courseDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.COURSE);

    @Override
    public ArrayList<CourseDTO> getAll() throws Exception {
        List<CourseEntity> tList = courseDAO.getAll();
        ArrayList<CourseDTO> dtoList = new ArrayList();
        for (CourseEntity T : tList){
            dtoList.add(new CourseDTO(T.getCourseID(),
                    T.getCourseName()));
        }

        return dtoList;
    }

    @Override
    public int getId(String courseName) throws Exception {
        return courseDAO.getId(courseName);
    }

    @Override
    public String getName(int courseId) throws Exception {
        return courseDAO.getName(courseId);
    }
}
