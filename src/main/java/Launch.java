import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;

//javac -d ./out -sourcepath ./src/main/java ./src/main/java/*.java
//java -cp ./out Launch April 2016

public class Launch {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        PrintStream printStream = new PrintStream("Calendar.html");
        Calendar calendar = new CalendarHtml(printStream);
        if (args.length > 0) {
            System.out.println(args[0]);
            printReceivedMonth(calendar, args[0], args[1]);
        } else {
            printCurrentMonth(calendar);
        }
    }

    private static void printReceivedMonth(Calendar calendar, String monthName, String year) throws ParseException {
        YearMonth receivedMonth = YearMonth.of(Integer.parseInt(year), getMonthValue(monthName));
        calendar.printMonth(receivedMonth, 1);
    }

    public static int getMonthValue(String monthName){
        String[] monthNames = new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        monthName = monthName.substring(0, 3);
        for (int i = 0; i < monthNames.length; i++) {
            if (monthName.equalsIgnoreCase(monthNames[i])) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private static void printCurrentMonth(Calendar calendar) {
        int currentDay = LocalDate.now().getDayOfMonth();
        YearMonth currentMonth = YearMonth.now();
        calendar.printMonth(currentMonth, currentDay);
        System.out.println();
    }
}