import java.time.LocalDate;
import java.util.ArrayList;

class Dipendente{
    public enum Dipartimento{ MARKETING, RISORSE_UMANE, SVILUPPO}
    public enum Mansione{ IMPIEGATO, MAGAZZINIERE, PROGRAMMATORE}
    private String nome;
    public String getNome() {
        return nome;
    }

    private String cognome;
    public String getCognome() {
        return cognome;
    }

    private LocalDate dataNascita;
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    private LocalDate dataAssunzione;
    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    protected String matricola;
    private static int contatore = 0;

    private Dipartimento dipartimento;
    public Dipartimento getDipartimento() {
        return dipartimento;
    }
    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }
    public int getLivello() {
        return livello;
    }
    public void setLivello(int livello) {
        if(livello >= 1 && livello <= 8){
            this.livello = livello;
        }
        else{
            System.out.println("Il livello deve essere compreso tra 1 e 8!");
        }
    }
    private int livello;
    private Mansione mansione;

    public Mansione getMansione() {
        return mansione;
    }
    public void setMansione(Mansione mansione) {
        this.mansione = mansione;
    }
    private Dipendente capo;
    public Dipendente getCapo() {
        return capo;
    }
    public void setCapo(Dipendente capo) {
        this.capo = capo;
    }
    public Dipendente(String nome, String cognome, LocalDate dataNascita, LocalDate dataAssuznione, Dipartimento dipartimento, int livello, Mansione mansione, Dipendente capo){
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssuznione;
        this.dataNascita = dataNascita;
        setDipartimento(dipartimento);
        setLivello(livello);
        setMansione(mansione);
        setCapo(capo);
        this.matricola = "CLT " + contatore;
        contatore++;
    }
}


public class Azienda {
    private ArrayList <Dipendente> ditta;

    public Azienda(){
        this.ditta = new ArrayList<>();
    }

    public void assumiDipendente(Dipendente nuovo){
        this.ditta.add(nuovo);
    }
    public void getChainofComand(Dipendente dipendente){
        Dipendente capoCorrente = dipendente.getCapo();

        while(capoCorrente != null){
            System.out.println("Il capo di " + dipendente.getNome() + " è " + capoCorrente.getNome());

            capoCorrente = capoCorrente.getCapo();
        }
    }
}
