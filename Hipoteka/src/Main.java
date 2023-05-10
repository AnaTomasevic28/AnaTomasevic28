import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        final byte MESECI_U_GODINI = 12;
        final byte PROCENAT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Osnovica kredita: ");
        int osnovicaKredita = scanner.nextInt();

        System.out.println("Godisnja kamatna stopa: ");
        float godisnjaKamatnaStopa = scanner.nextFloat();
        float mesecnaKamatnaStopa = godisnjaKamatnaStopa / PROCENAT / MESECI_U_GODINI;

        System.out.println("Period otplate (godine): ");
        byte periodOtplate = scanner.nextByte();
        int brojRata = periodOtplate * MESECI_U_GODINI;

        double hipoteka = osnovicaKredita
                        * (mesecnaKamatnaStopa * Math.pow( 1 + mesecnaKamatnaStopa, brojRata ))
                        / (Math.pow( 1 + mesecnaKamatnaStopa, brojRata) - 1);
        String hipotekaFormatted = NumberFormat.getCurrencyInstance().format(hipoteka);
        System.out.println( "Hipoteka: " + hipotekaFormatted);

    }
}