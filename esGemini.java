import java.util.ArrayList;
    abstract class Veicolo {
        private String targa;
        public String getTarga() {
            return targa;
        }
        public void setTarga(String targa) {
            if(!targa.isEmpty()){
                this.targa = targa;
            }
            else{
                System.out.println("La targa non può essere vuota! ");
            }
        }
        private int numeroporte;
        public int getNumeroporte() {
            return numeroporte;
        }
        public void setNumeroporte(int numeroporte) {
            if (numeroporte >= 2) {
                this.numeroporte = numeroporte;
            }
            else{
                System.out.println("Un veicolo deve avere almeno due porte! ");
            }
        }
        public Veicolo(String targa, int numeroporte){
            setNumeroporte(numeroporte);
            setTarga(targa);
        }
        public abstract double calcolaBollo();
    }
    class Auto extends Veicolo {
        private int cilindrata;

        public int getCilindrata() {
            return cilindrata;
        }
        public void setCilindrata(int cilindrata){
            if(cilindrata > 0){
                this.cilindrata = cilindrata;
            }
            else{
                System.out.println("Errore");
            }
        }
        public Auto(String targa, int numeroporte, int cilindrata){
            super(targa, numeroporte);
            setCilindrata(cilindrata);
        }
        public double calcolaBollo(){
            return cilindrata * 0.50;
        }
        public void fermato(){
            System.out.println("Il veicolo è stato fermato dalla polizia! ");
        }
    }
    class Camion extends Veicolo{
        private int caricoCamion;

        public int getCaricoCamion() {
            return caricoCamion;
        }

        public void setCaricoCamion(int caricoCamion) {
            if (caricoCamion > 500) {
                this.caricoCamion = caricoCamion;
            }
            else{
                System.out.println("Il carico è troppo leggero, non può essere un camion");
            }
        }
        public Camion(String marca, int numeroporte, int caricoCamion){
            super(marca, numeroporte);
            setCaricoCamion(caricoCamion);
        }
        public double calcolaBollo(){
            return caricoCamion * 0.10;
        }

    }

public class esGemini{
    public static void main(String[] args) {
        Auto a1 = new Auto("FIAT", 4, 500);
        Camion c1 = new Camion("IVECO", 2, 3000);
        ArrayList <Veicolo> garage = new ArrayList<>();

        garage.add(a1);
        garage.add(c1);
    }
}