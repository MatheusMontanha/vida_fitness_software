/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author mathe
 */
public class Modalidade {

    private int idModalidade;
    private String nome;
    private float valorModalidade;

    public Modalidade(int idModalidade, String nome, float valorModalidade) {
        this.idModalidade = idModalidade;
        this.nome = nome;
        this.valorModalidade = valorModalidade;
    }

    public Modalidade() {
    }

    public int getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(int idModalidade) {
        this.idModalidade = idModalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorModalidade() {
        return valorModalidade;
    }

    public void setValorModalidade(float valorModalidade) {
        this.valorModalidade = valorModalidade;
    }

}
