package com.classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Empresa gay = new Empresa();

        gay.admitir();
        System.out.println();
        System.out.println();
        System.out.println("Qual o nome do corno?????");
        String nome = input.next();
        gay.consultar(nome);
    }
}
