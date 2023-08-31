package modelo;
public class AlunoM {
    private int ra;
    private int idade;
    private String nome;
    private String cpf;
    private char sexo;
    private int codCurso;
    private String asdas;
    private CursoM curso;

    // CONSTRUTOR PADRÃO - Método que é disparado ao criar um objeto AlunoM
    public AlunoM() {
        ra = 0;
        idade = 0;
        nome = asdas;
        cpf = " ";
        sexo = '0';
        codCurso = 0;
        curso = null;

    }

    // CONSTRUTOR COM PARAMETRO
    public AlunoM(int ra, int idade, String nome, String cpf, char sexo, int codCurso, CursoM curso) {
        this.ra = ra;
        this.idade = idade;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.codCurso = codCurso;
        this.curso = curso;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public CursoM getCurso() {
        return curso;
    }

    public void setCurso(CursoM curso) {
        this.curso = curso;
    }

    public void impAtributos() {
        System.out.println("IMPORESSÃO DE ATRIBUTOS");
        System.out.println("");
        System.out.println("RA:" + this.getRa());
        System.out.println("CPF:" + this.getCpf());
        System.out.println("NOME:" + this.getNome());
        System.out.println("IDADE:" + this.getIdade());
        System.out.println("SEXO:" + this.getSexo());
        System.out.println("CURSO:" + this.getCodCurso());
        System.out.println("Dados do Curso");
        this.curso.impCurso();
    }


}
