package ru.litlmayn.vacationpay.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CalculateCountDaysService {

    private List<LocalDate> holidays;

    public CalculateCountDaysService() {

        int thisYear = LocalDate.now().getYear();

        holidays = Arrays.asList(
                LocalDate.of(thisYear, 1, 1),
                LocalDate.of(thisYear, 1, 2),
                LocalDate.of(thisYear, 1, 3),
                LocalDate.of(thisYear, 1, 4),
                LocalDate.of(thisYear, 1, 5),
                LocalDate.of(thisYear, 1, 6),
                LocalDate.of(thisYear, 1, 7),
                LocalDate.of(thisYear, 1, 8),
                LocalDate.of(thisYear, 2, 23),
                LocalDate.of(thisYear, 3, 8),
                LocalDate.of(thisYear, 5, 1),
                LocalDate.of(thisYear, 5, 9),
                LocalDate.of(thisYear, 6, 12),
                LocalDate.of(thisYear, 11, 4)

        );
    }

    public int calculateDaysVacation(int countDaysVacation, LocalDate startVacation) {
        for (int i = 0; i < countDaysVacation; i++) {
            if (holidays.contains(startVacation)) {
                countDaysVacation--;
            }
            startVacation = startVacation.plusDays(1);
        }
        return countDaysVacation;
    }

}
