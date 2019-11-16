package model;

/**
 *
 * @author user
 */
public class university {
    
    private String name;
    
    auditorium[] auditoriums = new auditorium[20];
    
    public university(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public auditorium[] getAuditoriums() {
        return auditoriums;
    }
    
    public void setAuditoriums(auditorium[] auditoriums) {
        this.auditoriums = auditoriums;
    }
    
    public void createAuditorium(String nombre, String ubicacion, String estado, int[] cantSillas) {
        
        for (int i = 0; i < auditoriums.length; i++) {
            if (auditoriums[i] == null) {
                auditoriums[i] = new auditorium(nombre, ubicacion, estado, cantSillas);
                i = auditoriums.length;
            }
            
        }
        
    }
    
    public auditorium audit(int index) {
        return auditoriums[index];
    }
    
    public Event event(int index, auditorium auditoriums) {
        return auditoriums.getEvents().get(index);
    }
    
    public String addEvent(Event e, auditorium a) {
        
        String msg = a.addEvent(e);
        e.addAuditorium(a);
        return msg;
    }
    
    public void printStateAuditurium(int index) {
        
        auditorium a = audit(index);
        System.out.println(a.getNombre()+"-->"+a.getEstado());
        for (int i = 0; i < a.getSillas().length; i++) {
            for (int j = 0; j < a.getSillas()[i].length; j++) {
                if (a.getSillas()[i][j] != null) {
        
                    System.out.print(a.getSillas()[i][j].toString());
                    
                }
            }
            System.out.println("");
        }
    }
    
}
