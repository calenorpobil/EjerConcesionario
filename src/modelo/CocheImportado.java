/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author AluDAM
 */
public class CocheImportado extends Coche {
    private float impuestoHomologacion;

    public CocheImportado() {
    }

    /**
     * 
     * @param impuestoHomologacion
     * @param modelo
     * @param precioSinIVA
     * @throws MyException 
     */
    public CocheImportado(String impuestoHomologacion, String modelo, 
            String precioSinIVA) throws MyException {
        super(modelo, precioSinIVA);
        setImpuestoHomologacion(impuestoHomologacion);
    }
    
    public boolean esGanga(){
        return impuestoHomologacion<5000;
    }
    
    
    @Override
    public float precioTotal(){
        return super.precioTotal()*impuestoHomologacion;
    }
    
    public void setImpuestoHomologacion(String imp) throws MyException{
        int impuesto;
        try{
            impuesto = Integer.parseInt(imp);
        }catch(NumberFormatException ex){
            throw new MyException("Impuesto incorrecto");
        }
        setImpuestoHomologacion(impuesto);
        
        
    }
    
    /*
    En el CocheImportado, queda hacer el Set impuesto Homologacion con una cadena, 
    y que sea > 0. 
    */

    public void setImpuestoHomologacion(float impuestoHomologacion) 
            throws MyException {
        if (impuestoHomologacion>0) {
            this.impuestoHomologacion = impuestoHomologacion;
        }else{
            throw new MyException("El impuesto debe ser mayor que 0.");
        }
    }

    public float getImpuestoHomologacion() {
        return impuestoHomologacion;
    }
    

    @Override
    public String toString() {
        return super.toString()+ "Coche Importado con " + impuestoHomologacion + 
        "de impuesto de homologacion. ";
    }
    
}
