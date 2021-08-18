package com.classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Empresa teste = new Empresa();

        teste.admitir();
        System.out.println();
        System.out.println();
        //System.out.println("Insira o nome do funcionário: ");
        //String nome = input.nextLine();
        //teste.consultar(nome);
        teste.admitir();

        teste.visualizar_todos();

    }
}
