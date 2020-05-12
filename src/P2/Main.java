//1719032 Jan Willem Beutler
//P2: DAO één op veel relatie

package P2;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        try {
                ReizigerDaoOracleDaoImpl db = new ReizigerDaoOracleDaoImpl();
                OvChipkaartOracleDaoImpl dbo = new OvChipkaartOracleDaoImpl();


                // Aanmaken OVChip
                OvChipkaart o1 = new OvChipkaart();
                o1.setKaartnummer(1123);
                o1.setKlasse(1);
                o1.setReizigerId(2);
                o1.setSaldo(10.10);
                dbo.save(o1);

                //find by reiziger
                for (OvChipkaart ov : dbo.findbyReiziger(2)) {
                    System.out.println(ov.getKaartnummer());
                }

                Reiziger r1 = new Reiziger();
                Reiziger r2 = new Reiziger();
                Reiziger r3 = new Reiziger();

                Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019");
                r1.setNaam("Piet Test");
                r1.setGBdatum(datum1);
                r1 = db.save(r1);

                r2.setNaam("Hein Test");
                r2 = db.save(r2);

                r3.setNaam("Kees Test");
                r3 = db.save(r3);

                for (Reiziger r : db.findAll()) {
                    System.out.println(r.getNaam());
                }

                //Naam r1 wordt Fransje Setter
                r1.setNaam("Fransje Setter");
                db.update(r1);

                //Zoeken op basis van gbdatum
                for (Reiziger r : db.findByGBdatum("03-12-2002")) {
                    System.out.println(r.getNaam());
                }
                System.out.println("Datum gezocht");

                db.delete(r3);
                System.out.println("Finish");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
