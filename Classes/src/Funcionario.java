package com.classes;

public class Funcionario {

    private String nome;
    private String sobrenome;
    private String endereco;
    private int idade;
    private char sexo;
    private String cpf;
    private String email;
    private String telefone;

    public Funcionario(){

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

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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


}
