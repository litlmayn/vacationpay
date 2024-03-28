package ru.litlmayn.vacationpay.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalculateVacationPayService {

    // Среднее количество дней в месяце.
    private static final double AVERAGE_DAYS_MONTH = 29.3;

    /*
    Создам перегруженный метод для расчета отпускных - calculateVacationPay.
    В первом случае будем производить расчет исходя из количества дней в отпуске и средней зарплате в течение года,
    а во втором случае будут те же входные данные, что и в первом методе + день начала отпуска.
    */

    // Метод для расчета отпускных без учета праздничных дней.
    public static String calculateVacationPay(
            double salaryYear,
            int countDaysVacation
    ) {
        return String.format("Сумма отпускных равна %.2f.", calculator(salaryYear, countDaysVacation));
    }

    // Метод для расчета отпускных с учета праздничных дней.
    public static String calculateVacationPay(
            double salaryYear,
            int countDaysVacation,
            LocalDate startVacation
    ) {
        CalculateCountDaysService calculateCountDaysService = new CalculateCountDaysService();
        countDaysVacation = calculateCountDaysService.calculateDaysVacation(countDaysVacation, startVacation);
        return String.format("Сумма отпускных равна %.2f.", calculator(salaryYear, countDaysVacation));
    }

    // Метод рассчитывающий отпускные.
    private static double calculator(double salaryYear, int countDaysVacation) {
        return salaryYear / AVERAGE_DAYS_MONTH * countDaysVacation;
    }
}
