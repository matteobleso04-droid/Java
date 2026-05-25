import java.util.Scanner;

public class Stringhe {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    String parola = "parola";
    char bersaglio = 'a';
    int contatore = 0;
    for(int i=0;i<parola.length();i++){
        if(parola.charAt(i) == bersaglio){
            contatore++;
        }
    }
    System.out.println("il carattere " + bersaglio + " compare " + contatore + " volte");

    }
}
