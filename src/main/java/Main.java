import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static BD bd = new BD();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //Para que no aprezca el texto rojo
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        bd = new BD();

        int opc1;
        int opc2 = 0;
        String tabla = "";


        do {
            System.out.println("""
                    Indique que seccion desea ver:
                    [1] Alumnos
                    [2] Profesores
                    [3] Matriculas
                    [4] Salir
                    """);

            opc1 = sc.nextInt();
            switch (opc1) {
                case 1:
                    tabla = "Alumnos";
                    break;
                case 2:
                    tabla = "Profesores";
                    break;
                case 3:
                    tabla = "Matricula";
                    break;
                case 4:
                    System.out.println("Bye bye~");
                    break;
                default:
                    System.out.println("Opcion no valida :[");
            }

            while (opc2 != 5) {
                System.out.println("""
                        Indique que desea hacer:
                        [1] Insertar
                        [2] Listar
                        [3] Actualizar
                        [4] Borrar
                        [5] Salir
                            """);

                opc2 = sc.nextInt();
                switch (opc2) {
                    case 1:
                        menuInsertar(opc1);
                        break;
                    case 2:
                        menuListar(opc1);
                        break;
                    case 3:
                        menuActualizar(opc1);
                        break;
                    case 4:
                        menuBorrar(opc1);
                        break;
                    case 5:
                        System.out.println("Bye bye~");
                        break;
                    default:
                        System.out.println("Opcion no valida :[");
                }
            }


        } while (opc1 != 4);
    }

    //Metodos insertar

    private static void menuInsertar(int tabla) throws Exception {
        switch (tabla) {
            case 1 -> insertarAlumnos();
            case 2 -> insertarProfesor();
            case 3 -> insertarMatricula();
        }
    }

    private static void insertarAlumnos() {
        int id;
        String nombre, apellidos, fechaNac;
        System.out.println("Indique el id del alumno: ");
        id = sc.nextInt();
        System.out.println("Indique el nombre del alumno: ");
        nombre = sc.next();
        System.out.println("Indique los apellidos del alumno: ");
        apellidos = sc.next();
        System.out.println("Indique la fecha de nacimiento del alumno: ");
        fechaNac = sc.next();

        bd.insertarAlumno(new Alumnos(id, nombre, apellidos, fechaNac));
    }

    private static void insertarProfesor() {

        int id, antiguedad;
        String nombre, apellidos, fechaNac;
        System.out.println("Indique el id del profesor: ");
        id = sc.nextInt();
        System.out.println("Indique el nombre del profesor: ");
        nombre = sc.next();
        System.out.println("Indique los apellidos del profesor: ");
        apellidos = sc.next();
        System.out.println("Indique la fecha de nacimiento del profesor: ");
        fechaNac = sc.next();
        System.out.println("Indique la antiguedad del profesor: ");
        antiguedad = sc.nextInt();

        bd.insertarProfesores(new Profesores(id, nombre, apellidos, fechaNac, antiguedad));
    }

    private static void insertarMatricula() {

        int id, curso, idAlumno, idProfe;
        String asignatura;
        System.out.println("Indique el id de matricula: ");
        id = sc.nextInt();
        System.out.println("Indique la asignatura del alumno: ");
        asignatura = sc.next();
        System.out.println("Indique el curso del alumno");
        curso = sc.nextInt();
        System.out.println("Indique el id del alumno: ");
        idAlumno = sc.nextInt();
        Alumnos alumnos = bd.leerAlumnos(idAlumno);
        System.out.println("Indique el id del profesor: ");
        idProfe = sc.nextInt();
        Profesores profesores = bd.leerProfesores(idProfe);

        Matricula matricula = new Matricula(id, asignatura, curso, alumnos, profesores);
        bd.insertarMatricula(matricula);
    }

    //Metodos listar

    private static void menuListar(int tabla) {
        switch (tabla) {
            case 1 -> bd.listaAlumnos();
            case 2 -> bd.listaProfes();
            case 3 -> bd.listaMatricula();
        }
    }

    //Metodos actualizar

    private static void menuActualizar(int tabla) throws Exception {
        switch (tabla) {
            case 1 -> actualizarAlumnos();
            case 2 -> actualizarProfesor();
            case 3 -> actualizarMatricula();
        }
    }

    private static void actualizarAlumnos() throws Exception {
        bd.abrir();
        System.out.println("Introduzca el id del alumno que desea modificar: ");
        Alumnos alumno = bd.leerAlumnos(sc.nextInt());

        if (alumno != null) {
            System.out.println("Introduzca el nombre del alumno");
            alumno.setNombre(sc.next());
            System.out.println("Introduzca el apellido del alumno: ");
            alumno.setApellidos(sc.next());
            System.out.println("Indique la fecha de nacimiento del alumno: ");
            alumno.setFechaNac(sc.next());
            bd.cerrar();

            bd.insertarAlumno(alumno);
        } else {
            System.out.println("El id del alumno no existe");
        }


    }

    private static void actualizarProfesor() throws Exception {
        bd.abrir();
        System.out.println("Introduzca el id del profesor que desea modificar: ");
        Profesores profesores = bd.leerProfesores(sc.nextInt());

        if (profesores != null) {
            System.out.println("Introduzca el nombre del profesor");
            profesores.setNombre(sc.next());
            System.out.println("Introduzca el apellido del profesor: ");
            profesores.setApellidos(sc.next());
            System.out.println("Indique la fecha de nacimiento del profesor: ");
            profesores.setFechaNac(sc.next());
            System.out.println("Indique la antiguedad del profesor: ");
            profesores.setAntiguedad(sc.nextInt());

            bd.cerrar();
            bd.insertarProfesores(profesores);
        } else {
            System.out.println("El id del profesor no existe");
        }

    }

    private static void actualizarMatricula() throws Exception {
        bd.abrir();
        System.out.println("Introduzca el id de la matricula que desea modificar: ");
        Matricula matricula = bd.leerMatriculas(sc.nextInt());
        Alumnos alumnos = bd.leerAlumnos(sc.nextInt());
        Profesores profesores = bd.leerProfesores(sc.nextInt());

        if (matricula != null) {
            System.out.println("Introduzca la asignatura");
            matricula.setAsignatura(sc.next());
            System.out.println("Introduzca el curso");
            matricula.setCurso(sc.nextInt());
            System.out.println("Introduzca el id del alumno: ");
            matricula.setAlumnos(alumnos);
            System.out.println("Indique el id del profesor: ");
            matricula.setProfesores(profesores);

            bd.cerrar();
            bd.insertarMatricula(matricula);
        } else {
            System.out.println("El id de la matricula no existe");
        }
    }

    //Metodos borrar

    private static void menuBorrar(int tabla) throws Exception {
        switch (tabla) {
            case 1 -> borrarAlumnos();
            case 2 -> borrarProfesores();
            case 3 -> borrarMatricula();
        }
    }

    private static void borrarAlumnos() throws Exception {
        bd.abrir();
        System.out.println("Introduzca el id del alumno a borrar");
        Alumnos alumnos = bd.leerAlumnos(sc.nextInt());
        bd.cerrar();
        bd.borrarAlumno(alumnos);
    }

    private static void borrarProfesores() throws Exception {
        bd.abrir();
        System.out.println("Introduzca el id del profesor a borrar");
        Profesores profesores = bd.leerProfesores(sc.nextInt());
        bd.cerrar();
        bd.borrarProfesor(profesores);

    }

    private static void borrarMatricula() throws Exception {
        bd.abrir();
        System.out.println("Introduzca el id de la matricula a borrar");
        Matricula matricula = bd.leerMatriculas(sc.nextInt());
        bd.cerrar();
        bd.borrarMatricula(matricula);
    }


}



