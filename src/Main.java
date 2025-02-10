public class Main {
    public static void main(String[] args) {
        Girokonto g = new Girokonto("Anna Forstner", 1223, "7858", 267.65, 5.97, 234.56);
        Sparkonto s = new Sparkonto("Sebastian Forstner", 4567, "ou575r", 6789.34, 3.21, 5432.09);
        Kreditkonto k = new Kreditkonto("klara marie", 9867, "985876", 8762.67, 1.67, -23.42);


        g.auszahlen();
        s.einzahlen();
        k.kontoLoeschen();

    }
}
