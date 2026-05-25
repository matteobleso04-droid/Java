import java.util.ArrayList;

abstract class Camera{
    private int numeroCamera;
    public int getNumeroCamera() {
        return numeroCamera;
    }
    public void setNumeroCamera(int numeroCamera) {
        if(numeroCamera > 0){
            this.numeroCamera = numeroCamera;
        }
        else{
            System.out.println("Il numero camera deve essere maggiore di 0");
        }
    }
    private double prezzoNotte;
    public double getPrezzoNotte() {
        return prezzoNotte;
    }
    public void setPrezzoNotte(double prezzoNotte) {
        if (prezzoNotte >= 0) {
            this.prezzoNotte = prezzoNotte;
        }
        else{
            System.out.println("Il prezzo deve essere maggiore di 0");
        }
    }
    public Camera(int numeroCamera, double prezzoNotte){
        setNumeroCamera(numeroCamera);
        setPrezzoNotte(prezzoNotte);
    }
    public abstract double calcolaCosto(int notti);
    public void descrivi(){
        System.out.println(getPrezzoNotte());
        System.out.println(getNumeroCamera());
    }
}
class CameraStandard extends Camera{
    private boolean colazioneInclusa;
    public void setColazioneInclusa(boolean colazioneInclusa) {
        this.colazioneInclusa = colazioneInclusa;
    }
    @Override
    public double calcolaCosto(int notti){
        double base = getPrezzoNotte() * notti;
        if (colazioneInclusa){
            return base + ( 15 * notti);
        }
        return base;
    }
    public CameraStandard(boolean colazioneInclusa, int numeroCamera, double prezzoNotte){
        super(numeroCamera, prezzoNotte);
        setColazioneInclusa(colazioneInclusa);
    }

}

class CameraSuite extends Camera{
    private int serviziExtra;

    public int getServiziExtra() {
        return serviziExtra;
    }

    public void setServiziExtra(int serviziExtra) {
        this.serviziExtra = serviziExtra;
    }
    @Override
    public double calcolaCosto(int notti){
        double base = getPrezzoNotte() * notti * 50;
        if (getServiziExtra() > 0 ) {
            base = getPrezzoNotte() * (notti + getServiziExtra()) * 50;
        }
        return base;
    }
    public CameraSuite(int numeroCamera, double prezzoNotte, int serviziExtra){
        super(numeroCamera, prezzoNotte);
        setServiziExtra(serviziExtra);
    }
}



public class claude {
    
}
