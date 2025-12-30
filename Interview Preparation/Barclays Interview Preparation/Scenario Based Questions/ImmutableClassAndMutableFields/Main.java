package ImmutableClassAndMutableFields;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        Date date = Date.from(
                localDate
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );

        Employee emp1 =
                new Employee("1001", "Vamshi", date, 31_000);

        System.out.println(emp1);
    }
}
