package codemanipulation.thejava.bytecode_manipulate;

public class Moim {

    public static void main(String[] args) {

    }

    int maxNumberOfAttendees;

    int numberOfEnrollment;

    public boolean isEnrollmentFull(){
        if (maxNumberOfAttendees == 0) {
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees){
            return false;
        }

        return true;
    }

}
