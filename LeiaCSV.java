
package loteria;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class LeiaCVS implements Callable<int[]>{
    
    private int in;
    private int fim;
    
    public LeiaCVS(int i, int f){
        in=i;
        fim=f;
    }
    
    public int[] call(){
        return run(in,fim);
    }


  public int[] run(int startLine, int endLine) {

    String arquivoCSV = "C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\Códigos\\resultados - resultados.csv";
    BufferedReader br = null;
    String linha = "";  //inicia como string vazia
    String csvDivisor = ",";
    
    int count[]=new int [16]; //indice 1 e 0 não são utilizados, pois não são counts relevantes
    
    try {

       
        br = new BufferedReader(new FileReader(arquivoCSV)); //novo leitor
        
        br.readLine(); //elimina linha de cabeçalho
        
        for(int linhatual = 1;(linha = br.readLine()) != null && linhatual <= endLine; linhatual++){ //le desde a primeira linha e para quando atinge a linha limite
        
        if(linhatual >= startLine) { //só processa quando for a partir da linha de inicio

        String[] pais = linha.split(csvDivisor); //dividindo linha em array de strings, cada string contendo o valor de uma coluna
        
        
        int[] valoresInt = new int[pais.length-2]; //vetor de inteiro com base no vetor pais, porem com 2 espaços a menos, pelas 2 colunas a esquerda

        for (int i = 2; i < pais.length; i++) {
        valoresInt[i-2] = Integer.parseInt(pais[i]); //convertendo valores string em int para poder realizar operações com eles
}
        
        for(int seq = 2; seq <= 15; seq++){ //abrange sequencias de 2 a 15 numeros
            for(int i = 0; i <= valoresInt.length - seq; i++){ //percorre numeros em uma linha, e não acessa posições fora do limite do array
                boolean ehSeq = true;   //sequencia encontrada?
                for(int s=1; s < seq; s++){ //compara elementos adjacentes de uma sequencia
                    if(valoresInt[i + s] != valoresInt [i + s - 1] +1){  //se proximo valor da sequencia nao for compativel (anterior + 1) 
                        ehSeq = false;
                        break;
                    }
                }
                if (ehSeq){
                    count[seq]++; //foi encontrada sequencia de tamanho seq
                }
            }
        } 
        }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();         //memso se der problema o leitor sera fechado
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    for(int seq = 2; seq <= 15 ; seq++){
                System.out.println(count[seq] + " sequências " + seq + " numeros");

            }
    return count;
  }

}
