package Alumno;

import java.util.List;
import Materia.Materia;
import lombok.Getter;

@Getter
public class Alumno {
    private Integer legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(Integer legajo, List<Materia> materiasAprobadas) {
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }
}
