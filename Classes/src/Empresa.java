package com.classes;
import java.util.ArrayList;
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

        System.out.println("\nAdmitir funcionario\n");

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
                    for (Funcionario funcionario : modelagem) {
                        Contrato con = contratos.get(funcionario.getContratoIndex());
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

    public void atualizar(String update) {
        for (Contrato i :
                contratos) {
            if (i.getFuncionario().getNome().equals(update) | i.getFuncionario().getCpf().equals(update)) {
                Funcionario employee = i.getFuncionario();

                System.out.println("""
                        0 - Sair
                                                
                        DADOS PESSOAIS\s
                        1- Nome\s
                        2- Sobrenome\s
                        3- Endereco\s
                        4- Idade\s
                        5- Sexo(\s
                        6- CPF\s
                        7- Email\s
                        8- Telefone\s
                                             
                        DADOS CONTRATUAIS\s
                        9- Salario\s
                        10- Setor\s
                        11- Cargo""");

                switch (input.nextInt()) {
                    case 1 -> {
                        System.out.print("Novo nome: ");
                        employee.setNome(input.next());
                        System.out.println("Nome atualizado com sucesso.");
                    }
                    case 2 -> {
                        System.out.print("Novo sobrenome: ");
                        employee.setSobrenome(input.next());
                        System.out.println("Sobrenome atualizado com sucesso.");
                    }
                    case 3 -> {
                        System.out.print("Novo endereço: ");
                        employee.setEndereco();
                        System.out.println("Endereço atualizado com sucesso.");
                    }
                    case 4 -> {
                        System.out.print("Nova idade: ");
                        employee.setIdade(input.nextInt());
                        System.out.println("Idade atualizada com sucesso.");
                    }
                    case 5 -> {
                        System.out.print("Novo sexo: ");
                        employee.setSexo(input.next().charAt(0));
                        System.out.println("Sexo atualizado com sucesso.");
                    }
                    case 6 -> {
                        System.out.print("Novo cpf: ");
                        employee.setNome(input.next());
                        System.out.println("CPF atualizado com sucesso.");
                    }
                    case 7 -> {
                        System.out.print("Novo email: ");
                        employee.setNome(input.next());
                        System.out.println("Email atualizado com sucesso.");
                    }
                    case 8 -> {
                        System.out.print("Novo telefone: ");
                        employee.setNome(input.next());
                        System.out.println("Telefone atualizado com sucesso.");
                    }
                    case 9 -> {
                        System.out.print("Novo salario: ");
                        i.setSalario(input.nextInt());
                        System.out.println("Salario atualizado com sucesso.");
                    }
                    case 10 -> {
                        System.out.print("Novo setor: ");
                        i.setSetor(setores.setSetor(input.nextInt()));
                        System.out.println("Setor atualizado com sucesso.");
                    }
                    case 11 -> {
                        System.out.print("Novo cargo: ");
                        i.setCargo(cargos.setCargo(input.nextInt()));
                    }
                }
            } else {
                System.out.println("Funcionario nao cadastrado");
            }
        }
    }

    public void demitir(String ppr) {
        for (Contrato demissao:
             contratos) {
            if (demissao.getFuncionario().getCpf().equals(ppr)){
                switch (demissao.getSetor()){
                    case REQUISITOS -> requisitos.remove(demissao.getFuncionario());
                    case MODELAGEM -> modelagem.remove(demissao.getFuncionario());
                    case CODIFICACAO -> codificacao.remove(demissao.getFuncionario());
                    case TESTE -> teste.remove(demissao.getFuncionario());
                    case RECURSOS_HUMANOS -> rh.remove(demissao.getFuncionario());
                }
                contratos.remove(demissao);
                System.out.println("Funcionario demitido");
                break;

            }if (contratos.lastIndexOf(demissao) == contratos.size() - 1) {
                System.out.println("Funcionário não está cadastrado no sistema.");
            }
        }
    }

    public void visualizar_todos() {
        if (!contratos.isEmpty()) {
            for (Contrato funcionario : contratos) {
                System.out.println("Nome: " + funcionario.getFuncionario().getNome());
                System.out.println("Setor: " + funcionario.getSetor());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println();
            }
        }else {
            System.out.println("Nao ha funcionarios cadastrados");
        }
    }

    public void visualizar (setores show){
        switch (show){
            case REQUISITOS -> {
                for (Funcionario funcionario:
                     requisitos) {
                    System.out.println("Nome: "+funcionario.getNome());
                    System.out.println("CPF: "+funcionario.getCpf());
                }
            }
            case MODELAGEM -> {
                for (Funcionario funcionario:
                        modelagem) {
                    System.out.println("Nome: "+funcionario.getNome());
                    System.out.println("CPF: "+funcionario.getCpf());
                }
            }
            case CODIFICACAO -> {
                for (Funcionario funcionario:
                        codificacao) {
                    System.out.println("Nome: "+funcionario.getNome());
                    System.out.println("CPF: "+funcionario.getCpf());
                }
            }
            case TESTE -> {
                for (Funcionario funcionario:
                        teste) {
                    System.out.println("Nome: "+funcionario.getNome());
                    System.out.println("CPF: "+funcionario.getCpf());
                }
            }
            case RECURSOS_HUMANOS -> {
                for (Funcionario funcionario:
                        rh) {
                    System.out.println("Nome: "+funcionario.getNome());
                    System.out.println("CPF: "+funcionario.getCpf());
                }
            }
        }
    }

    public void visualizar (char sex){
        for (Contrato contrato:
             contratos) {
            if (contrato.getFuncionario().getSexo() == sex){
                System.out.println("Nome: "+contrato.getFuncionario().getNome());
                System.out.println("CPF: "+contrato.getFuncionario().getCpf());
            }
        }
    }
    public void visualizar(String state){
        for (Contrato contrato:
                contratos) {
            if (contrato.getFuncionario().getEndereco().get("Estado").equals(state)){
                System.out.println("Nome: "+contrato.getFuncionario().getNome());
                System.out.println("CPF: "+contrato.getFuncionario().getCpf());
            }
        }
    }
    public void salario(){
        int menorIndex = 0;
        int maiorIndex = 0;
        int menor = 0;
        int maior = 0;
        for (Contrato contrato:
             contratos) {
            if (contrato.getSalario() < menor){
                menor = contrato.getSalario();
                menorIndex = contrato.getFuncionario().getContratoIndex();

            }
            if (contrato.getSalario() > maior){
                maior = contrato.getSalario();
                maiorIndex = contrato.getFuncionario().getContratoIndex();
            }
        }
        System.out.println("Menor salario");
        System.out.println("Salario: "+contratos.get(menorIndex));
        System.out.println("Setor: "+contratos.get(menorIndex).getSetor());
        System.out.println("Cargo: "+contratos.get(menorIndex).getCargo());
        System.out.println();
        System.out.println("Maior salario");
        System.out.println("Salario: "+contratos.get(maiorIndex));
        System.out.println("Setor: "+contratos.get(maiorIndex).getSetor());
        System.out.println("Cargo: "+contratos.get(maiorIndex).getCargo());
    }

    public void checksetor (){
        int[] size = new int[]{requisitos.size(), modelagem.size(), codificacao.size(), teste.size(),rh.size()};
        int menor = 0;
        int maior = 0;


        for (int count = 0; count < 5; count++){
            if (size[count] < size[menor]){
                menor = count;
            }
            if (size[count] > size[maior]){
                maior = count;
            }
        }
        System.out.println("Menor setor: "+setores.setSetor(menor + 1).toString()+" ("+size[menor]+")");
        System.out.println("Maior setor: "+setores.setSetor(maior + 1).toString()+" ("+size[maior]+")");
    }

    public void feminino(){
        int count = 0;
        for (Contrato i:
             contratos) {
            if (i.getFuncionario().getSexo() == 'F'){
                count += 1;
            }
        }

        System.out.println("Quantidade de funcionários do sexo Feminino: "+count);
    }
}

