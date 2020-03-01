/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author mathe
 */
public class Pacote {

    private int idPacote;
    private String nomePacote;
    private float valorDesconto;
    private int duracao;
    private List<Modalidade> listaDeModalidades;

    public Pacote(int idPacote, String nomePacote, float valorDesconto, int duracao, List<Modalidade> listaDeModalidades) {
        this.idPacote = idPacote;
        this.nomePacote = nomePacote;
        this.valorDesconto = valorDesconto;
        this.duracao = duracao;
        this.listaDeModalidades = listaDeModalidades;
    }

    public Pacote() {
    }

    public Pacote(int idPacote, String nomePacote, float valorDesconto, int duracao) {
        this.idPacote = idPacote;
        this.nomePacote = nomePacote;
        this.valorDesconto = valorDesconto;
        this.duracao = duracao;
    }

    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public String getNomePacote() {
        return nomePacote;
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Modalidade> getListaDeModalidades() {
        return listaDeModalidades;
    }

    public void setListaDeModalidades(List<Modalidade> listaDeModalidades) {
        this.listaDeModalidades = listaDeModalidades;
    }

}
