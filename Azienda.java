import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Azienda{
public enum Dipartimento{MARKETING, RISORSEUMANE, SVILUPPO}
public class Dipendente{
    private String nome;
    public String getNome() {
        return nome;
    }
public void setNome(String nome) {
        this.nome = nome;
    }
    private String cognome;
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    private LocalDate dataNascita;
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
        }
    private LocalDate dataAssunzione;
    public LocalDate getDataAssunzione() {
            return dataAssunzione;
        }
    public void setDataAssunzione(LocalDate dataAssunzione) {
            this.dataAssunzione = dataAssunzione;
        }
    private String mansione;
    public String getMansione() {
            return mansione;
        }
    public void setMansione(String mansione) {
            this.mansione = mansione;
        }
    private int livello;
        public int getLivello() {
            return livello;
        }
    public void setLivello(int livello) {
            if(livello >= 1 && livello <= 8){
                this.livello = livello;
            }
            else{
                System.out.println("Il livello non può essere sotto 1");
            }
        }
    private Dipendente capo;
    public Dipendente getCapo() {
            return capo;
        }
    public void setCapo(Dipendente capo) {
            this.capo = capo;
        }
    private Dipartimento dipartimento;
    public Dipartimento getDipartimento() {
            return dipartimento;
        }
    public void setDipartimento(Dipartimento dipartimento) {
            this.dipartimento = dipartimento;
        }
    private String numeroMatricola;
    public String getNumeroMatricola() {
            return numeroMatricola;
        }
    public void setNumeroMatricola(String numeroMatricola) {
            this.numeroMatricola = numeroMatricola;
        }
    private static int contatore = 0;
    public Dipendente(String nome, String cognome, LocalDate dataNascita, LocalDate dataAssunzione, Dipartimento dipartimento,
            String mansione, Dipendente capo, int livello, String numeroMatricola){
            setCapo(capo);
            setCognome(cognome);
            setNome(nome);
            setDataAssunzione(dataAssunzione);
            setDataNascita(dataNascita);
            setDipartimento(dipartimento);
            setLivello(livello);
            setMansione(mansione);
            this.numeroMatricola = "CLT_" + contatore;
            contatore++;
        }


    }
    List<Dipendente> dipendenti;
public Azienda(){
    this.dipendenti = new ArrayList<>();
}
public void aggiungiDipendente(Dipendente d){
        dipendenti.add(d);
    }
public List<Dipendente> capoSuccessivo(Dipendente d){
    List<Dipendente> capi = new ArrayList<>();
    Dipendente capoDipendente = d.getCapo();
    while(capoDipendente != null){
        capi.add(capoDipendente);
        capoDipendente = capoDipendente.getCapo();
        }
        return capi;
        }
public Dipendente trovaCapoProssimo(Dipendente d1, Dipendente d2){
        List<Dipendente> chain1 = capoSuccessivo(d1);
        List<Dipendente> chain2 = capoSuccessivo(d2);
        for (Dipendente capo : chain1) {
            if(chain2.contains(capo)){
                    return capo;
                }
        }
        return null;
        }
public Dipendente trovaSostituto(Dipendente currDip) {
    if (currDip.getCapo() == null) {
        System.out.println("Impiegato insostituibile");
        return null;
    }

    Dipendente migliore = null;
    Dipendente capoProssimo = null;
    List<Dipendente> chainD = capoSuccessivo(currDip);

    for (Dipendente d : dipendenti) {
        if (d.equals(currDip)) continue;
        if (!d.getMansione().equals(currDip.getMansione())) continue;

        Dipendente capoComune = trovaCapoProssimo(currDip, d);
        if (capoComune != null) {
            // se non abbiamo ancora un migliore, oppure questo capo è più vicino
            if (capoProssimo == null || 
                chainD.indexOf(capoComune) < chainD.indexOf(capoProssimo)) {
                migliore = d;
                capoProssimo = capoComune;
            }
        }
    }

    if (migliore == null) System.out.println("Impiegato insostituibile");
    return migliore;
}
}