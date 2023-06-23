
public class Carro {
    private static String modelo, fabricante;
    private static int anoFabricação, quilometrosRodados;
    private static double consumo, valor;
    
    public Carro(){
        
        
        
    }
    

    public static String getModelo() {
        return modelo;
    }

    public static void setModelo(String modelo) {
        Carro.modelo = modelo;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static void setFabricante(String fabricante) {
        Carro.fabricante = fabricante;
    }

    public static int getAnoFabricação() {
        return anoFabricação;
    }

    public static void setAnoFabricação(int anoFabricação) {
        Carro.anoFabricação = anoFabricação;
    }

    public static int getQuilometrosRodados() {
        return quilometrosRodados;
    }

    public static void setQuilometrosRodados(int quilometrosRodados) {
        Carro.quilometrosRodados = quilometrosRodados;
    }

    public static double getConsumo() {
        return consumo;
    }

    public static void setConsumo(double consumo) {
        Carro.consumo = consumo;
    }

    public static double getValor() {
        return valor;
    }

    public static void setValor(double valor) {
        Carro.valor = valor;
    }
}

