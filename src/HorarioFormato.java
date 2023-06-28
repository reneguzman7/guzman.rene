import java.util.HashSet;

public class HorarioFormato {
    
    String rgNombreAlumno;
    String rgCodigo;
    String rgMateria;
    String rgParalelo;
    String rgAula;
    String rgCreditos;
    String rgObservacion;

    public String getRgNombreAlumno() {
        return rgNombreAlumno;
    }
    public void setRgNombreAlumno(String rgNombreAlumno) {
        this.rgNombreAlumno = rgNombreAlumno;
    }
    public String getRgCodigo() {
        return rgCodigo;
    }
    public void setRgCodigo(String rgCodigo) {
        this.rgCodigo = rgCodigo;
    }
    public String getRgMateria() {
        return rgMateria;
    }
    public void setRgMateria(String rgMateria) {
        this.rgMateria = rgMateria;
    }
    public String getRgParalelo() {
        return rgParalelo;
    }
    public void setRgParalelo(String rgParalelo) {
        this.rgParalelo = rgParalelo;
    }
    public String getRgAula() {
        return rgAula;
    }
    public void setRgAula(String rgAula) {
        this.rgAula = rgAula;
    }
    public String getRgCreditos() {
        return rgCreditos;
    }
    public void setRgCreditos(String rgCreditos) {
        this.rgCreditos = rgCreditos;
    }
    public String getRgObservacion() {
        return rgObservacion;
    }
    public void setRgObservacion(String rgObservacion) {
        this.rgObservacion = rgObservacion;
    }
    
    HashSet<String> rgHoraLunes = new HashSet<>();
    HashSet<String> rgHoraMartes = new HashSet<>();
    HashSet<String> rgHoraMiercoles = new HashSet<>();
    HashSet<String> rgHoraJueves = new HashSet<>();
    HashSet<String> rgHoraViernes = new HashSet<>();
    HashSet<String> rgHoraSabado = new HashSet<>();


    

}
