package ui;

import java.util.Scanner;
import model.Event;
import model.auditorium;
import model.university;

/**
 *
 * @author user
 */
public class main {

    private static university university = new university("ICESI");
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {

            int option = 0;

            System.out.println("---------------- MANEJO DE AUDITORIOS ICESI --------------------");
            System.out.println("\n"
                    + "\n 1. CREAR AUDITORIO y SILLAS"
                    + "\n 2. CREAR EVENTO"
                    + "\n 3. REPORTAR SILLA DEFECTUOSA"
                    + "\n 4. PORCENTAJE DEFECTUOSA "
                    + "\n 5. IMPRIMIR ESTADO AUDITORIO"
                    + "\n 6. INICIAR EVENTO"
                    + "\n 7. CERRAR EVENTO"
                    + "\n");
            option = read.nextInt();

            switch (option) {

                case 1:
                    String nombre;
                    String ubicacion;
                    String estado = auditorium.DISPONIBLE;
                    int sillas;

                    System.out.println("Ingrese el nombre del auditorio : ");
                    nombre = read.next();
                    System.out.println("Ingrese la ubicacion  : ");
                    ubicacion = read.next();
                    System.out.println("Ingrese el numero de filas : ");
                    sillas = read.nextInt();
                    int[] cantSillas = new int[sillas];
                    for (int i = 0; i < cantSillas.length; i++) {
                        System.out.println("Ingrese Cuantas sillas hay en la fila : " + (i + 1) + "\n");
                        cantSillas[i] = read.nextInt();
                    }

                    university.createAuditorium(nombre, ubicacion, estado, cantSillas);

                    System.out.println("\n" + "Auditorio : " + nombre + "  creado con exito ");
                    break;

                case 2:

                    System.out.println("Indique el numero de auditorio en que quiera realizar el evento: "
                            + "\n");
                    int auditorioEvento;

                    for (int i = 0; i < university.getAuditoriums().length; i++) {

                        if (university.getAuditoriums()[i] != null) {
                            System.out.println(i + ". " + university.getAuditoriums()[i].getNombre());
                        }

                    }
                    auditorioEvento = read.nextInt();
                    auditorium a3 = university.audit(auditorioEvento); // DEVUELVE AUDITORIO EN UNA POSICION

                    System.out.println("Ingrese nombre evento: ");

                    String nombreEvento = read.next();
                    System.out.println("Ingrese dia (1 a 31 dependiendo del mes): ");
                    int dia = read.nextInt();
                    System.out.println("Ingrese mes: (1 a 12 )");
                    int mes = read.nextInt();
                    System.out.println("Ingrese año: ");
                    int anio = read.nextInt();
                    System.out.println("Ingrese hora inicio del evento en formato 24 horas:  ");
                    int horainicio = read.nextInt();
                    System.out.println("Ingrese hora final del evento en formato 24 horas: ");
                    int horafinal = read.nextInt();
                    System.out.println("Ingrese Profesor encargado: ");
                    String ProfesorEncargado = read.next();
                    System.out.println("Ingrese Facultad encargado: ");
                    String facultad = read.next();
                    System.out.println("Ingrese cantidad de personas : ");
                    int cantidadDePersonas = read.nextInt();

                    Event e = new Event(nombreEvento, dia, mes, anio, horainicio, horafinal, ProfesorEncargado, facultad, cantidadDePersonas);

                    System.out.println(university.addEvent(e, a3));
                    break;
                case 3:

                    char fila;
                    int numSilla;
                    String descripcion;
                    System.out.println("Indique el numero de auditorio que quiera reportarle sillas defectuosas: "
                            + "\n");
                    int auditorio;

                    for (int i = 0; i < university.getAuditoriums().length; i++) {

                        if (university.getAuditoriums()[i] != null) {
                            System.out.println(i + ". " + university.getAuditoriums()[i].getNombre());
                        }

                    }
                    auditorio = read.nextInt();
                    auditorium a = university.audit(auditorio);
                    System.out.println("REPORTE SILLA DEFECTUOSA");
                    System.out.println("INGRSE FILA : (LETRA EN MAYUSCULA)");
                    fila = read.next().charAt(0);
                    System.out.println("INGRSE EL NUMERO DE SILLA : ");
                    numSilla = read.nextInt();
                    System.out.println("INGRESE DESCRIPCION SILLA:");
                    descripcion = read.next();

                    System.out.println(a.reportChair(fila, numSilla, descripcion));

                    break;

                case 4:
                    System.out.println("Indique el numero de auditorio de donde desea conocer el procentaje de sillas defectuosas: " + "\n");

                    for (int i = 0; i < university.getAuditoriums().length; i++) {

                        if (university.getAuditoriums()[i] != null) {
                            System.out.println(i + ". " + university.getAuditoriums()[i].getNombre());
                        }

                    }
                    auditorio = read.nextInt();
                    auditorium a2 = university.audit(auditorio);

                    System.out.println("porcentaje silla defectuosas es de: " + a2.porcentajeSillasDefectuosas() + " % ");
                    break;

                case 5:

                    System.out.println("Indique el numero del cual quiere imprimir su estado: " + "\n");

                    for (int i = 0; i < university.getAuditoriums().length; i++) {

                        if (university.getAuditoriums()[i] != null) {
                            System.out.println(i + ". " + university.getAuditoriums()[i].getNombre());
                        }

                    }
                    auditorio = read.nextInt();
                    university.printStateAuditurium(auditorio);
                    break;

                case 6:

                    System.out.println("Indique el numero de auditorio en que quiera iniciar el evento: ");
                    int eventoAuditorio;

                    for (int i = 0; i < university.getAuditoriums().length; i++) {

                        if (university.getAuditoriums()[i] != null) {
                            System.out.println(i + ". " + university.getAuditoriums()[i].getNombre());
                        }

                    }
                    eventoAuditorio = read.nextInt();
                    auditorium a4 = university.audit(eventoAuditorio);

                    System.out.println("Indique el numero de evento que quiera iniciar : ");
                    int inicioEvento;

                    for (int i = 0; i < a4.getEvents().size(); i++) {
                        System.out.println(i + " . " + a4.getEvents().get(i));

                    }

                    inicioEvento = read.nextInt();
                    Event event1 = university.event(inicioEvento, a4);

                    System.out.println(a4.initEvent(event1));

                    break;

                case 7:

                    System.out.println("Indique el numero de auditorio en que quiera cerrar el evento : ");
                    int cerrarEvento;

                    for (int i = 0; i < university.getAuditoriums().length; i++) {

                        if (university.getAuditoriums()[i] != null) {
                            System.out.println(i + ". " + university.getAuditoriums()[i].getNombre());
                        }

                    }
                    cerrarEvento = read.nextInt();
                    auditorium a5 = university.audit(cerrarEvento);

                    System.out.println("Indique el numero de evento que quiera cerrar : ");
                    int finEvento;

                    for (int i = 0; i < a5.getEvents().size(); i++) {
                        System.out.println(i + " . " + a5.getEvents().get(i));

                    }

                    finEvento = read.nextInt();
                    Event event2 = university.event(finEvento, a5);

                    System.out.println(a5.closeEvent(event2));

                    break;

            }
        }

    }

}
