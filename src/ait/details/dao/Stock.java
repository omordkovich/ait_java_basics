package ait.details.dao;

import ait.details.model.Detail;

public interface Stock {
    //  добавить деталь на склад
    boolean addDetail(Detail detail);
    //  найти по barCode
    Detail findByBarCode(long barCode);
    // обновить данные о детали
    Detail updateDetail(Detail detail);
    //удалить деталь
    Detail removeDetail(long barCode);
    //общая масса всех деталей
    double totalWeight();
    //средняя масса всех деталей
    double averageWeight();
    //найти детали с размером от и до
    Detail[] findByCustomSize(double size1, double size2);
}
