/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author mathe
 */
public class Aluno {

    private int idAluno;
    private String nome;
    private String telefonePrincipal;
    private String telefoneSecundario;
    private String endereco;
    private String bairro;
    private String cep;
    private String cpf;
    private Date dataCadastro;
    private boolean inadimplente;
    private List<Modalidade> modalidades;
    private Pacote pacote;
    private List<Frequencia> frequencias;
    private String formaDePagamento;
    private boolean pagamentoComCartao;
    private String dataUltimoPagamento;
    private float valorTotalInscricao;
    
    public Aluno(int idAluno, String nome, String telefonePrincipal, String telefoneSecundario, String endereco, String bairro, String cep, String cpf, Date dataCadastro, boolean inadimplente, List<Modalidade> modalidades, Pacote pacote, List<Frequencia> frequencias, boolean pagamentoComCartao) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.telefonePrincipal = telefonePrincipal;
        this.telefoneSecundario = telefoneSecundario;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.inadimplente = inadimplente;
        this.modalidades = modalidades;
        this.pacote = pacote;
        this.frequencias = frequencias;
        this.pagamentoComCartao = pagamentoComCartao;
    }

    public Aluno(int idAluno, String nome, String telefonePrincipal, 
            String telefoneSecundario, String endereco, String bairro, 
            String cep, String cpf, Date dataCadastro, boolean inadimplente, boolean pagamentoComCartao, String dataUltimoPagamento, float valorTotalInscricao) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.telefonePrincipal = telefonePrincipal;
        this.telefoneSecundario = telefoneSecundario;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.inadimplente = inadimplente;
        this.pagamentoComCartao = pagamentoComCartao;
        this.dataUltimoPagamento = dataUltimoPagamento;
        this.valorTotalInscricao = valorTotalInscricao;
    }

    public float getValorTotalInscricao() {
        return valorTotalInscricao;
    }

    public void setValorTotalInscricao(float valorTotalInscricao) {
        this.valorTotalInscricao = valorTotalInscricao;
    }

    public String getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    public void setDataUltimoPagamento(String dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }
    
    public boolean isPagamentoComCartao() {
        return pagamentoComCartao;
    }

    public void setPagamentoComCartao(boolean pagamentoComCartao) {
        this.pagamentoComCartao = pagamentoComCartao;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }

    public Aluno() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(String telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isInadimplente() {
        return inadimplente;
    }

    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }
}
