package Materia;

import java.util.List;
import Alumno.Alumno;
import lombok.Getter;
import java.util.stream.Collectors;

@Getter
public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public boolean cumpleCorrelativas(Alumno alumno){
        return alumno.getMateriasAprobadas().stream().
                map(materia -> materia.getNombre()).collect(Collectors.toList()).
                containsAll(this.correlativas.stream().
                        map(materia -> materia.getNombre()).collect(Collectors.toList()));
    }
}
