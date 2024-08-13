
import java.util.Scanner;

public class ahorcado {

    public static void main(String[] args) {
        try ( // Clase scanner que nos permite que el usuario escriba
                Scanner principal = new Scanner(System.in)) {
            String palabraSecreta = "inteligencia";
            int intentosMaximos = 10;
            int intentos = 0;
            boolean palabraAdivinidad = false;

            char[] letrasAdivinadas = new char[palabraSecreta.length()];

            for (int i = 0; i < letrasAdivinadas.length; i++) {
                letrasAdivinadas[i] = '_';
            }

            while (!palabraAdivinidad && intentos < intentosMaximos) {
                System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));

                System.out.println("Introduce una letra, por favor");

                char letra = Character.toLowerCase(principal.next().charAt(0));

                boolean letraCorrecta = false;
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                    }
                }
                if (!letraCorrecta) {
                    intentos++;
                    System.out.println("!Incorrecto¡ Te quedan " + (intentosMaximos - intentos) + " intentos.");
                }
                if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                    palabraAdivinidad = true;
                    System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
                }

            }
            if (!palabraAdivinidad) {
                System.out.println("¡Que pena te has quedado sin intentos! GAME OVER");
            }
        }
    }
}
