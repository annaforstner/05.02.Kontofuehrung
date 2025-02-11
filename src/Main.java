import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main m = new Main();
        m.menu();

    }

    public void menu(){

        Girokonto g = new Girokonto("Anna Forstner", 1223, "7858", 267.65, 5.97, 234.56);
        Sparkonto s = new Sparkonto("Sebastian Forstner", 4567, "ou575r", 6789.34, 3.21, 5432.09);
        Kreditkonto k = new Kreditkonto("klara marie", 9867, "985876", 8762.67, 1.67, -23.42);

        Scanner scan = new Scanner(System.in);
        Girokonto g2 = new Girokonto();
        Sparkonto s2 = new Sparkonto();
        Kreditkonto k2 = new Kreditkonto();

        while (true){
            

            System.out.println("Kontoführung");
            System.out.println("1. Konto anlegen");
            System.out.println("2. einzahlen");
            System.out.println("3. abheben");
            System.out.println("4. Konto auflösen");
            System.out.println("0. Programm beenden");

            int option = scan.nextInt();
            switch (option){
                case 0:
                    System.out.println("bye bye");
                    System.exit(0);
                case 1:
                    System.out.println("\nWelche Art von Konto möchten Sie anlegen?");
                    System.out.println("1. Girokonto");
                    System.out.println("2. Sparkonto");
                    System.out.println("3. Kreditkonto");
                    int zahl1 = scan.nextInt();
                    if(zahl1 == 1){
                        g2.kontoAnlegen();
                    } else if (zahl1 == 2){
                        s2.kontoAnlegen();
                    }else if (zahl1 == 3){
                        k2.kontoAnlegen();
                    }else{
                        System.out.println("Mehr Optionen gibt es nicht.");
                    }
                    break;
                case 2:
                    System.out.println("\nAuf welche Art von Konto möchten Sie einzahlen?");
                    System.out.println("1. Girokonto");
                    System.out.println("2. Sparkonto");
                    System.out.println("3. Kreditkonto");
                    int zahl2 = scan.nextInt();
                    if(zahl2 == 1){
                        g2.einzahlen();
                    }else if( zahl2 == 2){
                        s2.einzahlen();
                    }else if (zahl2 == 3){
                        k2.einzahlen();
                    }else{
                        System.out.println("Mehr Optionen gibt es nicht.");
                    }
                    break;
                case 3:
                    System.out.println("\nVon welcher Art von Konto möchten Sie etwas auszahlen?");
                    System.out.println("1. Girokonto");
                    System.out.println("2. Sparkonto");
                    System.out.println("3. Kreditkonto");
                    int zahl3 = scan.nextInt();
                    if(zahl3 == 1){
                        g2.auszahlen();
                    }else if( zahl3 == 2){
                        s2.auszahlen();
                    }else if (zahl3 == 3){
                        k2.auszahlen();
                    }else{
                        System.out.println("Mehr Optionen gibt es nicht.");
                    }
                    break;
                case 4:
                    System.out.println("\nWelche Art von Konto möchten Sie löschen?");
                    System.out.println("1. Girokonto");
                    System.out.println("2. Sparkonto");
                    System.out.println("3. Kreditkonto");
                    int zahl4 = scan.nextInt();
                    if(zahl4 == 1){
                        g2.kontoLoeschen();
                    } else if (zahl4 == 2){
                        s2.kontoLoeschen();
                    }else if (zahl4 == 3){
                        k2.kontoLoeschen();
                    }else{
                        System.out.println("Mehr Optionen gibt es nicht.");
                    }
                    break;
                default:
                    System.out.println("Upsi... irgendwas ist schiefgelaufen");
                    break;
            }
        }
    }
}
