import java.time.*;
import java.time.format.DateTimeFormatter;

public class Solution_340213 {
    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] videoLen = video_len.split(":");
        String[] posTime = pos.split(":");
        String[] opStart = op_start.split(":");
        String[] opEnd = op_end.split(":");

        LocalTime video = LocalTime.of(0,Integer.parseInt(videoLen[0]), Integer.parseInt(videoLen[1]));
        LocalTime now = LocalTime.of(0,Integer.parseInt(posTime[0]), Integer.parseInt(posTime[1]));
        LocalTime start = LocalTime.of(0,Integer.parseInt(opStart[0]), Integer.parseInt(opStart[1]));
        LocalTime end = LocalTime.of(0,Integer.parseInt(opEnd[0]), Integer.parseInt(opEnd[1]));

        if(!now.isBefore(start) && !now.isAfter(end)) {
            now = end;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                if (now.getMinute() == 0 && now.getSecond() < 10) {
                    now = LocalTime.of(0, 0, 0);
                } else {
                    now = now.minusSeconds(10);
                }
            } else if (command.equals("next")) {
                now = now.plusSeconds(10);
                if (now.isAfter(video)) {
                    now = video;
                }
            }
            if (!now.isBefore(start) && !now.isAfter(end)) {
                now = end;
            }
        }

        return now.format(DateTimeFormatter.ofPattern("mm:ss"));
    }
}