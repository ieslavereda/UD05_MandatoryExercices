package es.ieslavereda.exercice3;

public class BibliotecaTester {

    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("Carmelina Sánchez-Cutillas", "Benicalap-Valencia");
        Biblioteca b2 = new Biblioteca("Municipal La Pobla", "La Pobla de Vallbona");

        b1.anyadirLibro("Las modistas de Auschwitz", "Lucy Adlintony", 5);
        b1.anyadirLibro("La isla más remota del mundo", "Myriam Imedio", 5);
        b1.anyadirLibro("Roma soy yo", "Santiago Posteguillo", 5);
        b1.anyadirLibro("La cría", "Pablo Rivero", 5);
        b1.anyadirLibro("El Libro Negro de las Horas", "Eva García Saenz de Urturi", 5);

        b2.eliminarLibro("a");
        b2.eliminarLibro("cólera");
        b2.eliminarLibro("xavier");
        b2.eliminarLibro("20");

        b1.prestamo("amor");
        b1.prestamo("amor");
        b1.prestamo("amor");
        b1.prestamo("amor");
        b1.prestamo("xavier");
        b1.prestamo("Roma");

        System.out.println(b1);
        System.out.println(b2);
    }
}
