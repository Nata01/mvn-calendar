import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class CalendarText extends Calendar {
    protected PrintStream printStream;

    public CalendarText(PrintStream printStream) {
        this.printStream = printStream;
    }

    protected void printDay(int j) {
        printStream.printf("%3s ", j);
    }

    protected void printOffsettedDays(int countOfDays) {
        for (int i = 0; i < countOfDays; i++) {
            printStream.print("    ");
        }
    }

    protected void printWeekend(int j) {
        printStream.printf("%3s ", j);
    }

    protected void printHighlightedDay(int j) {
        printStream.printf("%3s ", j);
    }

    protected void printEndOfWeek() {
        printStream.println();
    }

    protected void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        printStartOfWeek();
        for (String day : dayList) {
            printStream.printf("%3s ", day);
        }
        printEndOfWeek();
    }
}
