package es.ieslavereda.exercice1;

import es.ieslavereda.utils.Input;

/**
 * Ahora, crea una clase ejecutable, llamada PersonaTester, que haga lo siguiente:
 * •	Pide por teclado los datos necesarios para crear los objetos Personas, teniendo en cuenta que si introduce o no el DNI.
 *      Si no introduce el DNI, sólo pedirá nombre, apellidos y edad. Si lo introduce, pedirá todos los datos.
 * •	Crea un array de 6 objetos Persona para las pruebas, dándole los datos necesarios para realizar las pruebas más adecuadas.
 * •	Para cada objeto, deberá comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
 * •	Indicar para cada objeto si es mayor de edad.
 * •	Por último, mostrar la información de cada objeto.
 */

public class PersonaTester {

    public static void main(String[] args) {

        Persona[] personas = new Persona[6];
        for (int i = 0; i < personas.length; i++) {
            System.out.println("----------------------------------------------------------");
            String nombre = Input.getString("Introduce el nombre: ");
            String apellido = Input.getString("Introduce el apellido: ");
            int edad = Input.getInteger("Introduce la edad: ");

            String siDNI = Input.getString("Quieres introducir el DNI? (S para Sí, cualquier otro valor para No): ").toUpperCase();
            if (siDNI.equals("S")) {
                String DNI = Input.getString("Introduce el DNI: ");
                String sexo;
                Sexo sexo1;
                do {
                    sexo = Input.getString("Introduce el sexo: M para mujer, H para hombre, N si no quiere decirlo ").toUpperCase();
                } while(!sexo.equals("H") && !sexo.equals("M") && !sexo.equals("N"));
                if (sexo.equals("H"))
                    sexo1 = Sexo.H;
                else if (sexo.equals("M"))
                    sexo1 = Sexo.M;
                else
                    sexo1 = Sexo.N;
                double peso = Input.getDouble("Introduce el peso: ");
                double altura = Input.getDouble("Introduce la altura: ");
                personas[i] = new Persona(nombre, apellido, edad, DNI, sexo1, peso, altura);
            } else {
                personas[i] = new Persona(nombre, apellido, edad);
            }
        }

        for (Persona persona : personas) {
            int imc = persona.calcularIMC();
            System.out.println(" --------------------------------------------------------------------------------- ");
            String mensaje;
            if (persona.getPeso() > 0) {
                if (imc <0)
                    mensaje =  " está por debajo del peso";
                else if (imc == 0)
                    mensaje = " está en su peso ideal";
                else if (imc == 1)
                    mensaje = " tiene sobrepeso";
                else
                    mensaje = " tiene obesidad";
                System.out.println(persona.getNombre() + mensaje);
            }

            mensaje = (persona.esMayorDeEdad()) ? " es mayor de edad" : " es menor de edad";
            System.out.println(persona.getNombre() + mensaje);

            System.out.println(persona);

        }

    }
}
