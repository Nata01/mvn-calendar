import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class CalendarHtml extends Calendar {
    PrintStream printStream;

    public CalendarHtml(PrintStream printStream) {
        this.printStream = printStream;
    }


    protected void printEndOfWeek() {
        printStream.println("</tr>");
    }

    protected void printStartOfWeek() {
        printStream.print("<tr>");
    }

    protected void printStartOfMonth() {
        printStream.print("<table>");
    }

    protected void printEndOfMonth() {
        printStream.print("</table>");
    }

    protected void printDay(int dayNumber) {
        printStream.printf("<td>%d</td>", dayNumber);
    }

    protected void printHighlightedDay(int dayNumber) {
        printDay(dayNumber);
    }

    protected void printWeekend(int dayNumber) {
        printDay(dayNumber);
    }

    protected void printOffsettedDays(int countOfDays) {
        printStartOfWeek();
        printStream.print("<td colspan=\"" + countOfDays + "\"></td>");
    }

    protected void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        printStartOfWeek();
        for (String day : dayList) {
            printStream.printf("<td>%3s</td>", day);
        }
        printEndOfWeek();
    }
}
