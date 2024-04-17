package gestora;

import java.util.ArrayList;
import modelo.Coche;
import modelo.MyException;

/**
 *
 * @author AluDAM
 */
public class GestorCoches {
    //Iterator es para eliminar coche. Para encontrarlo, un for. 
    
    private static ArrayList<Coche> coches = new ArrayList<>();
    
    
    public static boolean addCoche(Coche c){
        return coches.add(c);
    }
    public static void cambiaIVA(double iva){
        
    }
    
    public static int tamColeccion(){
        return coches.size();
    }
    
    public static String cochesFeos(){
        String cocx ="";
        for (Coche c : coches) {
            cocx+=c.toString()+"\n";
        }
        return cocx;
    }
    public static String cochesFeosEnVenta(){
        String cocx ="";
        for (Coche c : coches) {
            if (!c.isVendido()) {
                cocx+=c.toString()+"\n";
            }
        }
        return cocx;
    }
    /**
     * 
     * Mostrar ‘gangas’: Sólo muestra los coches de importación que tengan 
     * menos de 5.000€ como impuesto de homologación, y los coches de 
     * km cero con más de 1000Km.
     * 
     * @return 
     */
    public static String cochesGanga(){
        String cocx ="";
        for (Coche c : coches) {
            if (c.esGanga()) {
                cocx+=c.toString()+"\n";
            }
        }
        return cocx;
    }
    public static String cochesFeosVendidos(){
        String cocx ="";
        for (Coche c : coches) {
            if (c.isVendido()) {
                cocx+=c.toString()+"\n";
            }
        }
        return cocx;
    }
    
    /**
     * 
     * @param codigo --> La cadena con el codigo del coche
     * @return El coche con el código o null si no existe
     * @throws modelo.MyException
     */
    public static Coche buscaCoche(String codigo) throws MyException{
        String parteNum="";
        try{
            parteNum = codigo.substring(Coche.CONSTANTEANYO.length());
        }catch(IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException("No existe, fallo Substring");
        }
        int num ;
        num = Integer.parseInt(parteNum);
        Coche elCoche = coches.get(num);
        if (elCoche==null) {
            throw new MyException("No existe este coche.");
        }else{
            return elCoche;
        }
    }

    public static boolean borraCoche(Coche c) {
        return coches.remove(c);
    }
    
    
    
}
