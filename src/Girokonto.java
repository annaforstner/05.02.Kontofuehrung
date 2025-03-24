import java.util.ArrayList;
import java.util.Scanner;

public class Girokonto extends Basis{

    private Scanner scan = new Scanner(System.in);
    private static ArrayList<Girokonto> giro = new ArrayList<>();

    public Girokonto(String kontoinhaber, int bankleitzahl, String kontonummer, double ueberziehen, double kontogebuer, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehen, kontogebuer, kontostand);
    }

    public Girokonto() {
    }

    public void einzahlen(){
        System.out.println("Auf welches Konto soll etwas eingezahlt werden?");

        int zahl = 1;
        for (int i = 0; i < giro.size(); i++){
            Girokonto b = giro.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f\n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand());
            zahl++;
        }

        System.out.println("Wählen Sie eine Zahl: ");
        int einz = scan.nextInt();
        Girokonto be = giro.get(einz - 1);
        System.out.printf("Folgendes Konto wurde ausgewählt: Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f\n", be.getKontonummer(), be.getKontoinhaber(), be.getKontostand());
        System.out.println("Wie viel soll eingezahlt werden?");
        double rein = scan.nextDouble();
        scan.nextLine();
        double geld = be.getKontostand();
        double neuKontostand = geld + rein;
        be.setKontostand(neuKontostand);
        System.out.printf("Der neue Kontostand beträgt: %6.2f\n", be.getKontostand());
    }

    public void auszahlen(){
        System.out.println("Von welchem Konto soll etwas abgehoben werden?");
        int zahl = 1;
        for (int i = 0; i < giro.size(); i++){
            Girokonto b = giro.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f\n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand());
            zahl++;
        }
        System.out.println("Wählen Sie eine Zahl: ");
        int ausz = scan.nextInt();
        Girokonto ba = giro.get(ausz-1);

        System.out.printf("Folgendes Konto wurde ausgewählt: Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f\n", ba.getKontonummer(), ba.getKontoinhaber(), ba.getKontostand());
        System.out.println("Wie viel soll ausgezahlt werden?");
        double raus = scan.nextDouble();
        scan.nextLine();
        double geld = ba.getKontostand();
        double neuerKontostand = geld - raus;
        if(neuerKontostand < 0) {
            System.out.println("Sie haben zu viel Geld abgehoben und sind " + neuerKontostand + " € im Minus. Dies wird mit ihrem Zinssatz von 1,02% per Tag verzinst.");
            ba.setKontostand(neuerKontostand);
        } else if( neuerKontostand < ba.getUeberziehen()){
            System.out.println("Sie haben den Überziehungsrahmen erreicht. Die Auszahlung ist invalid.");
        } else {
            ba.setKontostand(neuerKontostand);
        }
    }
}
