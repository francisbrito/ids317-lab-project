package edu.intec.ids;

import java.util.Date;

enum Month {
    JANUARY     (1),
    FEBRUARY    (2),
    MARCH       (3),
    APRIL       (4),
    MAY         (5),
    JUNE        (6),
    JULY        (7),
    AUGUST      (8),
    SEPTEMBER   (9),
    OCTOBER     (10),
    NOVEMBER    (11),
    DECEMBER    (12);

    private int value;

    Month(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public static final int[] MONTHS_WITH_30_DAYS = {
        Month.APRIL.getValue(),
        Month.JUNE.getValue(),
        Month.SEPTEMBER.getValue(),
        Month.NOVEMBER.getValue()
    };

    public static final int[] MONTHS_WITH_31_DAYS = {
        Month.JANUARY.getValue(),
        Month.MARCH.getValue(),
        Month.MAY.getValue(),
        Month.JULY.getValue(),
        Month.AUGUST.getValue(),
        Month.OCTOBER.getValue(),
        Month.DECEMBER.getValue()
    };

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int day) {
        if (day <= 0) {
            throw new IllegalArgumentException("'day' cannot be negative or zero.");
        }

        if (day > 31) {
            throw new IllegalArgumentException("'day' cannot be greater than 31.");
        }

        if (this.month == Month.FEBRUARY.getValue()) {
            if (!isLeapYear(this.year) && day > 28) {
                throw new IllegalArgumentException("'day' for February cannot be greater than 28 on a non-leap year.");
            } else if (isLeapYear(this.year) && day > 29) {
                throw new IllegalArgumentException("'day' for February cannot be greater than 29 on a leap year.");
            }
        }

        if ((monthHas30Days(this.month) && day > 30) ||
            (monthHas31Days(this.month) && day > 31)) {
            throw new IllegalArgumentException("'day' is outside of boundaries for month.");
        }

        this.day = day;
    }

    public void setMonth(int month) {
        if (month <= 0) {
            throw new IllegalArgumentException("'month' cannot be negative or zero.");
        }

        if (month > Month.DECEMBER.getValue()) {
            throw new IllegalArgumentException("'month' cannot be beyond December.");
        }

        this.month = month;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("'year' cannot be negative.");
        }

        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    public static boolean monthHas30Days(int month) {
        for (int m : MONTHS_WITH_30_DAYS) {
            if (month == m) {
                return true;
            }
        }

        return false;
    }

    public static boolean monthHas31Days(int month) {
        for (int m : MONTHS_WITH_31_DAYS) {
            if (month == m) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimpleDate) {
            SimpleDate comparee = (SimpleDate) obj;

            if (this.day == comparee.day &&
                this.month == comparee.month &&
                this.year == comparee.year) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%1$d - %2$d - %3$d", this.day, this.month, this.year);
    }
}