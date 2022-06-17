package org.example;

import javax.swing.*;
import java.util.Scanner;

//funkcja weryfikujaca czy string to liczba rzeczywista dodatnia
class IsStringNumber {
    public static boolean verify(String liczba) {

        String trimmedNumber = liczba.trim();
        int stringLenght = trimmedNumber.length();
        boolean result = false;
        int iteracje = 0;

        for (int i = 0; i < stringLenght; i++) {
            //usuniecie zbednych spacji
            char znak = trimmedNumber.charAt(i);
            System.out.println(znak);
            //sprawdzenie czy w stringu sa liczby - kody ASCII 48-57 lub znak . ale nie na 1-szej lub ostatniej pozycji
            if ((znak >= 48 && znak <= 57) || (i > 0 && i < stringLenght - 1 && znak == '.')) {
                result = true;
                iteracje = i;
            } else {
                result = false;
                iteracje = i;
                break;
            }
            
        }

        System.out.println("iteracje: " + iteracje);
        System.out.println("result: " + result);
        System.out.println("---------------");
        return result;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String temp;
        double L;
        double R;
        double H;

        JOptionPane.showMessageDialog(null, "Obliczmy poziom cieczy w zbiorniku (cysterna).");
        // zbieranie danych i kontrola czy uzytkownik podal liczbe rzeczywista

        do {
            temp = JOptionPane.showInputDialog("Podaj dlugosc zbiornika [m]");
        } while (!IsStringNumber.verify(temp));
        L = Double.parseDouble(temp);

        do {
            temp = JOptionPane.showInputDialog("Podaj srednice zbiornika [m]");
        } while (!IsStringNumber.verify(temp));
        R = Double.parseDouble(temp) / 2;

        do {
            do {
                temp = JOptionPane.showInputDialog("Podaj wysokosc cieczy w zbiorniku [m]");
            } while (!IsStringNumber.verify(temp));
            H = Double.parseDouble(temp);
            if (H > (2 * R)) {
                JOptionPane.showMessageDialog(null, "Poziom nie moze przekraczac srednicy zbiornika.");
            }
        } while (H > (2 * R));


        // obliczenia pojemnosci plynu w cysternie
        double V;
        double a;
        double b;
        double c;
        if (H <= R) {
            a = 1;
            b = H;
            c = 0;
        } else {
            a = -1;
            b = 2 * R - H;
            c = Math.PI * R * R * L;
        }
        V = a * L * (R * R * Math.acos((R - b) / R) - (R - b) * Math.sqrt(b * (2 * R - b))) + c;
        JOptionPane.showMessageDialog(null, "Dla L=" + L + " R=" + R + " H=" + H + "\nObjetosc plynu w zbiorniku to " + V + " m3");
    }
}