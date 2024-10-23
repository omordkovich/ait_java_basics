package ait.homework_45.titanic_statistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TitanicStatisticsImpl implements TitanicStatistics {
    private final List<String[]> str;

    public TitanicStatisticsImpl(List<String[]> str) {
        this.str = str;
    }

    // выручка от билетов
    @Override
    public double totalFares() {
        return str.stream()
                .map(fare -> fare[10])
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    // средняя стоимость билетов по классам
    @Override
    public Map<String, Double> avgFaresByClasses() {
        return str.stream()
                .collect(Collectors.groupingBy(pClass -> pClass[2], Collectors.averagingDouble(fare -> Double.parseDouble(fare[10]))));
    }

    // выжили и не выжили
    @Override
    public Map<String, Long> totalSurvived() {
        return str.stream()
                .collect(Collectors.groupingBy(survived -> survived[1], Collectors.counting()));
    }

    // выжили по полу
    @Override
    public Map<String, Long> totalSurvivedByGender() {
        return str.stream()
                .filter(data -> data[1].equals("1"))
                .collect(Collectors.groupingBy(gender -> gender[5], Collectors.counting()));
    }

    // выжили и не выжили дети
    @Override
    public Map<String, Long> totalSurvivedChildren() {
        return str.stream()
                .filter(empty-> !empty[6].equals(""))
                .filter(children -> Double.parseDouble(children[6]) < 18)
                .collect(Collectors.groupingBy(survived -> survived[1], Collectors.counting()));
    }
}
