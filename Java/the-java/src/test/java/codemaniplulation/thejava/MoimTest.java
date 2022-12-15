package codemaniplulation.thejava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MoimTest {

    @Test
    void isFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;
        assertFalse(moim.isEnrollmentFull());
    }

}