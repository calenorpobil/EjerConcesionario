/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author AluDAM
 */
public class CocheKmCero extends Coche {
    private int km;

    public CocheKmCero() {
    }

    public CocheKmCero(int km, String modelo, String precioSinIVA) throws MyException {
        super(modelo, precioSinIVA);
        setKm(km);
    }
    
    public CocheKmCero(String km, String modelo, String precioSinIVA) throws MyException {
        super(modelo, precioSinIVA);
        setKm(km);
    }
    
    @Override
    public float precioTotal(){
        return super.precioTotal()-(0.01f*km)/100;
    }

    public void setKm(int km) throws MyException {
        if(km<0){
            throw new MyException("Los KM tienen valores no validos...");
        }else{
            this.km = km;
        }
    }
    
    public int setKm(String km) throws MyException {
        int kilometro;
        try{
            kilometro = Integer.parseInt(km);
            setKm(kilometro);
            return kilometro;
        }catch(NullPointerException | NumberFormatException ex){
            throw new MyException("Los KM tienen valores no validos...");
        }
    }
    
    public boolean esGanga(){
        return km>1000;
    }

    public int getKm() {
        return km;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString()+ "Coche KM 0 con " + km + 
        " kilometros gastados. ";
    }
    
    
    
}
