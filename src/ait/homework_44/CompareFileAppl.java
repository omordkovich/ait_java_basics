package ait.homework_44;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
Задание 1. В классе CompareFileAppl реализовать логику сравнения двух файлов в методе main. Имена файлов принимать через массив args.
 Два файла считаем одинаковыми, если у них одинаковая длина, и на тех же позициях стоят те же байты. Результат должен быть
 выведен на консоль в виде сообщения.
 */
public class CompareFileAppl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments!");
        }
        System.out.println("First file direction: " + args[0]);
        System.out.println("Second file direction: " + args[1]);
        boolean duplicate = false;
        try (FileInputStream fin1 = new FileInputStream(args[0])) {
            FileInputStream fin2 = new FileInputStream(args[1]);
            //comparing length of files
            if (fin1.available() == fin2.available()) {
                //comparing bytes equality
                int byteFirst = fin1.read(); //reading first bite by first file
                int byteSecond = fin2.read(); //reading first bite by second file
                while (byteFirst != -1 && byteFirst == byteSecond) {
                    byteFirst = fin1.read();
                    byteSecond = fin2.read();
                    if (byteFirst == -1) {
                        duplicate = true;
                    }
                }
            }
            //output
            if (duplicate) {
                System.out.println("The comparing files are duplicates!");
            } else {
                System.out.println("The comparing files are NOT duplicates!");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
