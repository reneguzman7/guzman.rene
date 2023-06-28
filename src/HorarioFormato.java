import java.util.HashSet;

public class HorarioFormato {
    
    String rgNombreAlumno;
    String rgCodigo;
    String rgMateria;
    String rgParalelo;
    String rgAula;
    String rgCreditos;
    String rgObservacion;

    HashSet<String> rgHoraLunes = new HashSet<>();
    HashSet<String> rgHoraMartes = new HashSet<>();
    HashSet<String> rgHoraMiercoles = new HashSet<>();
    HashSet<String> rgHoraJueves = new HashSet<>();
    HashSet<String> rgHoraViernes = new HashSet<>();
    HashSet<String> rgHoraSabado = new HashSet<>();

    
    public String[] separar(String rgCadena) {
        String[] rgStrSeparado = rgCadena.split(",");
        return rgStrSeparado;
    }

    
  
    
    


    

}
