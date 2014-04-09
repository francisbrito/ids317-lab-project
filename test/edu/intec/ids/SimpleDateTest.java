package edu.intec.ids;

import java.lang.IllegalArgumentException;

import org.junit.Test;

public class SimpleDateTest {
    @Test(expected=IllegalArgumentException.class)
    public void testSetDayThrowsIfArgumentIsNegativeOrZero() {
        SimpleDate subject = new SimpleDate(1, 1, 1);

        subject.setDay(-1);
        subject.setDay(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetDayThrowsIfArgumentIsBeyondGreatestDayNumber() {
        SimpleDate subject = new SimpleDate(1, 1, 1);

        subject.setDay(32);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetDayThrowsIfArgumentNotInDayBoundariesForMonth() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        subject.setDay(32);

        subject = new SimpleDate(1, 2, 1);
        subject.setDay(29);

        subject = new SimpleDate(1, 2, 4);
        subject.setDay(30);

        subject = new SimpleDate(1, 4, 1);
        subject.setDay(31);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMonthThrowsIfArgumentIsNegativeOrZero() {
        SimpleDate subject = new SimpleDate(1, 1, 1);

        subject.setMonth(-1);
        subject.setMonth(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMonthThrowsIfArgumentIsBeyondGreatestMonthNumber() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        subject.setMonth(13);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetYearThrowsIfArgumentIsNegative() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        subject.setYear(-1);
    }
}
