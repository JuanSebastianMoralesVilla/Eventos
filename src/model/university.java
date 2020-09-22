package model;

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

    /**
     * @name: createAuditorium
     * @descripition: this method creates an auditorium  <br>
     * <b>pre: </b> the parameters entered, add the auditorium to the array <br>
     *
     * @param nombre .
     * @param ubicacion.
     * @param estado
     * @param cantSillas
     *
     * <b>post: </b> auditorium add <br>
     */
    public void createAuditorium(String nombre, String ubicacion, String estado, int[] cantSillas) {

        for (int i = 0; i < auditoriums.length; i++) {
            if (auditoriums[i] == null) {
                auditoriums[i] = new auditorium(nombre, ubicacion, estado, cantSillas);
                i = auditoriums.length;
            }

        }

    }

    /**
     * @name: audit
     * @descripition: the auditorium puts me in a position <br>
     * <b>pre: </b> array audit created <br>
     *
     * @param index .
     *
     * <b>return </b> auditorium in position index<br>
     */
    public auditorium audit(int index) {
        return auditoriums[index];
    }

    /**
     * @name: event
     * @descripition: the events puts me in a position <br>
     * <b>pre: </b> array event created <br>
     *
     * @param index .
     * @param auditoriums
     *
     * <b>return </b> event in position index <br>
     */
    public Event event(int index, auditorium auditoriums) {
        return auditoriums.getEvents().get(index);
    }

    /**
     * @name: addEvent
     * @descripition: this method creates event  <br>
     * <b>pre: </b> the parameters entered, add the event to the arraylist <br>
     *
     * @param a .
     * @param e .
     * <b>post: </b> event add <br>
     */
    public String addEvent(Event e, auditorium a) {

        String msg = a.addEvent(e);
        e.addAuditorium(a);
        return msg;
    }

    /**
     * @name: printStateAuditurium
     * @descripition: this method print state auditurium <br>
     * <b>pre: </b> there is at least one auditorium in the arrangement <br>
     *
     * @param index .
     *
     *
     */
    public void printStateAuditurium(int index) {

        auditorium a = audit(index);
        System.out.println(a.getNombre() + "-->" + a.getEstado());
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
