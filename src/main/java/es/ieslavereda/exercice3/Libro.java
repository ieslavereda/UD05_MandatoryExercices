/**
 * Crea una clase llamada Libro que guarde información de cada uno de los libros de una biblioteca:
 * La clase debe guardar el título, autor, número de ejemplares del libro y número de ejemplares prestados.
 */

package es.ieslavereda.exercice3;

public class Libro {
    private String titulo;
    private String autor;
    private int numEjemplares;
    private int numPrestados;

    public Libro(String titulo, String autor, int numEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numEjemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public int getNumPrestados() {
        return numPrestados;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    /**
     * Método préstamo que incremente el atributo correspondiente cada vez que se realice un préstamo del libro.
     * No se podrán prestar libros de los que no queden ejemplares disponibles para prestar.
     * @return Devuelve true si se ha podido realizar la operación y false en caso contrario
     */
    public boolean prestamo() {
        if((numEjemplares-numPrestados) > 0) {
            numPrestados++;
            return true;
        }
        return false;
    }

    /**
     * Método devolución que decremente el atributo correspondiente cuando se produzca la devolución de un libro.
     * No se podrán devolver libros que no se hayan prestado.
     * @return Devuelve true si se ha podido realizar la operación y false en caso contrario.
     */
    public boolean devolucion() {
        if (numPrestados>0) {
            numPrestados--;
            return true;
        }
        return false;
    }

    /**
     * Método toString para mostrar los datos de los libros. 
     * @return los datos del libro
     */
    @Override
    public String toString() {
        return "Titulo: " + titulo + " autor: " + autor +
                "\n número de ejemplares: " + numEjemplares + " y de ellos " + numPrestados + " prestados \n";
    }
}
