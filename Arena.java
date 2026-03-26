import java.util.ArrayList;

interface Magico {
    public void cura();
}
abstract class Combattente{
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(!nome.isEmpty()){
            this.nome = nome;
        }
        else{
            System.out.println("Il nome non può essere vuoto!");
        }
    }
    private int puntiVita;
    public int getPuntiVita() {
        return puntiVita;
    }
    public void setPuntiVita(int puntiVita) {
        if (puntiVita > 0) {
            this.puntiVita = puntiVita;
        }
        else{
            System.out.println("I punti vita non possono essere 0");
        }
    }
    public Combattente(String nome, int puntiVita){
        setNome(nome);
        setPuntiVita(puntiVita);
    }
public void riceviDanno(int danno){
        this.puntiVita = this.puntiVita - danno; // AGGIORNO GLI HP VERI!
        
        if(this.puntiVita > 0){
            System.out.println(getNome() + " subisce " + danno + " danni! HP rimasti: " + this.puntiVita);
        } else {
            this.puntiVita = 0; // Evito che gli HP vadano sotto zero
            System.out.println(getNome() + " è andato K.O.! 💀");
        }
    }
    public abstract void attacca();
}

class Guerriero extends Combattente{
    private int forzaFisica;

    public int getForzaFisica() {
        return forzaFisica;
    }

    public void setForzaFisica(int forzaFisica) {
        this.forzaFisica = forzaFisica;
    }
    public Guerriero(String nome, int puntiVita,int forzaFisica){
        super(nome, puntiVita);
        setForzaFisica(forzaFisica);
    }
    public void attacca(){
        System.out.println("Attacco con la spada pesante! ");
    }
}

class Mago extends Combattente implements Magico{
    private int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    public Mago(String nome, int puntiVita, int mana){
        super(nome, puntiVita);
        setMana(mana);
    }
    public void attacca(){
        System.out.println("Lancia un dardo di energia! ");
    }
    public void cura(){
        System.out.println("Recupera 20 HP! ");
    }
}

public class Arena {

public static void main(String[] args) {
    Guerriero g1 = new Guerriero("Aaragorn", 5000, 7000);
    Mago m1 = new Mago("Gandal", 1000, 3000);
    ArrayList <Combattente> gruppo = new ArrayList<>();
    gruppo.add(g1);
    gruppo.add(m1);
    for(Combattente c : gruppo){
        System.out.println(c.getNome());
        if(c instanceof Magico){
            Mago magoTemp = (Mago) c;
            magoTemp.cura();
        }
    }
}
}
