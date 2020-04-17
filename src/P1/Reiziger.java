//1719032 Jan Willem Beutler
//P1: DAO Simulatie voor 1 domeinklasse

package P1;

import java.sql.Date;

public class Reiziger {
    private String naam;
    private Date gbdatum;

    public Reiziger(){

    }
    public String getNaam(){
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGbdatum() {
        return gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }
}
