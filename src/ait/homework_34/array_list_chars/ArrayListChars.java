package ait.homework_34.array_list_chars;
//Задача 3. Заполните структуру типа ArrayList<> символами латинского алфавита от A(65) до Z(...).

import java.util.ArrayList;

public class ArrayListChars {
    public static void main(String[] args) {
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 65; i < 91; i++) {
            charList.add((char) (i));
        }
        System.out.println(charList);
    }
}
