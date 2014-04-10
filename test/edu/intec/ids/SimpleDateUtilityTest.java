package edu.intec.ids;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SimpleDateUtilityTest {
    @Test(expected=IllegalArgumentException.class)
    public void testIsLeapYearThrowsIfArgumentIsNegative() {
        int subject = -1;

        SimpleDateUtility.isLeapYear(subject);
    }

    @Test
    public void testIsLeapYearReturnsFalseIfYearIsNotLeap() {
        int subject = 1;

        boolean expected = SimpleDateUtility.isLeapYear(subject);

        assertFalse(expected);
    }

    @Test
    public void testIsLeapYearReturnsTrueIfYearIsLeap() {
        int subject = 4;

        boolean expected = SimpleDateUtility.isLeapYear(subject);

        assertTrue(expected);
    }

    @Test
    public void testMoveAYearShouldIncreaseADateByOneYear() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        SimpleDate expected = new SimpleDate(1, 1, 2);

        SimpleDate result = SimpleDateUtility.moveAYear(subject);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveAMonthShouldIncreaseADateByOneMonth() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        SimpleDate expected = new SimpleDate(1, 2, 1);

        SimpleDate result = SimpleDateUtility.moveAMonth(subject);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveAMonthShouldCarryOverIfMonthIsDecember() {
        SimpleDate subject = new SimpleDate(1, 12, 1);
        SimpleDate expected = new SimpleDate(1, 1, 2);

        SimpleDate result = SimpleDateUtility.moveAMonth(subject);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveADayShouldIncreaseADateByOneDay() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        SimpleDate expected = new SimpleDate(2, 1, 1);

        SimpleDate result = SimpleDateUtility.moveADay(subject);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveADayShouldCarryOverAMonthIfDayIsLastDayOfMonth() {
        SimpleDate subject = new SimpleDate(31, 1, 1);
        SimpleDate expected = new SimpleDate(1, 2, 1);

        SimpleDate result = SimpleDateUtility.moveADay(subject);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveADayShouldCarryOverAYearIfDayIsLastDayOfDecember() {
        SimpleDate subject = new SimpleDate(31, 12, 1);
        SimpleDate expected = new SimpleDate(1, 1, 2);

        SimpleDate result = SimpleDateUtility.moveADay(subject);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveYearByShouldIncreaseADateByGivenYears() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        int years = 4;
        SimpleDate expected = new SimpleDate(1, 1, 5);

        SimpleDate result = SimpleDateUtility.moveYearBy(subject, years);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveMonthByShouldIncreaseADateByGivenMonths() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        int months = 7;
        SimpleDate expected = new SimpleDate(1, 8, 1);

        SimpleDate result = SimpleDateUtility.moveMonthBy(subject, months);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveMonthByShouldCarryOverIfGivenMonthsAreBeyondDecember() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        int months = 12;
        SimpleDate expected = new SimpleDate(1, 1, 2);

        SimpleDate result = SimpleDateUtility.moveMonthBy(subject, months);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveByDayIncreaseADateByGivenDays() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        int days = 10;
        SimpleDate expected = new SimpleDate(11, 1, 1);

        SimpleDate result = SimpleDateUtility.moveDayBy(subject, days);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveByDayCarryOverMonthsIfGivenDaysAreBeyondLastDayOfMonth() {
        SimpleDate subject = new SimpleDate(1, 6, 1);
        int days = 30;
        SimpleDate expected = new SimpleDate(1, 7, 1);

        SimpleDate result = SimpleDateUtility.moveDayBy(subject, days);

        assertEquals(expected, result);

        days = 70;
        expected = new SimpleDate(10, 8, 1);

        result = SimpleDateUtility.moveDayBy(subject, days);

        assertEquals(expected, result);
    }

    @Test
    public void testMoveDayByCarryOverYearsIfGivenDaysAreBeyondLastDayOfYear() {
        SimpleDate subject = new SimpleDate(1, 1, 1);
        int days = 365;
        SimpleDate expected = new SimpleDate(1, 1, 2);

        SimpleDate result = SimpleDateUtility.moveDayBy(subject, days);

        assertEquals(expected, result);

        subject = new SimpleDate(1, 1, 4);
        days = 366;
        expected = new SimpleDate(1, 1, 5);

        result = SimpleDateUtility.moveDayBy(subject, days);

        assertEquals(expected, result);
    }
}
