package model;

import java.util.ArrayList;

public class auditorium {

    private String nombre;
    private String ubicacion;
    private String estado;
    private double cantSillasDefectuosas;
    private double cantSillasDisponibles;
    private double cantSillasOcupadas;
    private String nombreOriginal;
    public static String OCUPADO = "ocupado";
    public static String DISPONIBLE = "disponible";

    // relaciones 
    private ArrayList<Event> events;

    private silla[][] sillas;

    // constructor
    public auditorium(String nombre, String ubicacion, String estado, int[] cantSillas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.events = new ArrayList();
        this.nombreOriginal = nombre;
        createSilla(cantSillas);
    }

    public double getCantSillasDefectuosas() {
        return cantSillasDefectuosas;
    }

    public void setCantSillasDefectuosas(double cantSillasDefectuosas) {
        this.cantSillasDefectuosas = cantSillasDefectuosas;
    }

    public double getCantSillasDisponibles() {
        return cantSillasDisponibles;
    }

    public void setCantSillasDisponibles(double cantSillasDisponibles) {
        this.cantSillasDisponibles = cantSillasDisponibles;
    }

    public silla[][] getSillas() {
        return sillas;
    }

    public void setSillas(silla[][] sillas) {
        this.sillas = sillas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static String getOCUPADO() {
        return OCUPADO;
    }

    public static void setOCUPADO(String OCUPADO) {
        auditorium.OCUPADO = OCUPADO;
    }

    public static String getDISPONIBLE() {
        return DISPONIBLE;
    }

    public static void setDISPONIBLE(String DISPONIBLE) {
        auditorium.DISPONIBLE = DISPONIBLE;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    // llena sillas en la matriz silla 
    /**
     * @name fillChair
     * @description:This method fills the chairs with the number of people in
     * the event, changing the available chairs to occuped
     *
     * <b>pre : there is at least one event with all its parameters</b> <br>
     * @param person // cntidad de personas
     * <b>post: </b> state of chair change of available to ocupated  <br>
     */
    public void fillChairs(int person) {
        setChairsState();
        int n = person;
        for (int j = 0; j < sillas.length; j++) {
            for (int k = 0; k < sillas[j].length; k++) {
                if (person != 0) {
                    if (sillas[j][k].getEstado().equals(silla.DISPONIBLE)) {
                        sillas[j][k].setEstado(silla.OCUPADA);
                        person--;
                    }
                } else {

                }

            }
        }

    }

    /**
     * @name closeEvent
     * @descripition:This method allows me to close the event, changing the
     * ocupated chairs to operational  <br>
     * <b>pre: </b> the event must be initialized<br>
     *
     * @param event
     *
     * <b>post: </b> state of auditorium change to availaible  <br>
     */
    public String closeEvent(Event event) {
        if (events.contains(event)) {
            for (int j = 0; j < sillas.length; j++) {
                for (int k = 0; k < sillas[j].length; k++) {
                    if (sillas[j][k].getEstado().equals(silla.DISPONIBLE) || sillas[j][k].getEstado().equals(silla.OCUPADA)) {
                        sillas[j][k].setEstado(silla.OPERATIVA);
                    }

                }
            }
            nombre = nombreOriginal;
            estado = DISPONIBLE;
            return "El evento " + event.getNombre() + " ha terminado con exito";
        } else {
            return "El evento no esta asignado a este auditorio";
        }

    }

    /**
     * @name initEvent
     * @descripition:This method allows me to start the event, changing the
     * operational chairs to available also change the available chairs to
     * occupied  <br>
     * <b>pre: </b> There must be at least one event.<br>
     *
     * @param event
     *
     * <b>post: </b> event started and change the state of auditorium to
     * ocupated  <br>
     */
    public String initEvent(Event event) {

        if (estado != OCUPADO) {
            if (events.contains(event)) {
                this.setEstado(OCUPADO);
                for (int i = 0; i < sillas.length; i++) {
                    for (int j = 0; j < sillas[i].length; j++) {
                        if (sillas[i][j].getEstado().equals(silla.OPERATIVA)) {
                            sillas[i][j].setEstado(silla.DISPONIBLE);
                        }
                    }
                }
                nombre = nombre + "-->" + event.getNombre();
                fillChairs(event.getCantidadDePersonas());
                return "El evento " + event.getNombre() + "ha iniciado";
            }

        } else {
            return "El auditorio actualmente se encuentra ocupado, por favor espere";
        }

        return null;
    }

    /**
     * @name: createSilla
     * @descripition: this method creates matriz chairs of auditorium also add
     * an identification to a chair or letter and number  <br>
     * <b>pre: </b> there must be an auditorium to assign some chairs <br>
     *
     * @param cantSillas
     *
     * <b>post: </b> chairs of auditorium created <br>
     */
    public void createSilla(int cantSillas[]) {

        int numMayor = cantSillas[0];
        int numSilla = 1;
        char fila[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < cantSillas.length; i++) {
            if (cantSillas[i] > numMayor) {
                numMayor = cantSillas[i];
            }
        }
        sillas = new silla[cantSillas.length][numMayor];

        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < cantSillas[i]; j++) {
                sillas[i][j] = new silla(silla.OPERATIVA, numSilla, fila[i], "");
                numSilla++;
            }
            numSilla = 1;

        }

    }

