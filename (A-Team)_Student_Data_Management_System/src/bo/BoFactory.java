package bo;

import bo.custom.impl.*;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getInstance() {
        return (boFactory == null) ? (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BoType{
        STUDENT,BATCH,COURSE,ATTENDANCE,MONTH,PAYMENT,EXAM
    }

        public <T> T getBo(BoType botype) {

        switch (botype){
            case STUDENT :
                return (T) new StudentBOImpl();
            case BATCH:
                return (T) new BatchBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case ATTENDANCE:
                return (T) new AttendanceBOImpl();
            case MONTH:
                return (T) new MonthBOImpl();
            case PAYMENT:
                return (T) new PaymentBOImpl();
            case EXAM:
                return (T) new ExamBOImpl();
            default:
                return null;
        }

    }
}
