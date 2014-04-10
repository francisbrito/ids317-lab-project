package edu.intec.ids;

public abstract class SimpleDateUtility {
    public static boolean isLeapYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("'year' cannot be negative.");
        }

        return year % 4 == 0;
    }

    public static SimpleDate moveAYear(SimpleDate date) {
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();

        SimpleDate result = new SimpleDate(day, month, year);

        result.setYear(year + 1);

        return result;
    }

    public static SimpleDate moveYearBy(SimpleDate date, int years) {
        SimpleDate result = date;

        for (int i = 1; i <= years; i++) {
            result = moveAYear(result);
        }

        return result;
    }

    public static SimpleDate moveAMonth(SimpleDate date) {
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();

        SimpleDate result = new SimpleDate(day, month, year);

        if (month == Month.DECEMBER.getValue()) {
            result = moveAYear(result);
            month = 1;
        } else {
            month++;
        }

        result.setMonth(month);

        return result;
    }

    public static SimpleDate moveMonthBy(SimpleDate date, int months) {
        SimpleDate result = date;

        for (int i = 1; i <= months; i++) {
            result = moveAMonth(result);
        }

        return result;
    }

    public static SimpleDate moveADay(SimpleDate date) {
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();

        SimpleDate result = new SimpleDate(day, month, year);

        if (isLastDayOfMonth(day, month, year)) {
            result = moveAMonth(result);
            day = 1;
        } else {
            day++;
        }

        result.setDay(day);

        return result;
    }

    public static SimpleDate moveDayBy(SimpleDate date, int days) {
        SimpleDate result = date;

        for (int i = 1; i <= days; i++) {
            result = moveADay(result);
        }

        return result;
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