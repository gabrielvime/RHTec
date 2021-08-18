package com.classes;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Funcionario {

    Scanner input = new Scanner(System.in);

    protected String nome;
    protected String sobrenome;
    protected String endereco;
    protected int idade;
    protected char sexo;
    protected String cpf;
    protected String email;
    protected String telefone;
    protected Dictionary<String, String> address;
    private int contratoIndex;

    public Funcionario(){
        address = new Hashtable<String, String>();
    }

    public Funcionario(String name, String surname, String addres, int age, char sex, String ppr, String mail, String phone){
        nome = name;
        sobrenome = surname;
        endereco = addres;
        idade = age;
        sexo = sex;
        cpf = ppr;
        email = mail;
        telefone = phone;
        address = new Hashtable<String, String>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setEndereco() {
        String endereco;

        System.out.print("Insira o bairro: ");
        endereco = input.next();
        this.address.put("Bairro", endereco);

        System.out.print("Insira a cidade: ");
        endereco = input.next();
        this.address.put("Cidade", endereco);

        System.out.print("Insira o estado: ");
        endereco = input.next();
        this.address.put("Estado", endereco);

        //System.out.println("digite enter para continuar");
        input.nextLine();

    }

    public String getEndereco() {
        return endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setContrato(int i) {
        this.contratoIndex = i;
    }

    public void setContratoIndex(int index){
        this.contratoIndex = index;
    }
    public int getContratoIndex() {
        return contratoIndex;
    }
}