    /**
     * @name: reportChair
     * @descripition: This method allows me to report defective chairs <br>
     * <b>pre: </b> matriz of chairs initialized  <br>
     * @param descripcion
     * @param fila
     * @param numSilla
     * <b>post: </b> chair report <br>
     * @return estado
     */
    public String reportChair(char fila, int numSilla, String descripcion) {

        String estado = "";

        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {

                if (sillas[i][j] != null) {
                    if (sillas[i][j].getFila() == fila && sillas[i][j].getNumeroSilla() == numSilla) {
                        sillas[i][j].setEstado(silla.DEFECTUOSA);
                        sillas[i][j].setDescripcion(descripcion);
                        estado = "La silla  " + sillas[i][j].getFila() + sillas[i][j].getNumeroSilla() + " fue encontrada DEFECTUOSA " + "por  " + sillas[i][j].getDescripcion();
                    }
                }

            }

        }

        return estado;
    }

    /**
     * @name: setChairsState
     * @descripition: This method analyzes and counts the defective and
     * operative chairs to throw a double, for its percentage <br>
     * <b>pre: </b> matriz of chairs initialized  <br>
     *
     */
    public void setChairsState() {

        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j] != null) {

                    cantSillasDisponibles++;

                }
            }
        }

        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j] != null && sillas[i][j].getEstado().equals(silla.DEFECTUOSA)) {

                    cantSillasDefectuosas++;

                }
            }
        }
    }

    /**
     * @name: porcentaje sillas defectuosas
     * @descripition: this method gives me a percentage of the defective chairs
     * over the ones in good condition <br>
     * <b>pre: </b> chairs array created <br>
     *
     *
     * <b>post: porcentaje de sillas defectuosas </b> <br>
     * @return (cantSillasDefectuosas / cantSillasDisponibles) * 100;
     */
    public double porcentajeSillasDefectuosas() {

        setChairsState();

        return (cantSillasDefectuosas / cantSillasDisponibles) * 100;
    }

    /**
     * @name: addEvent
     * @descripition: this method creates event  <br>
     * <b>pre: </b> the parameters entered, add the event to the
     * arraylist,validating your time, day, month and age <br>
     *
     * @param event
     *
     * <b>post: </b> msg and registered event<br>
     */
    public String addEvent(Event event) {

        String msg = "";

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getAnio() == events.get(i).getAnio()) {
                if (events.get(i).getMes() == events.get(i).getMes()) {
                    if (events.get(i).getDia() == events.get(i).getDia()) {
                        if ((events.get(i).getHorainicio() <= event.getHorainicio() && event.getHorainicio() <= events.get(i).getHorafinal())
                                || (events.get(i).getHorainicio() <= event.getHorafinal() && event.getHorafinal() <= events.get(i).getHorafinal())) {

                            msg = "Ya existe un evento asignado a este auditorio para esta fecha";

                            return msg;
                        }
                    }
                }
            }

        }
        int duracionEvento = event.getHorafinal() - event.getHorainicio();
        if (duracionEvento >= 2 && duracionEvento <= 12) {
            if (event.getHorainicio() >= 7 && event.getHorainicio() <= 20) {
                events.add(event);

                msg = " EVENTO REGISTRADO CON EXITO "
                        + "\n" + event.toString();
            } else {

                msg = "  NO SE PUEDEN REALIZAR RESERVAS DESDE ANTES DE LAS 7 AM Y DESPUES DE LAS 8 PM. ";
            }

        } else {

            msg = " LA DURACION DEL EVENTO TIENE QUE SER MAYOR A 2 HORAS Y MENOR A 12 HORAS";

        }

        return msg;
    }

}
