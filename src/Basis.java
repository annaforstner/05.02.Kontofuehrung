import java.util.ArrayList;
import java.util.Scanner;

public class Basis {
    private String kontoinhaber;
    private int bankleitzahl;
    private String kontonummer;
    private double ueberziehen;
    private double kontogebuer;
    private double kontostand;
    private String kontoart;

    private Scanner scan = new Scanner(System.in);
    private ArrayList<Basis> base = new ArrayList<>();

    // Konstruktor
    public Basis(String kontoinhaber, int bankleitzahl, String kontonummer, double ueberziehen, double kontogebuer, double kontostand, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehen = ueberziehen;
        this.kontogebuer = kontogebuer;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }
    public Basis(){}

    // Getter und Setter
    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public int getBankleitzahl() {
        return bankleitzahl;
    }

    public void setBankleitzahl(int bankleitzahl) {
        this.bankleitzahl = bankleitzahl;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getUeberziehen() {
        return ueberziehen;
    }

    public void setUeberziehen(double ueberziehen) {
        this.ueberziehen = ueberziehen;
    }

    public double getKontogebuer() {
        return kontogebuer;
    }

    public void setKontogebuer(double kontogebuer) {
        this.kontogebuer = kontogebuer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public String getKontoart() {
        return kontoart;
    }

    public void setKontoart(String kontoart) {
        this.kontoart = kontoart;
    }

    public void kontoAnlegen(){
        System.out.println("Der erste Punkt ist der Kontoinhaber. Bitte gib deinen vollständigen Namen ein.");
        kontoinhaber = scan.nextLine();
        System.out.println("Bitte gib die Bankleitzahl ein. Diese sollte eine vierstellige Nummer sein.");
        bankleitzahl = scan.nextInt();
        scan.nextLine();
        System.out.println("Gib die Kontonummer ein.");
        kontonummer = scan.nextLine();
        System.out.println("Wie groß soll der Überziehungsrahmen sein?");
        ueberziehen = scan.nextDouble();
        System.out.println("Wie groß sind die Kontoführungsgebüren?");
        kontogebuer = scan.nextDouble();
        System.out.println("Wie viel möchten Sie bei der Erstellung des Kontos darauf überweisen?");
        kontostand = scan.nextDouble();
        scan.nextLine();
        System.out.println("Zuletzt noch: Was für eine Art ist ihr Konto? Girokonto, Sparkonto oder Kreditkonto.");
        kontoart = scan.nextLine();

        Basis b = new Basis(kontoinhaber, bankleitzahl, kontonummer, ueberziehen, kontogebuer, kontostand, kontoart);
        base.add(b);
    }

    public void kontoLoeschen(){
        System.out.println("Sie haben sich dazu entschieden, ein Konto zu löschen.");
        // damit es alle Konten anzeigt
        int zahl = 1;
        for (int i = 0; i < base.size(); i++){
            Basis b = base.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontoart: %-20s%n",zahl, b.getKontonummer(), b.getKontoinhaber(), b.getKontoart());
            zahl++;
        }

        // welches Konto soll gelöscht werden
        System.out.println("Welches Konto soll gelöscht werden? (Bitte Zahl wählen)");
        int weg = scan.nextInt();
        base.remove(weg);
    }

    public void einzahlen(){
        System.out.println("Auf welches Konto soll etwas eingezahlt werden?");

        int zahl = 1;
        for (int i = 0; i < base.size(); i++){
            Basis b = base.get(i);
            System.out.printf("%d | Kontonummer: %-6s | Kontoinhaber: %-20s | Kontostand: %-6.2f | Kontoart: %-20s%n",zahl, b.getKontonummer(), b.getKontoinhaber(),b.getKontostand() ,b.getKontoart());
            zahl++;
        }

    }

}
