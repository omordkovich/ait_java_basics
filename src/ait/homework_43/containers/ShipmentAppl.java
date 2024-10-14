package ait.homework_43.containers;

import ait.homework_43.containers.model.Box;
import ait.homework_43.containers.model.Container;
import ait.homework_43.containers.model.Parcel;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ShipmentAppl {
    public static void main(String[] args) {
        Random random = new Random();
        //Задумайте случайное количество контейнеров (от 10 до 20)
        int containerCount = random.nextInt(10, 21);
        //Создаём контейнеры >с коробками >и с посылками
        List<Container> containers = IntStream.range(0, containerCount)
                .mapToObj(i -> {
                    //создаём лейбл для контейнера
                    String containerLabel = "Container Nr: " + (i + 1);
                    //В каждом контейнере задумайте случайное количество коробок (от 10 до 20)
                    int boxCount = random.nextInt(10, 21);
                    List<Box> boxes = IntStream.range(0, boxCount)
                            .mapToObj(_ -> {
                                // В каждой коробке задумайте случайное количество посылок (от 5 до 10)
                                int parcelCount = random.nextInt(5, 11);
                                List<Parcel> parcels = IntStream.range(0, parcelCount)
                                        .mapToObj(_ -> {
                                            // Предположим, что каждая посылка в среднем имеет вес = 2 кг.
                                            double weight = random.nextDouble(1.5, 2.5); //присваиваем вес посылки
                                            return new Parcel(weight);// возвращаем посылку с весом
                                        })
                                        .toList();
                                return new Box(parcels);
                            })
                            .toList();
                    return new Container(containerLabel, boxes); // возвращаем полный контейнер
                })
                .toList();
        //Подсчитайте общее количество посылок во всех ящиках
        int totalCountOfParcels = countAllParcels(containers);
        System.out.println("Total parcels count: " + totalCountOfParcels);

        //Подсчитайте общий вес посылок.
        double totalWeight = calcTotalWeight(containers);
        System.out.printf("Total weight of all parcels is %.2f kg%n", totalWeight);

        // Найдите label того из контейнеров, в котором оказалось максимальное количество посылок.
        String maxLabel = getLabelOfContainerMax(containers);
        System.out.println("Maximum parcel contains in container with label: " + maxLabel);

        //Найдите все контейнеры с максимальным количеством посылок.
        List<Container> maxContainers = findTop5Containers(containers);
        System.out.println("List of containers with maximum number of parcels:");
        //печать стримом
        maxContainers
                .forEach(c -> System.out.println(c.getLabel()));


        //печать
       /* containers.forEach(container -> {
            System.out.println("Container label: " + container.getLabel());
            container.forEach(box -> {
                System.out.println("  Box:");
                box.forEach(parcel -> {
                    System.out.printf("    Parcel weight: %.2f kg\n", parcel.getWeight());
                });
            });
        });*/
    }

    private static List<Container> findTop5Containers(List<Container> containers) {
        return containers.stream()
                //сортировка по количеству посылок по убыванию
                .sorted((c1, c2) -> {
                    long c1Parcels = c1.getBoxes().stream()
                            .mapToLong(box -> box.getParcels().size())
                            .sum();
                    long c2Parcels = c2.getBoxes().stream()
                            .mapToLong(box -> box.getParcels().size())
                            .sum();
                    return Long.compare(c2Parcels, c1Parcels); // сортировка по убыванию
                })
                .limit(5)
                .toList();
    }


    // Ищет label того из контейнеров, в котором оказалось максимальное количество посылок.
    private static String getLabelOfContainerMax(List<Container> containers) {
        return containers.stream()
                .max((c1, c2) -> {
                    long c1Parcels = c1.getBoxes().stream()
                            .mapToLong(box -> box.getParcels().size())
                            .sum();
                    long c2Parcels = c2.getBoxes().stream()
                            .mapToLong(box -> box.getParcels().size())
                            .sum();
                    return Long.compare(c1Parcels, c2Parcels);
                })
                .map(Container::getLabel)
                .orElse("None");
    }

    //считает общий вес посылок.
    private static double calcTotalWeight(List<Container> containers) {
        return containers.stream()
                .flatMap(container -> container.getBoxes().stream()) //получаем поток коробок
                .flatMap(box -> box.getParcels().stream())   //получаем поток посылок
                .mapToDouble(Parcel::getWeight)    // Получаем вес каждой посылки
                .sum();
    }

    //считает общее количество посылок во всех ящиках
    private static int countAllParcels(List<Container> containers) {
        return containers.stream()
                .flatMap(container -> container.getBoxes().stream()) //поток коробок из контейнеров
                .mapToInt(box -> box.getParcels().size()) //считаем поток посылок из каждой коробки
                .sum();
    }
}

