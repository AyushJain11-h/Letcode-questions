class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        // Adjust month and year for Zeller's formula
        if (month < 3) {
            month += 12;
            year--;
        }
        
        int K = year % 100;
        int J = year / 100;
        
        int h = (day + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;
        
        // Zeller's output: 0=Saturday, 1=Sunday, ..., 6=Friday
        return days[(h + 6) % 7];
    }
}