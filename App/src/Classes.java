import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Classes {
    void ArqTxt() {
        try {
            BufferedWriter Escrever = new BufferedWriter(new FileWriter("Lancados.txt"));
            for (String elemento : lista) {
                Escrever.write(elemento);
                Escrever.newLine();
            }
            Escrever.close();
            System.out.println("ArrayList gravado com sucesso no arquivo.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }
    
}
