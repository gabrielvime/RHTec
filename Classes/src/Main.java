package com.classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Empresa teste = new Empresa();

        teste.admitir();
        System.out.println("Insira o nome do funcionário: ");
        String nome = input.next();
        teste.consultar(nome);
    }
}
