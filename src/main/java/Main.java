import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static AccesoBD instancia;
    private static Alumnos alumnos;
    private static Profesores profesores;
    private static Matricula matricula;
    private static List<Matricula> listaMatriculas;
    private static Scanner sc = new Scanner(System.in);

    /*
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private static EntityManager entity = entityManagerFactory.createEntityManager();
*/

    public static void main(String[] args) throws Exception {
        instancia=new AccesoBD();

        int opc = 0;



        while (opc != 7){
            System.out.println("""
                    Indique que desea hacer:
                    [1] Insertar alumno
                    [2] Insertar profesor
                    [3] Insertar matricula
                    [4] Buscar
                    [5] Actualizar
                    [6] Eliminar
                    [7] Salir
                    """);

            opc = sc.nextInt();
            switch (opc){
                case 1:
                    insertarAlumnos();
                    break;
                case 2:
                    insertarProfesor();
                    break;
                case 3:
                    insertarMatricula();
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Bye bye~");
                    break;
            }
        }



    }

    private static void guardar(Object cosa) throws Exception {
        instancia.abrir();
        int id = (int) instancia.guardar(cosa);
        System.out.println(id);
        instancia.cerrar();
    }

    private static void insertarAlumnos() throws Exception{
        alumnos = new Alumnos();
        System.out.println("Indique el id del alumno: ");
        alumnos.setIdAlum(sc.nextInt());
        System.out.println("Indique el nombre del alumno: ");
        alumnos.setNombre(sc.next());
        System.out.println("Indique los apellidos del alumno: ");
        alumnos.setApellidos(sc.next());
        System.out.println("Indique la fecha de nacimiento del alumno: ");
        alumnos.setFechaNac(sc.next());

        alumnos.setMatriculas(listaMatriculas);
        guardar(alumnos);

    }

    private static void insertarProfesor() throws Exception{

        profesores = new Profesores();
        System.out.println("Indique el id del profesor: ");
        profesores.setIdProfesor(sc.nextInt());
        System.out.println("Indique el nombre del profesor: ");
        profesores.setNombre(sc.next());
        System.out.println("Indique los apellidos del profesor: ");
        profesores.setApellidos(sc.next());
        System.out.println("Indique la fecha de nacimiento del profesor: ");
        profesores.setFechaNac(sc.next());
        System.out.println("Indique la antiguedad del profesor: ");
        profesores.setAntiguedad(sc.nextInt());

        profesores.setMatriculas(listaMatriculas);
        guardar(profesores);
    }

    private static void insertarMatricula(){

        System.out.println("Indique el id de matricula: ");
        matricula.setIdMatricula(sc.nextInt());
        System.out.println("Indique la asignatura del alumno: ");
        matricula.setAsignatura(sc.next());
        System.out.println("Indique el curso del alumno");
        matricula.setCurso(sc.nextInt());

        listaMatriculas.add(new Matricula(matricula.getIdMatricula(), matricula.getAsignatura(), matricula.getCurso(), alumnos, profesores));

    }


    private static void buscar() throws Exception{
        int opc;
        System.out.println("""
                Indique que desea buscar:
                [1] ALumno
                [2] Profesor
                """);
        opc = sc.nextInt();

        /*
        switch (opc){
            case 1:
                System.out.println("Indique el id del alumno que desea buscar: ");
                alumnos=new Alumnos();
                alumnos = entity.find(Alumnos.class, sc.nextInt());
                if (alumnos != null){
                    System.out.println(alumnos);
                    System.out.println();
                }else {
                    System.out.println("Alumno no encontrado");
                }
            case 2:
                System.out.println("Indique el id del profesor que desea buscar: ");
                profesores=new Profesores();
                profesores = entity.find(Profesores.class, sc.nextInt());
                if (profesores != null){
                    System.out.println(profesores);
                    System.out.println();
                }else {
                    System.out.println("Profesor no encontrado");
                }

        }*/

    }


}
