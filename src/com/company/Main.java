package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double sajatHP = 100;
        double szornyHP = 100;
        double dobas;
        double sebzes=0;
        byte valasz=0;

        //do while ciklus a végéig addig megy amíg valamelyik HP nem éri el a 0 értéket
        do {
            //do while ciklus amíg a felhasználó a válasz nem 1(1=nem) és  a dobás értéke nem 1
            do {
                //random dobás 1 és 6  között
                dobas = Math.floor(Math.random() * 6) + 1;
                //Dobás eredményének kiiírása
                System.out.println("A dobásod eredménye: " + dobas);
                //vizsgálat ha 1 akkor a támadás sikertelen sebzés beállítása 0-ra
                if (dobas == 1) {
                    System.out.println(" A támadás sikertelen!");
                    sebzes = 0;
                } else {
                    //sebzes hozzáadása a dobáshoz ,újradobás?,válasz bevitel
                    sebzes += dobas;
                    System.out.println();
                    System.out.println("Akarsz még dobni?(igen=0,nem=1");
                    // válasz igen=0 nem=1
                    valasz = sc.nextByte();
                }

            } while (valasz != 1 && dobas != 1);
            //a támadása adatai ,sebzés mértéke, sebzés levonása a Hp-ból,sebzes 0 ára állítása
            System.out.println("A szörnye mért sebzes: " + sebzes);

            System.out.println("A szörnyek: " + (szornyHP - sebzes) + "HP-ja maradt!");
            szornyHP -= sebzes;
            sebzes = 0;

            //szörny dobása 3x, eltárolás a sebzésbe
            for (int i = 0; i < 3; i++) {
                dobas = Math.floor(Math.random() * 6) + 1;
                sebzes += dobas;
            }
            //Szörny támadásának adatai,sebzés mértéke, sebzés levonása a Hp-ból, sebzés 0-ra állítása
             System.out.println("A szörny sebzése: "+sebzes);
            System.out.println("Nekem " + (sajatHP - sebzes) + "HP-m maradt!");
            sajatHP -= sebzes;
            sebzes = 0;
        }while(sajatHP >= 0 && szornyHP >= 0);
    //vizsgálat ha az én HP-m lett előbb 0 akkor Kiir (meghaltál) , ha a szörnyé akkor Kiir(Megölted  szörnyet)
        if (sajatHP<=0){
            System.out.println("Meghaltál!");
        }else if (szornyHP<=0){
            System.out.println("Megölted a szörnyet");
        }
    }
}
