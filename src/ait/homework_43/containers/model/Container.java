package ait.homework_43.containers.model;

import java.util.Iterator;
import java.util.List;

/*
задача о Контейнерах и Посылках:
Создайте класс Container с полями: String label (маркировка) и List - список коробок с посылками.

 */
public class Container implements Iterable<Box>{
   private String label;
   private List<Box>boxes;

   public Container(String label, List<Box> boxes) {
      this.label = label;
      this.boxes = boxes;
   }

   public String getLabel() {
      return label;
   }

   public List<Box> getBoxes() {
      return boxes;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("Container{");
      sb.append("label='").append(label).append('\'');
      sb.append(", boxes=").append(boxes);
      sb.append('}');
      return sb.toString();
   }

   @Override
   public Iterator<Box> iterator() {
      return boxes.iterator();

   }
}
