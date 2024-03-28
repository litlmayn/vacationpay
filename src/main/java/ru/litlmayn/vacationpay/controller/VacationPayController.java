package ru.litlmayn.vacationpay.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.litlmayn.vacationpay.service.CalculateVacationPayService;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class VacationPayController {

    // В данном методе реализована проверка, входных данных,
    // исходя из которой вызывается нужный метод расчета зарплаты.
    @GetMapping
    public String calculationVacationPay(
            @RequestParam("salary") double averageSalaryYear, // Размер среднегодовой зарплаты.
            @RequestParam("count_days") int countDaysVacation, // Количество дней в отпуске.
            @RequestParam(required = false, value = "day_start_vacation")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startVacation // Дата начала отпуска.
            ) {
        if (startVacation != null) {
            return CalculateVacationPayService.calculateVacationPay(
                    averageSalaryYear, countDaysVacation, startVacation
            );
        }
        return CalculateVacationPayService.calculateVacationPay(
                averageSalaryYear, countDaysVacation
        );
    }
}
