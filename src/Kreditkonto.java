import java.util.ArrayList;
import java.util.Scanner;

public class Kreditkonto extends Basis{

    private Scanner scan = new Scanner(System.in);
    private ArrayList<Kreditkonto> kredit = new ArrayList<>();

    public Kreditkonto(String kontoinhaber, int bankleitzahl, String kontonummer, double ueberziehen, double kontogebuer, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehen, kontogebuer, kontostand);
    }

    public Kreditkonto() {
    }

    public void einzahlen(){
        System.out.println("Auf welches Konto soll etwas eingezahlt werden?");

        int zahl = 1;
        for (int i = 0; i < kredit.size(); i++){
            Kreditkonto b = kredit.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand());
            zahl++;
        }

        System.out.println("Wählen Sie eine Zahl: ");
        int einz = scan.nextInt();
        Kreditkonto be = kredit.get(einz);
        System.out.printf("Folgendes Konto wurde ausgewählt: Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n", be.getKontonummer(), be.getKontoinhaber(), be.getKontostand());
        System.out.println("Wie viel soll eingezahlt werden?\nBitte beachten Sie, dass das Kreditkonto nicht ins positive gehen kann.");
        double rein = scan.nextDouble();
        scan.nextLine();
        double geld = be.getKontostand();
        double neuKontostand = geld + rein;
        if (neuKontostand > 0){
            System.out.println("Kreditkonto zurückgezahlt. Konto wird geschlossen.");
            kredit.remove(einz);
            System.out.println("\nDanke für die Spende.\n");
        }
        else {
            be.setKontostand(neuKontostand);
            System.out.printf("Der neue Kontostand beträgt: %6.2f", be.getKontostand());
        }
    }

    public void auszahlen(){
        System.out.println("Von welchem Konto soll etwas abgehoben werden?");

        int zahl = 1;
        for (int i = 0; i < kredit.size(); i++){
            Basis b = kredit.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand());
            zahl++;
        }
        System.out.println("Wählen Sie eine Zahl: ");
        int ausz = scan.nextInt();
        Kreditkonto ba = kredit.get(ausz);

        System.out.printf("Folgendes Konto wurde ausgewählt: Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n", ba.getKontonummer(), ba.getKontoinhaber(), ba.getKontostand());
        System.out.println("Wie viel soll ausgezahlt werden?");
        double raus = scan.nextDouble();
        scan.nextLine();
        double geld = ba.getKontostand();
        double neuerKontostand = geld - raus;
        if(neuerKontostand < 0) {
            ba.setKontostand(neuerKontostand);
        } else if( neuerKontostand < ba.getUeberziehen()){
            System.out.println("Sie haben den Überziehungsrahmen erreicht. Die Auszahlung ist invalid.");
        }
    }
}
