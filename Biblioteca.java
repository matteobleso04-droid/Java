import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.time.temporal.ChronoUnit;;

public class Biblioteca {
public static class Supporto{
        private String titolo;
        public String getTitolo() {
            return titolo;
        }
        public void setTitolo(String titolo) {
            this.titolo = titolo;
        }
        private String entePubblicante;
        public String getEntePubblicante() {
            return entePubblicante;
        }
        public void setEntePubblicante(String entePubblicante) {
            this.entePubblicante = entePubblicante;
        }
        private int anno;
        public int getAnno() {
            return anno;
        }
        public void setAnno(int anno) {
            this.anno = anno;
        }
        private ArrayList< Prestito> sequenza;
        public ArrayList<Prestito> getSequenza() {
            return sequenza;
        }
        private int giorniPrestito;
        
        public int getGiorniPrestito() {
            return giorniPrestito;
        }
        public void setGiorniPrestito(int giorniPrestito) {
            this.giorniPrestito = giorniPrestito;
        }
        public Supporto(String titolo, String entePubblicante, int anno, int giorniPrestito){
            setAnno(anno);
            setEntePubblicante(entePubblicante);
            setTitolo(titolo);
            setGiorniPrestito(giorniPrestito);
            this.sequenza = new ArrayList<>();
        }
        public void aggiungiPrestito(Prestito p){
            sequenza.add(p);
        }
        public Prestito nuovoPrestito(LocalDate dataInizioPrestito,
                              LocalDate dataConsegna,
                              String nomeUtente,
                              String cognomeUtente,
                              double costoAffitto) {
        LocalDate dataConsegnaPrevista = dataInizioPrestito.plusDays(giorniPrestito);

        Prestito p = new Prestito(dataInizioPrestito,
                              dataConsegnaPrevista,
                              dataConsegna,
                              nomeUtente,
                              cognomeUtente,
                              costoAffitto);

            sequenza.add(p);
         return p;
}
        public double affittoMaggiorato(){
            double costo = 0;
            for (Prestito p : sequenza) {
                if(p.getDataConsegna().isAfter(p.getDataConsegnaPrevista())){
                     costo += p.getCostoAffitto() * 10;
                }
            }
            return costo;
        }

    }
public static class DVD extends Supporto{
        private int durata;

        public int getDurata() {
            return durata;
        }

        public void setDurata(int durata) {
            this.durata = durata;
        }
        public DVD(String titolo, String entePubblicante, int anno, int durata, int giorniPrestito){
            super(titolo, entePubblicante, anno, giorniPrestito);
            setDurata(durata);
        }
    }
public static class Libro extends Supporto{
        private int numeroPagine;

        public int getNumeroPagine() {
            return numeroPagine;
        }

        public void setNumeroPagine(int numeroPagine) {
            this.numeroPagine = numeroPagine;
        }
        public Libro(String titolo, String entePubblicante, int anno, int numeroPagine, int giorniPrestito){
            super(titolo, entePubblicante, anno, giorniPrestito);
            setNumeroPagine(numeroPagine);
        }

    }
public static class Prestito{
        private LocalDate dataInizioPrestito;
        public LocalDate getDataInizioPrestito() {
            return dataInizioPrestito;
        }
        public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
            this.dataInizioPrestito = dataInizioPrestito;
        }
        private LocalDate dataConsegnaPrevista;
        public LocalDate getDataConsegnaPrevista() {
            return dataConsegnaPrevista;
        }
        public void setDataConsegnaPrevista(LocalDate dataConsegnaPrevista) {
            this.dataConsegnaPrevista = dataConsegnaPrevista;
        }
        private LocalDate dataConsegna;
        public LocalDate getDataConsegna() {
            return dataConsegna;
        }
        public void setDataConsegna(LocalDate dataConsegna) {
            this.dataConsegna = dataConsegna;
        }
        private String nomeUtente;
        public String getNomeUtente() {
            return nomeUtente;
        }
        public void setNomeUtente(String nomeUtente) {
            this.nomeUtente = nomeUtente;
        }
        private String cognomeUtente;
        public String getCognomeUtente() {
            return cognomeUtente;
        }
        public void setCognomeUtente(String cognomeUtente) {
            this.cognomeUtente = cognomeUtente;
        }
        private double costoAffitto;
        public double getCostoAffitto() {
            return costoAffitto;
        }
        public void setCostoAffitto(double costoAffitto) {
            this.costoAffitto = costoAffitto;
        }
        public Prestito(LocalDate dataInizioPrestito, LocalDate dataConsegnaPrevista, LocalDate dataConsegna,
                String nomeUtente, String cognomeUtente, double costoAffitto) {
            this.dataInizioPrestito = dataInizioPrestito;
            this.dataConsegnaPrevista = dataConsegnaPrevista;
            this.dataConsegna = dataConsegna;
            this.nomeUtente = nomeUtente;
            this.cognomeUtente = cognomeUtente;
            this.costoAffitto = costoAffitto;
        }
        
    }
public long calcolaPeriodoPrestito(Prestito p){
    LocalDate inizio = p.getDataInizioPrestito();
    LocalDate consegna = p.getDataConsegna();

    long giorni = ChronoUnit.DAYS.between(inizio, consegna);
    
    return giorni;

}
public long massimoPrestito(Supporto s){
    ArrayList<Prestito> sequenza = s.getSequenza();
    ArrayList<Long> massimi = new ArrayList<>();
    for (Prestito p : sequenza) {
        massimi.add(calcolaPeriodoPrestito(p));
    }
    return Collections.max(massimi);
    
}
public boolean inconsitenzaPrestiti(Supporto s){
    ArrayList<Prestito> sequenza = s.getSequenza();
    boolean trovata = false;
    for(int i = 0; i<sequenza.size(); i++){
        Prestito p1 = sequenza.get(i);
        for(int j = i+ 1; j<sequenza.size();j++){
            Prestito p2 = sequenza.get(j);
            if(p1.getDataConsegna()==null){
                System.err.println("Errore");
            }
            if(p1.getDataConsegna().isBefore(p2.getDataInizioPrestito())){
                trovata = true;
                break;
            }
        }
    }
    return trovata;
}

}
