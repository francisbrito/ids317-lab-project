package edu.intec.ids;

public abstract class SimpleDateUtility {
    public static boolean isLeapYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("'year' cannot be negative.");
        }

        return year % 4 == 0;
    }

    public static SimpleDate moveAYear(SimpleDate date) {
        int year = date.getYear();

        date.setYear(year + 1);

        return date;
    }

    public static SimpleDate moveAMonth(SimpleDate date) {
        int month = date.getMonth();
        int year = date.getYear();

        if (month == Month.DECEMBER.getValue()) {
            date = moveAYear(date);
            month = 1;
        } else {
            month++;
        }

        date.setMonth(month);

        return date;
    }

    public static SimpleDate moveADay(SimpleDate date) {
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();

        if (isLastDayOfMonth(day, month, year)) {
            date = moveAMonth(date);
            day = 1;
        } else {
            day++;
        }

        date.setDay(day);

        return date;
    }

    private static boolean isLastDayOfMonth(int day, int month, int year) {
        boolean result = false;

        if (month == Month.FEBRUARY.getValue()) {
            if (SimpleDate.isLeapYear(year)) {
                result = day == 29;
            } else {
                result = day == 28;
            }
        } else if (SimpleDate.monthHas30Days(month) && day == 30) {
            result = true;
        } else if (SimpleDate.monthHas31Days(month) && day == 31) {
            result = true;
        }

        return result;
    }
}