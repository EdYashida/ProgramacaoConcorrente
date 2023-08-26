
package loteria;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeiaCVS {


  public void run() {

    String arquivoCSV = "C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\Códigos\\resultados - resultados.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ",";
    
    /*
    int count2 =0;
    int count3 =0;
    int count4 =0;
    int count5 =0;
    int count6 =0;
    int count7 =0;
    int count8 =0;
    int count9 =0;
    int count10 =0;
    int count11 =0;
    int count12 =0;
    int count13 =0;    
    int count14 =0;
    int count15 =0;
*/

    int count[]=new int [16]; //indice 1 e 0 não são utilizados
    
    try {

       
        br = new BufferedReader(new FileReader(arquivoCSV));
        br.readLine();
        while ((linha = br.readLine()) != null) {

        String[] pais = linha.split(csvDivisor);
        
        
        int[] valoresInt = new int[pais.length-2];

        for (int i = 2; i < pais.length; i++) {
        valoresInt[i-2] = Integer.parseInt(pais[i]);
}
        
        for(int seq = 2; seq <= 15; seq++){
            for(int i = 0; i <= valoresInt.length - seq; i++){
                boolean ehSeq = true;
                for(int s=1; s < seq; s++){
                    if(valoresInt[i + s] != valoresInt [i + s - 1] +1){
                        ehSeq = false;
                        break;
                    }
                }
                if (ehSeq){
                    count[seq]++;
                }
            }
        }

            
            //System.out.println(" numeros: [ " + valoresInt[valoresInt.length-15] + 
                  //  " " +valoresInt[valoresInt.length-14] +
                   //" " + pais[pais.length-13] +
                    //" " +pais[pais.length-12] +
                   //" " + pais[pais.length-11] +
                    //" " +pais[pais.length-10] +
                    //" " +pais[pais.length-9] +
                   // " " +pais[pais.length-8] +
                   // " " +pais[pais.length-7] +
                   //" " + pais[pais.length-6] +
                    //" " +pais[pais.length-5] +
                   //" " + pais[pais.length-4] +
                   //" " + pais[pais.length-3] +
                  // " " + pais[pais.length-2] +
                  // " " + valoresInt[valoresInt.length-1] +"]");
            
            
            
            
            
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
   /* System.out.println(count2 + " sequencias de 2 numeros");
    System.out.println(count3 + " sequencias de 3 numeros");
    System.out.println(count4 + " sequencias de 4 numeros");
    System.out.println(count5 + " sequencias de 5 numeros");
    System.out.println(count6 + " sequencias de 6 numeros");
    System.out.println(count7 + " sequencias de 7 numeros");
    System.out.println(count8 + " sequencias de 8 numeros");
    System.out.println(count9 + " sequencias de 9 numeros");
    System.out.println(count10 + " sequencias de 10 numeros");
    System.out.println(count11 + " sequencias de 11 numeros");
    System.out.println(count12 + " sequencias de 12 numeros");
    System.out.println(count13 + " sequencias de 13 numeros");
    System.out.println(count14 + " sequencias de 14 numeros");
    System.out.println(count15 + " sequencias de 15 numeros");
*/
    for(int seq = 2; seq <= 15 ; seq++){
                System.out.println(count[seq] + " sequências " + seq + " numeros");

            }
  }

}
