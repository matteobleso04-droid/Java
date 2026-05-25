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
        this.puntiVita = this.puntiVita - danno;
        
        if(this.puntiVita > 0){
            System.out.println(getNome() + " subisce " + danno + " danni! HP rimasti: " + this.puntiVita);
        } else {
            this.puntiVita = 0;
            System.out.println(getNome() + " è andato K.O.! 💀");
        }
    }
    public abstract void attacca(Combattente bersaglio);
    
}

class Guerriero extends Combattente{
    private int forzaFisica;

    public int getForzaFisica() {
        return forzaFisica;
    }

    public void setForzaFisica(int forzaFisica) {
        if (forzaFisica >= 0) {
            this.forzaFisica = forzaFisica;
        }
        else{
            System.out.println("La forza di un personaggio non può essere negativa");
        }
    }
    public Guerriero(String nome, int puntiVita,int forzaFisica){
        super(nome, puntiVita);
        setForzaFisica(forzaFisica);
    }

    @Override
    public void attacca(Combattente bersaglio){
        System.out.println(getNome() + " attacca " + bersaglio.getNome());
        bersaglio.riceviDanno(forzaFisica);
    }
}

class Mago extends Combattente implements Magico{
    private int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana >= 0) {
            this.mana = mana;
        }
        else{
            System.out.println("Il mana di un mago non può essere negativo");
        }
    }
    public Mago(String nome, int puntiVita, int mana){
        super(nome, puntiVita);
        setMana(mana);
    }

    public void cura(){
        setPuntiVita(getPuntiVita() + 20);
        System.out.println(getNome() + " ha recuperato 20 HP");
    }
    @Override
    public void attacca(Combattente bersaglio){
        System.out.println("L'attaccante ha colpito il bersagli! ");
        bersaglio.riceviDanno(mana);
    }
}

public class Arena {

public static void main(String[] args) {
    Guerriero g1 = new Guerriero("Aaragorn", 10000, 4500);
    Mago m1 = new Mago("Gandal", 8000, 3000);
    ArrayList <Combattente> gruppo = new ArrayList<>();
    gruppo.add(g1);
    gruppo.add(m1);
    g1.attacca(m1);
    m1.attacca(g1);
    m1.cura();

    System.out.println(g1.getPuntiVita() + " " + m1.getPuntiVita());

}
}
