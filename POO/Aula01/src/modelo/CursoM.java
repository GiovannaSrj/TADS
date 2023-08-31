package modelo;

public class CursoM {
    private String nome;
    private char turno;
    private int grade;
    private int cargH;
    private int hComple;

    public CursoM(String nome, char turno, int grade, int cargH, int hComple) {
        this.nome = nome;
        this.turno = turno;
        this.grade = grade;
        this.cargH = cargH;
        this.hComple = hComple;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getTurno() {
        return turno;
    }
    public void setTurno(char turno) {
        this.turno = turno;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getCargH() {
        return cargH;
    }
    public void setCargH(int cargH) {
        this.cargH = cargH;
    }
    public int gethComple() {
        return hComple;
    }
    public void sethComple(int hComple) {
        this.hComple = hComple;
    }
    public void impCurso() {
        
        System.out.println("DADOS DO CURSO:");
        System.out.println("NOME:" + this.getNome());
        System.out.println("TURNO:" + this.getTurno());
        System.out.println("GRADE: "+ this.getGrade());
        System.out.println("HORAS COMPLEMENTARES: "+ this.gethComple());
        System.out.println("CARGA HORÁRIA: "+ this.getCargH());
       
    }
}
