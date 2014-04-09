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
}
