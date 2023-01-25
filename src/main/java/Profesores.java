import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Profesores")
public class Profesores implements Serializable {

    @Id
    @Column(name = "idProfesor")
    private int idProfesor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fechaNac")
    private String fechaNac;

    @Column(name = "antiguedad")
    private int antiguedad;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idProfesor")
    private List<Matricula> matriculas;

    public Profesores() {
    }

    public Profesores(int idProfesor, String nombre, String apellidos, String fechaNac, int antiguedad) {
        setIdProfesor(idProfesor);
        setNombre(nombre);
        setApellidos(apellidos);
        setFechaNac(fechaNac);
        setAntiguedad(antiguedad);
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
