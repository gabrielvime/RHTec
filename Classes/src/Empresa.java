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

        System.out.print("Insira o sexokkkkkkkkk: ");
        funcionario.setSexo(input.next().charAt(0));

        System.out.print("Insira o cpf: ");
        funcionario.setCpf(input.next());

        System.out.print("Insira o email: ");
        funcionario.setEmail(input.next());

        System.out.print("Insira o telefone: ");
        funcionario.setTelefone(input.next());

        workers.add(funcionario);
        System.out.println("corno admitido com sucesso kkk");
    }

    public void consultar(String... args) {
        for (Funcionario i :
                workers) {
            if (workers.contains(i)) {
                System.out.println("Nome: " + i.getNome());
                System.out.println("Sobrenome: " + i.getSobrenome());
                System.out.println("Endereco: " + i.getEndereco());
                System.out.println("idade: " + i.getIdade());
                System.out.println("Sexokkkkkkk: " + i.getSexo());
                System.out.println("CPF: " + i.getCpf());
                System.out.println("Email: " + i.getEmail());
                System.out.println("Zap: " + i.getTelefone());

                break;
            }
            if (workers.lastIndexOf(i) == workers.size() - 1) {
                System.out.println("Funcionario fantasma fdp");
            }
        }
    }

    public void atualizar(Funcionario worker) {
        System.out.println("Atualizar oq seu fdp ?????????");
        System.out.println("1- Nome \n 2- Sobrenome \n 3- Endereco \n 4- Idade \n 5- Sexo?? \n 6- CPF \n 7- Email \n 8- Telefone");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Novo nome:");
                String nome = input.next();
                worker.setNome(nome);
                System.out.println("ae poha");
            }
            case 2 -> {
                System.out.print("Novo sobrenome:");
                String sobrenome = input.next();
                worker.setSobrenome(sobrenome);
                System.out.println("ae poha");
            }
            case 3 -> {
                System.out.print("Novo endereço:");
                String endereco = input.next();
                worker.setEndereco(endereco);
                System.out.println("ae poha");
            }
            case 4 -> {
                System.out.print("Nova idade:");
                int idade = input.nextInt();
                worker.setIdade(idade);
                System.out.println("ae poha");
            }
            case 5 -> {
                System.out.print("Novo sexo(???):");
                char sexo = input.next().charAt(0);
                worker.setSexo(sexo);
                System.out.println("ae poha");
            }
            case 6 -> {
                System.out.print("Novo cpf:");
                String cpf = input.next();
                worker.setNome(cpf);
                System.out.println("ae poha");
            }
            case 7 -> {
                System.out.print("Novo email:");
                String email = input.next();
                worker.setNome(email);
                System.out.println("ae poha");
            }
            case 8 -> {
                System.out.print("Novo telefone:");
                String telefone = input.next();
                worker.setNome(telefone);
                System.out.println("ae poha");
            }
        }

    }

    public void demitir(String ppr){
        workers.removeIf(funcionario -> funcionario.getCpf().equals(ppr));
        System.out.println("vagabundo demitido");
    }

    public ArrayList visualizar_todos(){
        return workers;
    }
}

