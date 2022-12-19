/**
 *     La clase estará compuesta por un array de 100 libros.
 *     Las bibliotecas tienen un nombre y un barrio o población donde están localizados.
 */
package es.ieslavereda.exercice3;

public class Biblioteca {
    private String nombre;
    private String localizacion;
    private Libro[] libros;
    private int numLibros;

    public Biblioteca(String nombre, String localizacion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        libros = new Libro[100];

        String[][] librosBasicos = {{"Don Quijote de la Mancha", "Miguel de Cervantes Saavedra"},
            {"Cien años de soledad", "Gabriel García Márquez"},
            {"El alquimista", "Paulo Coehlo"},
            {"20 poemas de amor y una canción desesperada", "Pablo Neruda"},
            {"La ciudad y los perros", "Mario Vargas Llosa"},
            {"La casa de los espíritus","Isabel Allende"},
            {"Desolación", "Gabriela Mistral"},
            {"Rayuela", "Julio Cortázar"},
            {"El Aleph", "Jorge Luis Borges"},
            {"El amor en los tiempos del cólera","Gabriel García Márquez"}
            };

        for (int i = 0; i < librosBasicos.length; i++) {
            libros[i] = new Libro(librosBasicos[i][0],librosBasicos[i][1],3);
            numLibros++;
        }
    }

    public String getNombre() {
        return nombre;
    }
    public String getLocalizacion() {
        return localizacion;
    }
    public Libro[] getLibros() {
        return libros;
    }
    public int getNumLibros() {
        return numLibros;
    }

    /**
     * Método para recuperar un libro por parte de su título
     * @param titulo parte del título
     * @return Devolverá la posición del libro en el array si existe, y –1 si no existe.
     */
    public int infoLibro(String titulo) {
        int i = 0;
        while(i<numLibros) {
            if (libros[i].getTitulo().contains(titulo))
                return i;
            i++;
        }
        return -1;
    }

    /**
     *  Método para añadir un nuevo libro a la Biblioteca, junto con el número de ejemplares que tendrá
     *  ese nuevo libro. No se podrán añadir ejemplares si la biblioteca está llena de libros.
     * @param titulo título del libro
     * @param autor autor del libro
     * @param numEjemplares número de ejemplares del libro
     * @return Devuelve true si se ha podido realizar la operación y false en caso contrario.
     */
    public boolean anyadirLibro(String titulo, String autor, int numEjemplares){
        if(numLibros < libros.length-1) {
            libros[numLibros++] = new Libro(titulo,autor,numEjemplares);
            return true;
        }
        return false;
    }

    /**
     * Método para eliminar un libro (todos los ejemplares) de una biblioteca a partir de parte de su título.
     * Eliminará el primer libro que encuentre que cumpla las condiciones.
     * Una vez eliminado, moverá todos los elementos del array a una posición menos para no tener huecos.
     * @param titulo parte del título del libro a eliminar
     * @return  Devuelve true si se ha podido realizar la operación y false en caso contrario.
     */
    public boolean eliminarLibro(String titulo) {
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i<numLibros) {
            if (libros[i].getTitulo().contains(titulo)) {
                encontrado = true;
                libros[i] = null;
                reordenar(i,numLibros);
                numLibros--;
                return true;
            }
            i++;
        }
        return false;
    }

    private void reordenar(int i, int j) {
        for (int k = i; k < j; k++) {
            libros[k] = libros[k+1];
        }
        if (j<libros.length-1)
            libros[j] = libros[j+1];
    }

    /**
     * Método préstamo para la biblioteca, que presta un libro si hay libros disponibles y existe.
     * @return Devuelve true si se ha podido realizar la operación y false en caso contrario
     */
    public boolean prestamo(String titulo) {
        int numLibro = infoLibro(titulo);
        if (numLibro > -1)
            if (libros[numLibro].prestamo())
                return true;
        return false;
    }

    /**
     * Método devolución para la biblioteca, que devuelve un libro si existe.
     * @return Devuelve true si se ha podido realizar la operación y false en caso contrario.
     */
    public boolean devolucion(String titulo) {
        int numLibro = infoLibro(titulo);
        if (numLibro>-1)
            if (libros[numLibro].devolucion())
            return true;
        return false;
    }

    @Override
    public String toString() {
        String cadena = "Nombre de la biblioteca: " + nombre + " localidad o barrio: " + localizacion + "\n";
        for (int i = 0; i < numLibros; i++) {
            cadena += libros[i].toString();
        }
        return cadena;
    }


}
