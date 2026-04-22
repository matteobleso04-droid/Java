package src;

import java.util.ArrayList;

class Canzone{
    private String artista;
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    private String titolo;
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    private int durata;
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public Canzone(String artista, String titolo, int durata){
        setArtista(artista);
        setTitolo(titolo);
        setDurata(durata);
    }
}

class Playlist{
    private ArrayList <Canzone> gruppo = new ArrayList<>();

    public ArrayList<Canzone> getGruppo() {
        return gruppo;
    }

    public void setGruppo(ArrayList<Canzone> gruppo) {
        this.gruppo = gruppo;
    }

    public void aggiungiCanzone(Canzone canzone){gruppo.add(canzone);}

    public void calcoladurataMax(){
        int somma = 0;
        for (Canzone canzone : gruppo) {
            somma += canzone.getDurata();
        }
        System.out.println("La durata della playlist è: " + somma + " minuti");
    }
    public void canzonePiuLunga(Playlist playlist){
        Canzone laPiuLunga = gruppo.get(0);
        for (Canzone canzone : gruppo) {
            if(canzone.getDurata() > laPiuLunga.getDurata()){
                laPiuLunga = canzone;
            }
        }
        System.out.println("La canzone con la durata più lunga è: " + laPiuLunga.getTitolo());
    }

}

public class Musica {
    
    public static void main(String[] args) {
        Playlist p1 = new Playlist();
        Canzone c1 = new Canzone("Nayt", "Non è fortuna", 350);
        Canzone c2 = new Canzone("Gemitaiz", "Veleno 6", 450);
        Canzone c3 = new Canzone("Rancore", "S.U.N.S.H.I.N.E.", 600);
        p1.aggiungiCanzone(c1);
        p1.aggiungiCanzone(c2);
        p1.aggiungiCanzone(c3);

        p1.calcoladurataMax();

    }
}
