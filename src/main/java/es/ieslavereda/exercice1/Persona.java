package es.ieslavereda.exercice1;
/**
 * 1) Haz una clase llamada Persona que siga las siguientes condiciones:
 * •	Sus atributos son: nombre, apellidos, edad, DNI, sexo, peso (en kilos) y altura (en metros).
 *      No queremos que se accedan directamente a ellos. Piensa que modificador de acceso es el más adecuado, también su tipo.
 * •	Por defecto, todos los atributos menos el DNI, sexo, peso y altura serán valores que se deban introducir cuando se construye el objeto.
 *      Sexo será No por defecto. Por ello, se implantarán dos constructores:
 *      	Un constructor con el nombre, apellidos y edad.
 *      	Un constructor con todos los atributos como parámetro.
 * •	Los métodos que se implementaran son:
 *      	calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2  en metros)), devuelve un -1 si está por debajo de su peso ideal,
 *      un 0 si está en su peso ideal, un 1 si tiene sobrepeso y 2 si es obeso. Te recomiendo que uses constantes para devolver estos valores.
 *          Bajo peso (IMC <18,5)
 *          Rango normal (IMC = 18,5-24,99)
 *          Sobrepeso (IMC = 25-29,99)
 *          Obeso (IMC >= 30,00)
 * 	esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
 * 	toString(): devuelve toda la información del objeto.
 * 	generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente.
 *      Este método será invocado cuando se construya el objeto. Puedes dividir el método para que te sea más fácil. No será visible al exterior.
 * 	Métodos setters y getters de cada parámetro que se necesite.

 */

public class Persona {

    private static final int BAJOPESO = -1;
    private static final int PESOIDEAL = 0;
    private static final int SOBREPESO = 1;
    private static final int OBESO = 2;

    private String nombre;
    private String apellido;
    private int edad;
    private String DNI;
    private Sexo sexo;
    private double peso;
    private double altura;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = generaDNI();
        this.sexo = Sexo.N;
    }

    public Persona(String nombre, String apellido, int edad, String DNI, Sexo sexo, double peso, double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    /**
     * Genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente.
     * @return el DNI en formato cadena
     */
    private String generaDNI() {
        int numero = (int)(Math.random()*100000000)+1;
        char[] letters = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        return String.valueOf(numero)+letters[numero%23];
    }

    /**
     * Calcula el IMC para la persona. Calculará si la persona está en su peso ideal (peso en kg/(altura^2  en metros)), devuelve un -1 si está por debajo de su peso ideal,
     *  un 0 si está en su peso ideal, un 1 si tiene sobrepeso y 2 si es obeso.
     * @return integer con el estado en relación con el peso de la persona
     */
    public int calcularIMC(){
        double imc = peso / Math.pow(altura,2);
        if (imc < 18.5)
            return BAJOPESO;
        else if (imc>=18.5 && imc < 25)
            return PESOIDEAL;
        else if (imc>=25 && imc < 30)
            return SOBREPESO;
        return OBESO;
    }

    /**
     * Indica si es mayor de edad
     * @return devuelve un booleano diciendo si es mayor de edad o no
     */
    public boolean esMayorDeEdad() {
        return (edad>=18);
    }

    /*
        SETTERS & GETTERS
     */
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDNI() {
        return DNI;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " apellido: " + apellido + " edad: " + edad +
                "\n DNI: " + DNI + " sexo: " + sexo + " peso: " + peso + " altura " + altura;
    }
}
