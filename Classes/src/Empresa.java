package com.classes;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Empresa {

    Scanner input = new Scanner(System.in);

    //DADOS DA EMPRESA
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String cnpj;

    //SETORES
    public enum setores {
        REQUISITOS,
        MODELAGEM,
        CODIFICACAO,
        TESTE,
        RECURSOS_HUMANOS;

        public static setores setSetor(int choice) {
            switch (choice) {
                case 1:
                    return REQUISITOS;
                case 2:
                    return MODELAGEM;
                case 3:
                    return CODIFICACAO;
                case 4:
                    return TESTE;
                case 5:
                    return RECURSOS_HUMANOS;
                default:
                    return null;
            }
        }
    }

    public enum cargos {
        COLABORADOR,
        CHEFE;

        public static cargos setCargo(int choice) {
            if (choice == 1) {
                return cargos.COLABORADOR;
            } else {
                return cargos.CHEFE;
            }
        }
    }

    //public static ArrayList<Funcionario> employee = new ArrayList<Funcionario>();
    //LISTA DE FUNCIONARIOS DE CADA SETOR
    public static ArrayList<Funcionario> requisitos = new ArrayList<Funcionario>();
    public static ArrayList<Funcionario> modelagem = new ArrayList<Funcionario>();
    public static ArrayList<Funcionario> codificacao = new ArrayList<Funcionario>();
    public static ArrayList<Funcionario> teste = new ArrayList<Funcionario>();
    public static ArrayList<Funcionario> rh = new ArrayList<Funcionario>();

    //LISTA DE CONTRATOS
    public static ArrayList<Contrato> contratos = new ArrayList<>();

    public void admitir() {

        Funcionario employee = new Funcionario();

        System.out.println("\nAdmitir funcionario (test)\n");

        System.out.print("Insira o nome: ");
        employee.setNome(input.next());

        System.out.print("Insira o sobrenome: ");
        employee.setSobrenome(input.next());

        System.out.println("Digite o endereço: ");
        employee.setEndereco();

        System.out.print("Insira a idade: ");
        employee.setIdade(input.nextInt());

        System.out.print("Insira o sexo: ");
        employee.setSexo(input.next().charAt(0));


        System.out.print("Insira o cpf: ");
        employee.setCpf(input.next());


        System.out.print("Insira o email: ");
        employee.setEmail(input.next());

        System.out.print("Insira o telefone: ");
        employee.setTelefone(input.next());

        System.out.println("DADOS CONTRATUAIS");

        System.out.print("Insira o salario:");
        int salary = input.nextInt();

        System.out.println("Insira o setor:\n1- REQUISITOS \n2- MODELAGEM \n3- CODIFICACAO \n4- TESTES \n5- RECURSOS HUMANOS");
        int i = input.nextInt();
        System.out.println("Insira o cargo:\n1- Colaborador\n2- Chefe");
        int j = input.nextInt();

        setores sector = setores.setSetor(i);
        cargos role = cargos.setCargo(j);
        boolean pass = true;

        //VERIFICA SE HÁ UM CHEFE NO SETOR

        int aux = -1;

        System.out.println("valor de i: " + i);
        switch (i) {
            case 1 -> {
                if (!requisitos.isEmpty()) {
                    for (Funcionario var1 : requisitos) {
                        Contrato con = contratos.get(var1.getContratoIndex());
                        if (con.getCargo().equals(cargos.CHEFE)) {
                            aux = contratos.lastIndexOf(con);
                            pass = false;
                        }
                    }
                } else {
                    employee.setContratoIndex(0);
                    requisitos.add(employee);
                }
            }
            case 2 -> {
                if (!modelagem.isEmpty()) {
                    System.out.println("model not empty");
                    for (Funcionario funcionario : modelagem) {
                        System.out.println("test for loop");
                        System.out.println("nome123: " + funcionario.getNome());
                        Contrato con = contratos.get(funcionario.getContratoIndex());
                        System.out.println("test conrtrato");
                        if (con.getCargo().equals(cargos.CHEFE)) {
                            aux = contratos.lastIndexOf(con);
                            pass = false;
                        }
                    }
                } else {
                    System.out.println("model empty");
                    employee.setContratoIndex(0);
                    modelagem.add(employee);
                }
            }
            case 3 -> {
                if (!codificacao.isEmpty()) {
                    for (Funcionario var1 : codificacao) {
                        Contrato con = contratos.get(var1.getContratoIndex());
                        if (con.getCargo().equals(cargos.CHEFE)) {
                            aux = contratos.lastIndexOf(con);
                            pass = false;
                        }
                    }
                } else {
                    employee.setContratoIndex(0);
                    codificacao.add(employee);
                }
            }
            case 4 -> {
                if (!teste.isEmpty()) {
                    for (Funcionario var1 : teste) {
                        Contrato con = contratos.get(var1.getContratoIndex());
                        if (con.getCargo().equals(cargos.CHEFE)) {
                            aux = contratos.lastIndexOf(con);
                            pass = false;
                        }
                    }
                } else {
                    employee.setContratoIndex(0);
                    teste.add(employee);
                }
            }
            case 5 -> {
                if (!rh.isEmpty()) {
                    for (Funcionario var1 : rh) {
                        Contrato con = contratos.get(var1.getContratoIndex());
                        if (con.getCargo().equals(cargos.CHEFE)) {
                            aux = contratos.lastIndexOf(con);
                            pass = false;
                        }
                    }
                } else {
                    employee.setContratoIndex(0);
                    rh.add(employee);
                }
            }
        }

        System.out.println(aux);
        if (role.equals(cargos.CHEFE)) {
            if (!pass) {
                System.out.println("ja ha um chefe neste setor");
                System.out.println("deseja adicionar como colaborador?\n1- Sim\n2- Nao");
                int choice = input.nextInt();

                if (choice == 1) {
                    role = cargos.COLABORADOR;
                } else {
                    contratos.get(aux).setCargo(cargos.COLABORADOR);
                }
            }
        }

        Contrato contrato = new Contrato(employee, salary, sector, role);
        contratos.add(contrato);

        System.out.println("\nFuncionário admitido com sucesso!\n");
    }


    public void consultar (String busca) {
        for (Contrato i :
                contratos) {
            if (i.getFuncionario().getNome().equals(busca) | i.getFuncionario().getCpf().equals(busca)){
                System.out.println("Nome: " + i.getFuncionario().getNome() + " "+i.getFuncionario().getSobrenome());
                System.out.println("Endereço");
                System.out.println("Bairro: "+i.getFuncionario().address.get("Bairro"));
                System.out.println("Cidade: "+i.getFuncionario().address.get("Cidade"));
                System.out.println("Estado: "+i.getFuncionario().address.get("Estado"));
                System.out.println("Idade: " + i.getFuncionario().getIdade());
                System.out.println("Sexo: " + i.getFuncionario().getSexo());
                System.out.println("CPF: " + i.getFuncionario().getCpf());
                System.out.println("Email: " + i.getFuncionario().getEmail());
                System.out.println("Telefone: " + i.getFuncionario().getTelefone());
                System.out.println("ID: "+i.id);
                System.out.println("Setor: "+i.setor);

                break;
            }
            if (contratos.lastIndexOf(i) == contratos.size() - 1) {
                System.out.println("Funcionário não está cadastrado no sistema.");
            }
        }
    }

    public void atualizar(Funcionario worker) {
        Scanner input = new Scanner(System.in);
        System.out.println("Atualizar oq seu fdp ?????????");
        System.out.println("1- Nome(X) \n 2- Sobrenome(X) \n 3- Endereco \n 4- Idade \n 5- Sexo(X) \n 6- CPF(X) \n 7- Email \n 8- Telefone");
        int choice = input.nextInt();

        //OPÇÕES COM  (X)  TALVEZ SERÃO REMOVIDAS
        //SEUS  case  ESTÃO COMENTADOS

        switch (choice) {
            /*case 1 -> {
                System.out.print("Novo nome: ");
                String nome = input.nextLine();
                worker.setNome(nome);
                System.out.println("Nome atualizado com sucesso.");
            }
            case 2 -> {
                System.out.print("Novo sobrenome: ");
                String sobrenome = input.nextLine();
                worker.setSobrenome(sobrenome);
                System.out.println("Sobrenome atualizado com sucesso.");
            }*/
            case 3 -> {
                System.out.print("Novo endereço:");
                worker.setEndereco();
                System.out.println("Endereço atualizado com sucesso.");
            }
            case 4 -> {
                System.out.print("Nova idade:");
                int idade = input.nextInt();
                worker.setIdade(idade);
                System.out.println("Idade atualizada com sucesso.");
            }
            /*case 5 -> {
                System.out.print("Novo sexo(???):");
                char sexo = input.next().charAt(0);
                worker.setSexo(sexo);
                System.out.println("Sexo atualizado com sucesso.");
            }*/
            /*case 6 -> {
                System.out.print("Novo cpf:");
                String cpf = input.nextLine();
                worker.setNome(cpf);
                System.out.println("CPF atualizado com sucesso.");
            }*/
            case 7 -> {
                System.out.print("Novo email:");
                String email = input.nextLine();
                worker.setNome(email);
                System.out.println("Email atualizado com sucesso.");
            }
            case 8 -> {
                System.out.print("Novo telefone:");
                String telefone = input.nextLine();
                worker.setNome(telefone);
                System.out.println("Telefone atualizado com sucesso.");
            }
        }

    }

   /* public void demitir(String ppr) {
        employee.removeIf(funcionario -> funcionario.getCpf().equals(ppr));
        System.out.println("vagabundo demitido");
    }*/

    public void visualizar_todos() {
        for (Contrato funcionario : contratos){
            System.out.println("Nome: "+funcionario.getFuncionario().getNome());
            System.out.println("Setor: "+funcionario.getSetor());
            System.out.println("Cargo: "+funcionario.getCargo());
            System.out.println();
        }
    }
}

