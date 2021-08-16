package com.classes;
import com.classes.Empresa.*;

public class Contrato{
    private enum cargos{
        COLABORADOR,
        CHEFE
    }
    private Funcionario funcionario;
    protected int id;
    private int salario;
    protected cargos cargo;
    protected setores setor;

    public Contrato(){

    }

    public Contrato(Funcionario employee, int salary, setores sector){
        this.funcionario = employee;
        this.id = 100000 + (int)(Math.random() * (899999 + 1)) ;
        this.salario = salary;
        this.setor = sector;
    }

    public void setCargo(cargos cargo) {
        this.cargo = cargo;
    }
}
