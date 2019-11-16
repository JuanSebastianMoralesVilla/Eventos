
package model;

/**
 *
 * @author user
 */
public class silla {
   
    
    private String estado;
    private int numeroSilla;
    private char fila;
    private String descripcion;
    public static String OPERATIVA= "operativa";
    public static String DISPONIBLE="disponible";
    public static String OCUPADA="ocupada";
       public static String DEFECTUOSA= "defectuosa";
       
       

    public silla(String estado, int numeroSilla, char fila, String descripcion) {
        this.estado = estado;
        this.numeroSilla = numeroSilla;
        this.fila = fila;
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroSilla() {
        return numeroSilla;
    }

    public void setNumeroSilla(int numeroSilla) {
        this.numeroSilla = numeroSilla;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static String getOPERATIVA() {
        return OPERATIVA;
    }

    public static void setOPERATIVA(String OPERATIVA) {
        silla.OPERATIVA = OPERATIVA;
    }

    public static String getDEFECTUOSA() {
        return DEFECTUOSA;
    }

    public static void setDEFECTUOSA(String DEFECTUOSA) {
        silla.DEFECTUOSA = DEFECTUOSA;
    }

    @Override
    public String toString() {
        return "silla{" + fila +"-"+ numeroSilla + ", "+ estado + '}';
    }

    
       
       
       
    
    
    
}
