import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class CalendarConsole extends Calendar {
    private PrintStream printStream;

    public CalendarConsole(PrintStream printStream) {
        this.printStream = printStream;
    }

    protected void printDay(int dayNumber) {
        printStream.printf("%3s ", dayNumber);
    }

    protected void printWeekend(int dayNumber) {
        printStream.printf("\u001B[31m%3s\u001B[0m ", dayNumber);
    }

    protected void printHighlightedDay(int dayNumber) {
        printStream.printf("\u001B[32m%3s\u001B[0m ", dayNumber);
    }

    protected void printOffsettedDays(int countOfDays) {
        for (int i = 0; i < countOfDays; i++) {
            printStream.print("    ");
        }
    }

    protected void printEndOfWeek() {
        printStream.println();
    }

    protected void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        for (String day : dayList) {
            printStream.printf("\u001B[36m%3s \u001B[0m", day);
        }
        printStream.println();
    }
}
