
package model;


public class Event {
  
    
    
    private String nombre;
    private int dia;
    private int mes;
    private int anio;
    private int horainicio;
    private int horafinal;
    private String ProfesorEncargado;
    private String facultad;
    private int cantidadDePersonas;
    
    
   private auditorium [] auditoriums = new auditorium[ 10 ];
    

    public Event(String nombre, int dia, int mes, int anio, int horainicio, int horafinal, String ProfesorEncargado, String facultad, int cantidadDePersonas) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.horainicio = horainicio;
        this.horafinal = horafinal;
        this.ProfesorEncargado = ProfesorEncargado;
        this.facultad = facultad;
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public auditorium[] getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(auditorium[] auditoriums) {
        this.auditoriums = auditoriums;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(int horainicio) {
        this.horainicio = horainicio;
    }

    public int getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(int horafinal) {
        this.horafinal = horafinal;
    }

    public String getProfesorEncargado() {
        return ProfesorEncargado;
    }

    public void setProfesorEncargado(String ProfesorEncargado) {
        this.ProfesorEncargado = ProfesorEncargado;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
    
    public void addAuditorium(auditorium a){
    
        for (int i = 0; i < auditoriums.length; i++) {
            if(auditoriums[i]==null){
                auditoriums[i]=a;
                i=auditoriums.length;
            }
        }
    }
    
    @Override
    public String toString() {
        return  "nombre=" + nombre + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", horainicio=" + horainicio + ", horafinal=" + horafinal + ", ProfesorEncargado=" + ProfesorEncargado + ", facultad=" + facultad + ", cantidadDePersonas=" + cantidadDePersonas;
    }
    
    
    
    
    
    
    
}
