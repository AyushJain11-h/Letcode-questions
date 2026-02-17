import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        backtrack(result, turnedOn, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, int turnedOn, int index, int hours, int minutes) {
        if (hours > 11 || minutes > 59) return;

        if (turnedOn == 0) {
            result.add(String.format("%d:%02d", hours, minutes));
            return;
        }

        for (int i = index; i < 10; i++) {
            if (i < 4) { // hour LEDs
                backtrack(result, turnedOn - 1, i + 1, hours + (1 << i), minutes);
            } else {     // minute LEDs
                backtrack(result, turnedOn - 1, i + 1, hours, minutes + (1 << (i - 4)));
            }
        }
    }
}
