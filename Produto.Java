package Estoque.produto;

import java.util.Scanner;

public class produto {
	
    // Atributos (estado)
    private String nome;
    private int codigo;
    private int qtd;

    // Construtor
    public produto(String nome, int codigo, int qtd) {
        this.nome = nome;
        this.codigo = codigo;
        this.qtd = qtd;
    }

    // Métodos (comportamento)
    public void apresentar() {
        System.out.println("Esse produto tem o nome: " + nome + ", código: " + codigo + " e " + qtd + "items");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
