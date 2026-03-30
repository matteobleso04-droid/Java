import java.util.ArrayList;

class Studente{
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
    private String matricola;
    public String getMatricola() {
        return matricola;
    }
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    
    public Studente(String nome, String cognome, String matricola){
        setNome(nome);
        setCognome(cognome);
        setMatricola(matricola);
    }
}

class ProvaStudente{
    private int provaJava;
    public int getProvaJava() {
        return provaJava;
    }
    public void setProvaJava(int provaJava) {
        this.provaJava = provaJava;
    }
    private int provaPython;
    public int getProvaPython() {
        return provaPython;
    }
    public void setProvaPython(int provaPython) {
        this.provaPython = provaPython;
    }
    private int provaProlog;
    public int getProvaProlog() {
        return provaProlog;
    }
    public void setProvaProlog(int provaProlog) {
        this.provaProlog = provaProlog;
    }
    private int oraleJava;
    public int getOraleJava() {
        return oraleJava;
    }
    public void setOraleJava(int oraleJava) {
        this.oraleJava = oraleJava;
    }
    private int oraleOOP;
    public int getOraleOOP() {
        return oraleOOP;
    }
    public void setOraleOOP(int oraleOOP) {
        this.oraleOOP = oraleOOP;
    }
    private Studente studente;
    public Studente getStudente() {
        return studente;
    }
    public void setStudente(Studente studente) {
        this.studente = studente;
    }
    public ProvaStudente(int provaJava, int provaProlog, int provaPython, int oraleJava, int oraleOOP, Studente studente){
        setOraleJava(oraleJava);
        setOraleOOP(oraleOOP);
        setProvaJava(provaJava);
        setProvaProlog(provaProlog);
        setProvaPython(provaPython);
        setStudente(studente);
    }
}

class Appello{
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    ArrayList <ProvaStudente> compitiConsegnati = new ArrayList<>();

    private int bonusMassimo;

    public int getBonusMassimo() {
        return bonusMassimo;
    }

    public void setBonusMassimo(int bonusMassimo) {
        this.bonusMassimo = bonusMassimo;
    }
    private double pesoOrale;

    public double getPesoOrale() {
        return pesoOrale;
    }

    public void setPesoOrale(double pesoOrale) {
        this.pesoOrale = pesoOrale;
    }
    private double pesoScritto;

    public double getPesoScritto() {
        return pesoScritto;
    }

    public void setPesoScritto(double pesoScritto) {
        this.pesoScritto = pesoScritto;
    }
    public Appello(int data, int bonusMassimo, double pesoOrale, double pesoScritto, ProvaStudente compitiConsegnati){
        setBonusMassimo(bonusMassimo);
        setData(data);
        setPesoOrale(pesoOrale);
        setPesoScritto(pesoScritto);
        this.compitiConsegnati = new ArrayList<>();
    }
    public void aggiungiCompito(ProvaStudente nuovoCompito){
        this.compitiConsegnati.add(nuovoCompito);
    }
    public double calcolaVotoFinale(ProvaStudente compito){
        double mediaScritti = (compito.getProvaJava() + compito.getProvaPython() + compito.getProvaProlog()) / 3.0;

        double mediaOrali = (compito.getOraleJava() + compito.getOraleOOP())/2.0;

        double votoFinale = (mediaScritti * this.pesoScritto) + (mediaOrali * this.pesoOrale);
        return votoFinale;
    }
}
public class Docenti {
    public static void main(String[] args) {
        Studente s1 = new Studente("Mario", "Rossi", "0355943");
        ProvaStudente p1 = new ProvaStudente(25, 13, 27, 28, 20, s1);
        Appello a1 = new Appello(14, 2, 1, 1, p1);
        a1.aggiungiCompito(p1);
        System.out.println(a1.calcolaVotoFinale(p1));
    }
}