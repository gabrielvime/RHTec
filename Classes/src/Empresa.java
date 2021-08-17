package com.classes;

import java.util.ArrayList;
import java.util.Scanner;
import com.classes.Funcionario;

public class Empresa {

    Scanner input = new Scanner(System.in);

    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String cnpj;

    protected ArrayList<Funcionario> workers = new ArrayList<Funcionario>();


    public void admitir() {

        Funcionario funcionario = new Funcionario();
        System.out.println("Admitir funcionario (test)");

        System.out.print("Insira o nome: ");
        funcionario.setNome(input.next());

        System.out.print("Insira o sobrenome: ");
        funcionario.setSobrenome(input.next());

        System.out.print("Insira o endereço: ");
        funcionario.setEndereco(input.next());

        System.out.print("Insira a idade: ");
        funcionario.setIdade(input.nextInt());

        System.out.print("Insira o sexo: ");
        funcionario.setSexo(input.next().charAt(0));

        System.out.print("Insira o cpf: ");
        funcionario.setCpf(input.next());

        System.out.print("Insira o email: ");
        funcionario.setEmail(input.next());

        System.out.print("Insira o telefone: ");
        funcionario.setTelefone(input.next());

        workers.add(funcionario);
        System.out.println("Funcionário admitido com sucesso!");
    }

    public void consultar(String... args) {
        for (Funcionario i :
                workers) {
            if (workers.contains(i)) {
                System.out.println("Nome: " + i.getNome());
                System.out.println("Sobrenome: " + i.getSobrenome());
                System.out.println("Endereco: " + i.getEndereco());
                System.out.println("Idade: " + i.getIdade());
                System.out.println("Sexo: " + i.getSexo());
                System.out.println("CPF: " + i.getCpf());
                System.out.println("Email: " + i.getEmail());
                System.out.println("Telefone: " + i.getTelefone());

                break;
            }
            if (workers.lastIndexOf(i) == workers.size() - 1) {
                System.out.println("Funcionário não está cadastrado no sistema.");
            }
        }
    }

    public void atualizar(Funcionario worker) {
        System.out.println("Indique o que deseja atualizar: ");
        System.out.println("1- Nome \n 2- Sobrenome \n 3- Endereço \n 4- Idade \n 5- Sexo \n 6- CPF \n 7- Email \n 8- Telefone");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Novo nome: ");
                String nome = input.next();
                worker.setNome(nome);
                System.out.println("Nome atualizado com sucesso.");
            }
            case 2 -> {
                System.out.print("Novo sobrenome: ");
                String sobrenome = input.next();
                worker.setSobrenome(sobrenome);
                System.out.println("Sobrenome atualizado com sucesso.");
            }
            case 3 -> {
                System.out.print("Novo endereço: ");
                String endereco = input.next();
                worker.setEndereco(endereco);
                System.out.println("Endereço atualizado com sucesso.");
            }
            case 4 -> {
                System.out.print("Nova idade: ");
                int idade = input.nextInt();
                worker.setIdade(idade);
                System.out.println("Idade atualizada com sucesso.");
            }
            case 5 -> {
                System.out.print("Novo sexo: ");
                char sexo = input.next().charAt(0);
                worker.setSexo(sexo);
                System.out.println("Sexo atualizado com sucesso.");
            }
            case 6 -> {
                System.out.print("Novo cpf: ");
                String cpf = input.next();
                worker.setNome(cpf);
                System.out.println("CPF atualizado com sucesso.");
            }
            case 7 -> {
                System.out.print("Novo email: ");
                String email = input.next();
                worker.setNome(email);
                System.out.println("Email atualizado com sucesso.");
            }
            case 8 -> {
                System.out.print("Novo telefone:");
                String telefone = input.next();
                worker.setNome(telefone);
                System.out.println("Telefone atualizado com sucesso.");
            }
        }

    }

    public void demitir(String ppr){
        workers.removeIf(funcionario -> funcionario.getCpf().equals(ppr));
        System.out.println("Funcionário demitido.");
    }

    public ArrayList visualizar_todos(){
        return workers;
    }
}

