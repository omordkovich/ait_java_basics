package ait.homework_45.titanic_statistics;

import java.util.Map;

public interface TitanicStatistics {
    double totalFares(); // выручка от билетов

    Map<String, Double> avgFaresByClasses(); // средняя стоимость билетов по классам

    Map<String, Long> totalSurvived(); // выжили и не выжили

    Map<String, Long> totalSurvivedByGender(); // выжили по полу

    Map<String, Long> totalSurvivedChildren();// выжили и не выжили дети
}
