package com.itechart.streamapitrain;

import com.itechart.streamapitrain.model.Specialist;
import com.itechart.streamapitrain.model.Specialty;
import com.itechart.streamapitrain.services.StreamAPIService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ProgramRunner {

    public static void main(String[] args) {
        //List<Specialist> specialists = OldApproachService.getSpecialists();
        List<Specialist> specialists = StreamAPIService.getSpecialists();

        // Filter
//        List<Specialist> engineers = OldApproachService.filterBySpecialty(specialists, Specialty.ENGINEER);
        List<Specialist> engineers = StreamAPIService.filterBySpecialty(specialists, Specialty.ENGINEER);
        StreamAPIService.printSpecialists(engineers);

        // Sorting
        List<Specialist> sortedSpecialistsAsc = StreamAPIService.sortSpecialistsByNameAsc(specialists);
        List<Specialist> sortedSpecialistsDesc = StreamAPIService.sortSpecialistsByNameDesc(specialists);
        StreamAPIService.printSpecialists(sortedSpecialistsAsc);
        StreamAPIService.printSpecialists(sortedSpecialistsDesc);

        // Max salary
        Specialist withMaxSalary = StreamAPIService.findWithMaxSalary(specialists);
        System.out.println(withMaxSalary);
        // Min salary
        Specialist withMinSalary = StreamAPIService.findWithMinSalary(specialists);
        System.out.println(withMinSalary);

        // Grouping
        Map<Specialty, List<Specialist>> groupedBySpecialty = StreamAPIService.groupBySpecialty(specialists);
        System.out.println(groupedBySpecialty);

        // All engineers
//        boolean allEngineers = OldApproachService.matchAllEngineers(specialists);
        boolean allEngineers = StreamAPIService.matchAllEngineers(specialists);
        System.out.println(allEngineers);

        // Any engineers
//        boolean anyEngineer = OldApproachService.matchAnyEnginner(specialists);
        boolean anyEngineer = StreamAPIService.matchAnyEngineer(specialists);
        System.out.println(anyEngineer);

        // All salary more then
        //boolean allSalaryMoreThen1000 = OldApproachService.matchAllSalaryMoreThen(specialists, new BigDecimal(10000));
        boolean allSalaryMoreThen1000 = StreamAPIService.matchAllSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(allSalaryMoreThen1000);

        // No one with salary more then
//        boolean noOneWithSalaryMoreThen10000 = OldApproachService.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        boolean noOneWithSalaryMoreThen10000 = StreamAPIService.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(noOneWithSalaryMoreThen10000);
    }

}
