import java.util.ArrayList;
import java.util.List;
// Stazione, Tratta, Tipologia Tratta, Biglietto
enum tipoTreno {normale, altaVelocita, entrambi}
enum TipologiaTreno {normale, altaVelocita}

class Stazione{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty()){
            this.nome = nome;
        }
        else{
            System.out.println("Il nome della stazione non può essere vuoto");
        }
    }
    private String codice;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        if(!codice.isEmpty()){
            this.codice = codice;
        }
        else{
            System.out.println("Il codice stazione non può essere vuoto");
        }
    }
    public Stazione(String nome, String codice){
        setCodice(codice);
        setNome(nome);
    }
}
class TipologiaTratta{
    private String codiceTratta;

    public String getCodiceTratta() {
        return codiceTratta;
    }

    public void setCodiceTratta(String codiceTratta) {
        this.codiceTratta = codiceTratta;
    }
    private int costoKm;

    public int getCostoKm() {
        return costoKm;
    }

    public void setCostoKm(int costoKm) {
        this.costoKm = costoKm;
    }
    public TipologiaTratta(String codiceTratta, int costoKm){
        setCodiceTratta(codiceTratta);
        setCostoKm(costoKm);
    }
}
class Tratta{
    private int lunghezza;
    public int getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }
    private Stazione stazione1;
    public Stazione getStazione1() {
        return stazione1;
    }
    public void setStazione1(Stazione stazione1) {
        this.stazione1 = stazione1;
    }
    private Stazione stazione2;
    public Stazione getStazione2() {
        return stazione2;
    }
    public void setStazione2(Stazione stazione2) {
        this.stazione2 = stazione2;
    }
    private TipologiaTratta tipoTratta;
    public TipologiaTratta getTipoTratta() {
        return tipoTratta;
    }
    public void setTipoTratta(TipologiaTratta tipoTratta) {
        this.tipoTratta = tipoTratta;
    }
    private tipoTreno tipoTreno;

    
    public tipoTreno getTipoTreno() {
        return tipoTreno;
    }
    public void setTipoTreno(tipoTreno tipoTreno) {
        this.tipoTreno = tipoTreno;
    }
        public Tratta(int lunghezza, Stazione stazione1, Stazione stazione2, TipologiaTratta tipoTratta,
            tipoTreno tipoTreno) {
                setLunghezza(lunghezza);
                setStazione1(stazione1);
                setStazione2(stazione2);
                setTipoTratta(tipoTratta);
                setTipoTreno(tipoTreno);
            }
    
}
class TrattaPercorsa{
    private Tratta tratta;
    public Tratta getTratta() {
        return tratta;
    }
    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }
    private TipologiaTreno tipoTreno;
    public TipologiaTreno getTipoTreno() {
        return tipoTreno;
    }
    public void setTipoTreno(TipologiaTreno tipoTreno) {
        this.tipoTreno = tipoTreno;
    }
    public TrattaPercorsa(Tratta tratta, TipologiaTreno tipoTreno) {
        setTipoTreno(tipoTreno);
        setTratta(tratta);
    }
    public double calcolaPrezzoParziale(double coeffAltaV){
        double base = tratta.getLunghezza() * tratta.getTipoTratta().getCostoKm();
        if(tipoTreno == TipologiaTreno.altaVelocita){
            base *= coeffAltaV;
        }
        return base;
    }
}
class Biglietto{
    private int lunghezza;
    public int getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }
    private Stazione partenza;
    public Stazione getPartenza() {
        return partenza;
    }
    public void setPartenza(Stazione partenza) {
        this.partenza = partenza;
    }
    private Stazione destinazione;
    public Stazione getDestinazione() {
        return destinazione;
    }
    public void setDestinazione(Stazione destinazione) {
        this.destinazione = destinazione;
    }
    private TipologiaTreno tipoTreno;
    public TipologiaTreno getTipoTreno() {
        return tipoTreno;
    }
    public void setTipoTreno(TipologiaTreno tipoTreno) {
        this.tipoTreno = tipoTreno;
    }
    private double prezzoBiglietto;
    public double getPrezzoBiglietto() {
        return prezzoBiglietto;
    }
    public void setPrezzoBiglietto(double prezzoBiglietto) {
        this.prezzoBiglietto = prezzoBiglietto;
    }
    private List<TrattaPercorsa> trattaPercorsa;

    public List<TrattaPercorsa> getTrattaPercorsa() {
        return trattaPercorsa;
    }
    public void setTrattaPercorsa(List<TrattaPercorsa> trattaPercorsa) {
        this.trattaPercorsa = trattaPercorsa;
    }
    public Biglietto(int lunghezza, Stazione partenza, Stazione destinazione, TipologiaTreno tipoTreno,
        double prezzoBiglietto, List<TrattaPercorsa> trattaPercorsa) {
            setLunghezza(lunghezza);
            setDestinazione(destinazione);
            setPartenza(partenza);
            setPrezzoBiglietto(prezzoBiglietto);
            setTipoTreno(tipoTreno);
            setTrattaPercorsa(trattaPercorsa);
    }
    public double calcolaCosto(double coeffAltaV){
        double totale = 0;
        for (TrattaPercorsa tp : trattaPercorsa) {
            totale += tp.calcolaPrezzoParziale(coeffAltaV);
        }
        return totale;
    }

}