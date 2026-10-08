class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        };

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Check leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Count days from 1971 to the given date
        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Add days from previous months
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }

        // Add current day
        totalDays += day;

        // January 1, 1971 was Friday
        // Friday = index 5
        return days[(totalDays + 4) % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}