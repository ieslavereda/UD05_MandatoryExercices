package es.ieslavereda.exercice1;

/**
 * Clase Enum para el sexo, con valores Hombre, Mujer y No, si no quiere decirlo
 */
public enum Sexo {
    N("No"),
    H("Hombre"),
    M("Mujer");

    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }
}
