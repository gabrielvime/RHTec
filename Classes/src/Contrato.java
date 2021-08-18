package com.classes;
import static com.classes.Empresa.*;

public class Contrato{
    private Funcionario funcionario;
    protected int id;
    private int salario;
    protected cargos cargo;
    protected setores setor;

    public Contrato(){

    }

    public Contrato(Funcionario employee, int salary, setores sector, cargos role){
        this.funcionario = employee;
        this.id = 100000 + (int)(Math.random() * (899999 + 1)) ;
        this.salario = salary;
        this.setor = sector;
        this.cargo = role;
    }

    public setores getSetor(){
        return this.setor;
    }

    public void setSetor(setores novo){
        this.setor = novo;
    }

    public cargos getCargo(){
        return this.cargo;
    }

    public void setCargo(cargos novo){
        this.cargo = novo;
    }

    public Funcionario getFuncionario(){
        return this.funcionario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalario(){
        return this.salario;
    }
}
