import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class BD {
    private SessionFactory sf;
    private Session sesion;
    private Transaction transaction;

    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sf = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void abrir() throws Exception {
        setUp();
        sesion=sf.openSession();
        transaction = sesion.beginTransaction();
    }

    public void cerrar(){
        try {
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
        sf.close();
    }

    public Object guardar(Object cosa) {
        return sesion.save(cosa);
    }

    //METODOS DE ALUMNOS

    public Alumnos leerAlumnos(int idAlum){
        Alumnos alumno = null;
        try{
            alumno = sesion.get(Alumnos.class, idAlum);
        }catch (Exception ex){
            System.out.println("Error al leer el alumno!");
        }
        return alumno;
    }

    public void insertarAlumno(Alumnos alumnos){
        try {
            abrir();
            sesion.persist(alumnos);
            cerrar();
        } catch (Exception e) {
            System.out.println("Lo sentimos, ha habido un fallo al insertar el alumno");
        }
    }

    public void listaAlumnos() {
        try {
            abrir();
            List <Alumnos> listaAlum = sesion.getNamedQuery("listaALumnado").getResultList();

            for (int i = 0; i < listaAlum.size(); i++) {
                System.out.println(listaAlum.get(i).getNombre());
            }

            cerrar();

        } catch (Exception e) {
            System.out.println("Error al leer los alumnos!");
        }
    }

    public void borrarAlumno(Alumnos alumnos){
        try{
            abrir();
            sesion.remove(alumnos);
            cerrar();
        } catch (Exception e) {
            System.out.println("Lo sentimos, ha habido un fallo al borra el alumno");
        }

    }

    //METODOS DE PROFESORES

    public Profesores leerProfesores(int idProfes){
        Profesores profesores = null;
        try{
            profesores = sesion.get(Profesores.class, idProfes);
        }catch (Exception ex){
            System.out.println("Error al leer el profesor!");
        }
        return profesores;
    }

    public void insertarProfesores(Profesores profesores){
        try {
            abrir();
            sesion.persist(profesores);
            cerrar();
        } catch (Exception e) {
            System.out.println("Lo sentimos, ha habido un fallo al insertar el profesor");
        }
    }

    public void listaProfes() {
        try {
            abrir();
            List <Profesores > listaProfesores = sesion.getNamedQuery("listaDocente").getResultList();

            for (int i = 0; i < listaProfesores.size(); i++) {
                System.out.println(listaProfesores.get(i).getNombre());
            }

            cerrar();
        } catch (Exception e) {
            System.out.println("Error al leer los alumnos!");
        }
    }

    public void borrarProfesor(Profesores profesores){
        try{
            abrir();

            cerrar();
        } catch (Exception e) {
            System.out.println("Lo sentimos, ha habido un fallo al borra el profesor");
        }

    }

    //METODOS DE MATRICULA

    public Matricula leerMatriculas(int idMatricula){
        Matricula matricula = null;
        try{
            matricula = sesion.get(Matricula.class, idMatricula);
        }catch (Exception ex){
            System.out.println("Error al leer la matricula!");
        }
        return matricula;
    }

    public void insertarMatricula(Matricula matricula){
        try {
            abrir();
            sesion.persist(matricula);
            cerrar();
        } catch (Exception e) {
            System.out.println("Lo sentimos, ha habido un fallo al insertar la matricula");
        }
    }

    public void listaMatricula() {

        try {
            abrir();
            List<Matricula> listaMatriculas = sesion.getNamedQuery("listaMatriculas").getResultList();
            cerrar();
        } catch (Exception e) {
            System.out.println("Error al leer las matriculas!");
        }
    }

    public void borrarMatricula(Matricula matricula){
        try{
            abrir();
            sesion.remove(matricula);
            cerrar();
        } catch (Exception e) {
            System.out.println("Lo sentimos, ha habido un fallo al borra la matricula");
        }

    }

}

