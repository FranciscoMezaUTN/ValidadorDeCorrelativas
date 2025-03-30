package Inscripcion;

import java.util.List;
import Materia.Materia;
import Alumno.Alumno;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada(){
        return !materias.stream().anyMatch(materia -> !materia.cumpleCorrelativas(this.alumno));
    }
}
