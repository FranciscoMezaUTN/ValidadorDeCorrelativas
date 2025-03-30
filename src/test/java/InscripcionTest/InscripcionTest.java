package InscripcionTest;

import Alumno.Alumno;
import Materia.Materia;
import Inscripcion.Inscripcion;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class InscripcionTest {
    List<Materia> sinMaterias = new ArrayList<>();
    Materia AGA = new Materia("Algebra", sinMaterias);
    Materia AM1 = new Materia("Analisis Matematico 1", sinMaterias);
    Materia IT1 = new Materia("Ingles Tecnico 1", sinMaterias);
    List<Materia> correlativasIT2  = List.of(IT1);
    Materia IT2 = new Materia("Ingles Tecnico 2", correlativasIT2);
    List<Materia> correlativasAM2  = List.of(AGA, AM1);
    Materia AM2 = new Materia("Analisis Matematico 2", correlativasAM2);
    List<Materia> correlativasMS  = List.of(AM2);
    Materia MS = new Materia("Matematica Superior", correlativasMS);


    @Test
    public void alumnoSinMateriasAprobadasACEPTADO(){
        Alumno ingresante = new Alumno(123, sinMaterias);
        List<Materia> materiasAInscribir  = List.of(AM1);
        Inscripcion inscripcion1 = new Inscripcion(ingresante, materiasAInscribir);

        Assert.assertEquals(true, inscripcion1.aprobada());
    }

    @Test
    public void alumnoSinMateriasAprobadasRECHAZADO(){
        Alumno ingresante = new Alumno(123, sinMaterias);
        List<Materia> materiasAInscribir  = List.of(AM2);
        Inscripcion inscripcion = new Inscripcion(ingresante, materiasAInscribir);

        Assert.assertEquals(false, inscripcion.aprobada());
    }

    @Test
    public void alumnoConMateriasAprobadasACEPTADO(){
        List<Materia> materiasAprobadas  = List.of(AGA, AM1, AM2);
        Alumno recursante = new Alumno(321, materiasAprobadas);
        List<Materia> materiasAInscribir  = List.of(MS, IT1);
        Inscripcion inscripcion = new Inscripcion(recursante, materiasAInscribir);

        Assert.assertEquals(true, inscripcion.aprobada());
    }
    @Test
    public void alumnoConMateriasAprobadasRechazado(){
        List<Materia> materiasAprobadas  = List.of(AGA, AM1, AM2);
        Alumno recursante = new Alumno(213, materiasAprobadas);
        List<Materia> materiasAInscribir  = List.of(MS, IT2);
        Inscripcion inscripcion = new Inscripcion(recursante, materiasAInscribir);

        Assert.assertEquals(false, inscripcion.aprobada());
    }
}
