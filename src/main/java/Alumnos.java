import javax.persistence.*;
import java.io.Serializable;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Entity
@Table (name="Alumnos")
@NamedQuery(name = "listaALumnado", query = "from Alumnos p")

public class Alumnos implements Serializable {

    @Id
    @Column(name = "idAlum")
    private int idAlum;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellidos")
    private String apellidos;

    @Column (name = "fechaNac")
    private String fechaNac;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idAlum")
    private List<Matricula> matriculas;

    public Alumnos() {
    }

    public Alumnos(int idAlum, String nombre, String apellidos, String fechaNac) {
        setIdAlum(idAlum);
        setNombre(nombre);
        setApellidos(apellidos);
        setFechaNac(fechaNac);
    }

    public int getIdAlum() {
        return idAlum;
    }

    public void setIdAlum(int idAlum) {
        this.idAlum = idAlum;
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

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
