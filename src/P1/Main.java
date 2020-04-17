//1719032 Jan Willem Beutler
//P1: DAO Simulatie voor 1 domeinklasse

package P1;

import java.sql.Date;

public class Main {
    public static void main(String[] args){
        ReizigerOracleDaoImpl db = new ReizigerOracleDaoImpl();

        Reiziger r1 = new Reiziger();
        Date datumr1 = Date.valueOf("2020-04-17");
        Date datum2 = Date.valueOf("1997-06-12");

        //aanmaken reiziger r1
        System.out.println("Reiziger r1:");
        r1.setNaam("Jan Willem");
        r1.setGbdatum(datumr1);
        db.save(r1);
        System.out.println(r1.getNaam());
        System.out.println(r1.getGbdatum());

        //wijzigen naam & gb datum R1
        System.out.println("\nGewijzigde naam & gb datum R1:");
        r1.setNaam("Willem");
        r1.setGbdatum(datum2);
        db.update(r1);
        System.out.println(r1.getNaam());
        System.out.println(r1.getGbdatum());

        //findByGBdatum test
        System.out.println("\nfindByGBdatum test:");
        for (Reiziger r : db.findByGBdatum(datum2.toString())) {
            System.out.println(r.getNaam());
        }
        System.out.println("findByGBdatum gelukt");

        //r1 verwijderen uit db
        System.out.println("\nR1 verwijderen:");
        db.delete(r1);
        System.out.println(db.findAll());
        System.out.println("R1 verwijderd");
    }
}
