package models;

public class Pagamento {

    String nome;
    String numero;
    String dtVencimento;
    String cvv;

    public Pagamento(String nome, String numero, String dtVencimento, String cvv) {
        this.nome = nome;
        this.numero = numero;
        this.dtVencimento = dtVencimento;
        this.cvv = cvv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Pagamento" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", dtVencimento='" + dtVencimento + '\'' +
                ", cvv='" + cvv;
    }
}
