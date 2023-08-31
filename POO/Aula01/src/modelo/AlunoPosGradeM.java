package modelo;

public class AlunoPosGradeM extends AlunoM {
    private String orientador;
    private char bolsaGov;
    private int AnoEntrada;
    private int prazo;
    private char tipo;

    public AlunoPosGradeM(int ra, int idade, String nome, String cpf, char f, int codCurso, CursoM curso,
            String orientador, char bolsaGov, int anoEntrada, int prazo, char tipo) {
        super(ra, idade, nome, cpf, f, codCurso, curso);//atributos da classe mãe, roda tbm construtor classe mãe
        this.orientador = orientador;
        this.bolsaGov = bolsaGov;
        this.AnoEntrada = anoEntrada;
        this.prazo = prazo;
        this.tipo = tipo;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public char getBolsaGov() {
        return bolsaGov;
    }

    public void setBolsaGov(char bolsaGov) {
        this.bolsaGov = bolsaGov;
    }

    public int getAnoEntrada() {
        return AnoEntrada;
    }

    public void setAnoEntrada(int anoEntrada) {
        AnoEntrada = anoEntrada;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void ImprimiPosGradeM (){
        System.out.println("DADOS DO ALUNO:");
        System.out.println("RA:" + this.getRa());
        System.out.println("CPF:" + this.getCpf());
        System.out.println("NOME:" + this.getNome());
        System.out.println("IDADE:" + this.getIdade());
        System.out.println("SEXO:" + this.getSexo());
        System.out.println("CURSO:" + this.getCodCurso());
        System.out.println("DADOS DA PÓS:");
        System.out.println("ORIENTADOR:" + this.getOrientador());
        System.out.println("BOLSA DO GOVERNO:" + this.getBolsaGov());
        System.out.println("ANO ENTRADA: "+ this.getAnoEntrada());
        System.out.println("PRAZO: "+ this.getPrazo());
        System.out.println("TIPO: "+ this.getTipo());
    }
    
    
    
}
