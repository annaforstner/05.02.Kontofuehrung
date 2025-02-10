import java.util.ArrayList;
import java.util.Scanner;

public class Sparkonto extends Basis{

    private Scanner scan = new Scanner(System.in);
    private ArrayList<Sparkonto> sparen = new ArrayList<>();

    public Sparkonto(String kontoinhaber, int bankleitzahl, String kontonummer, double ueberziehen, double kontogebuer, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehen, kontogebuer, kontostand);
    }

    public Sparkonto() {
    }


    public void einzahlen(){
        System.out.println("Auf welches Konto soll etwas eingezahlt werden?");

        int zahl = 1;
        for (int i = 0; i < sparen.size(); i++){
            Sparkonto b = sparen.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand());
            zahl++;
        }

        System.out.println("Wählen Sie eine Zahl: ");
        int einz = scan.nextInt();
        Sparkonto be = sparen.get(einz);
        System.out.printf("Folgendes Konto wurde ausgewählt: Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n", be.getKontonummer(), be.getKontoinhaber(), be.getKontostand());
        System.out.println("Wie viel soll eingezahlt werden?");
        double rein = scan.nextDouble();
        scan.nextLine();
        double geld = be.getKontostand();
        double neuKontostand = geld + rein;
        be.setKontostand(neuKontostand);
        System.out.printf("Der neue Kontostand beträgt: %6.2f", be.getKontostand());
    }

    public void auszahlen(){
        System.out.println("Von welchem Konto soll etwas abgehoben werden?");

        int zahl = 1;
        for (int i = 0; i < sparen.size(); i++){
            Sparkonto b = sparen.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand());
            zahl++;
        }
        System.out.println("Wählen Sie eine Zahl: ");
        int ausz = scan.nextInt();
        Sparkonto ba = sparen.get(ausz);

        System.out.printf("Folgendes Konto wurde ausgewählt: Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f/n", ba.getKontonummer(), ba.getKontoinhaber(), ba.getKontostand());
        System.out.println("Wie viel soll ausgezahlt werden?");
        double raus = scan.nextDouble();
        scan.nextLine();
        double geld = ba.getKontostand();
        double neuerKontostand = geld - raus;
        if(neuerKontostand < 0) {
            System.out.println("Sie können mit diesem Konto nicht ins Minus.");
        } else {
            ba.setKontostand(neuerKontostand);
        }
    }
}
