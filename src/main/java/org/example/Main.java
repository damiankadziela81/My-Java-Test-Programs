package org.example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Tank tank1 = new Tank(0,0,0,0);
        Tank tank2 = new Tank(0,0,0,0);
        Tank tank3 = new Tank(0,0,0,0);
        Tank[] tankArray = {tank1,tank2,tank3};



        JOptionPane.showMessageDialog(null, "Obliczmy poziom cieczy w 3 zbiornikach (cysternach).");

        DataInput.readData(tankArray);

        // obliczenia pojemnosci plynu w cysternach
        double arrayVolume=0;
        for (int i = 0; i < tankArray.length; i++) {
            tankArray[i].calculateVolume();
            arrayVolume=arrayVolume+tankArray[i].fluidVolume;
            JOptionPane.showMessageDialog(null, "Dla L=" + tankArray[i].lenght + " R=" +
                    tankArray[i].radius + " H=" + tankArray[i].fluidLevel + "\nObjetosc plynu w zbiorniku nr "+(i+1)+" to "
                    + tankArray[i].fluidVolume + " m3");
        }
//
//        for (Tank x : tankArray) {
//            x.calculateVolume();
//
//
//        }

        JOptionPane.showMessageDialog(null, "Objetosc plynu w zbiornikach to " + arrayVolume + " m3");
    }

}