package bo;

import bo.custom.impl.BatchBOImpl;
import bo.custom.impl.CourseBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getInstance() {
        return (boFactory == null) ? (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BoType{
        STUDENT,BATCH,COURSE
    }

        public <T> T getBo(BoType botype) {

        switch (botype){
            case STUDENT :
                return (T) new StudentBOImpl();
            case BATCH:
                return (T) new BatchBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            default:
                return null;
        }

    }
}
