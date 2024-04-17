/*
Ejer6
Implementar un programa que simule un concesionario de  cochesFeos.
De los cochesFeos queremos saber:
·       código (Será autoincrementativo, según se van creando los vehículos, 
añadiendo ‘2024-‘ delante, ejemplo: 2024-0, 2024-1)
·       modelo(Hasta 20 caracteres, no nulo)
·       precio (antes de impuestos)
·       Un atributo que indique si ese modelo está a la venta o no (booleano),  
por defecto será verdadero, es decir, cuando se cree 
un coche nuevo siempre estará disponible para venderlo por defecto.
Crea la clase Coche que almacene esta información. 
El precio total de un coche se calcula aplicándole el IVA al precio marcado. 
El IVA será el estipulado en ese momento en el mercado, pero 
siempre es el mismo para todos los vehículos.
 */
package modelo;

/**
 *
 * @author AluDAM
 */
public class Coche {
    public final static String CONSTANTEANYO = "2024-";
    private String codigo;
    private String modelo;
    float precio;
    private boolean vendido = false;
    private static float IVA;
    public float precioTotal(){
        return precio*(1+IVA/100);
    }
    
    
    public Coche(){
        //Para hacer pruebas. 
        setCodigo();
    }

    public Coche(String modelo, float precioSinIVA) throws MyException {
        setCodigo();
        setPrecio(precioSinIVA);
        setModelo(modelo);
    }
    
    public Coche(String modelo, String precioSinIVA) throws MyException {
        setCodigo();
        setPrecio(precioSinIVA);
        setModelo(modelo);
    }

    
    
    public Coche(String modelo, float precio, boolean vendible) throws MyException {
        setCodigo();
        setModelo(modelo);
        setPrecio(precio);
        setVendido(vendible);
    }

    private void setCodigo() {
        this.codigo = String.format("%s%05d",CONSTANTEANYO,
                gestora.GestorCoches.tamColeccion());
    }
    public void setModelo(String modelo) throws MyException {
        int lon = modelo.length();
        if (modelo.isBlank()) {
            throw new MyException("El modelo no puede ser nulo. ");
        }else if (lon<20) {
            this.modelo = modelo;
        }else{
            muyMal();
        }
    }

    private void muyMal() throws MyException {
        throw new MyException("Mallll");
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public float setPrecio(String precio) throws MyException {
        float precioFloat = 0;
        try{
            precioFloat = Float.parseFloat(precio);
        }catch(NumberFormatException | NullPointerException ex){
            throw new MyException("El precio no es correcto. ");
        }
        setPrecio(precioFloat);
        return precioFloat;
    }
    public void setVendido(boolean vendible) {
        this.vendido = vendible;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getModelo() {
        return modelo;
    }
    public float getPrecio() {
        return precio;
    }
    public boolean isVendido() {
        return vendido;
    }
    
    

    public static void setIVA(float IVA) {
        Coche.IVA = IVA;
    }

    @Override
    public String toString() {
        return "Coche "+modelo+", con codigo "+codigo+". Precio: "+precioTotal()+
                "\n\tVendido: "+vendido+". IVA: "+IVA;
    }

    public boolean esGanga() {
        return false;
    }

    
}
