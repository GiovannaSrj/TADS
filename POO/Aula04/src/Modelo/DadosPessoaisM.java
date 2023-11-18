package Modelo;
public class DadosPessoaisM {


    /*
     * @param rg: número da carteira de identidade (tipo INT)
     * @param nome: primeiro nome (String)
     * @param sexo: Masculino e Feminino (char)
     * @param dataNasc: data de nascimento (tipo String)
     */
    private int rg;
    private String nome;
    private char sexo;
    private String dataNasc;

    
    public DadosPessoaisM(int rg, String nome, char sexo, String dataNasc) {
        this.rg = rg;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
    }
    public int getRg() {
        return rg;
    }
    public void setRg(int rg) {
        this.rg = rg;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    
}
