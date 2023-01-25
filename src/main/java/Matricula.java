import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Matricula")
public class Matricula implements Serializable {

    @Id
    @Column(name = "idMatricula")
    private int idMatricula;

    @Column(name = "asignatura")
    private String asignatura;

    @Column(name = "curso")
    private int curso;

    @ManyToOne
    @JoinColumn(name = "idAlum")
    private Alumnos alumnos;

    @ManyToOne
    @JoinColumn (name = "idProfesor")
    private Profesores profesores;

    public Matricula(int idMatricula, String asignatura, int curso, Alumnos alumnos, Profesores profesores){
        setIdMatricula(idMatricula);
        setAsignatura(asignatura);
        setCurso(curso);
        setAlumnos(alumnos);
        setProfesores(profesores);
    }

    public Matricula() {
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }
}