package P3;

import java.util.ArrayList;

public class Product {
    private int productnummer;
    private String productnaam;
    private String beschrijving;
    private double prijs;
    private ArrayList<OvChipkaart> ovChipkaarten = new ArrayList<OvChipkaart>();

    public Product(){ }

    public int getProductnummer() {
        return productnummer;
    }

    public void setProductnummer(int productnummer) {
        this.productnummer = productnummer;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getProductnaam() {
        return productnaam;
    }

    public void setProductnaam(String productnaam) {
        this.productnaam = productnaam;
    }

    public ArrayList<OvChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }
    public void voegOvToe(OvChipkaart o) {
        if (!this.ovChipkaarten.contains(o)) {
            this.ovChipkaarten.add(o);
        }
    }
}
