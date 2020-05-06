package P3;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        try {
            ReizigerDaoOracleDaoImpl db = new ReizigerDaoOracleDaoImpl();
            OvChipkaartOracleDaoImpl dbo = new OvChipkaartOracleDaoImpl();
            ProdutOracleDaoImpl dbp = new ProdutOracleDaoImpl();

            for (OvChipkaart ov : dbo.findbyReiziger(2)) {
                System.out.println(ov.getKaartnummer());
            }

            Reiziger r1 = new Reiziger();
            Reiziger r2 = new Reiziger();
            Reiziger r3 = new Reiziger();

            Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019");
            r1.setNaam("S Echtelt");
            r1.setGBdatum(datum1);
            r1 = db.save(r1);

            r2.setNaam("T test");
            r2 = db.save(r2);

            r3.setNaam("Y Test2");
            r3 = db.save(r3);

            for (Reiziger r : db.findAll()) {
                System.out.println(r.getNaam());
            }

            System.out.println("all done");

            r1.setNaam("X Echtelt");
            db.update(r1);

            for (Reiziger r : db.findByGBdatum("03-12-2002")) {
                System.out.println(r.getNaam());
            }
            System.out.println("by date done");

            db.delete(r3);
            System.out.println("all done");

            OvChipkaart o1 = new OvChipkaart();
            o1.setKaartnummer(1231241);
            o1.setKlasse(1);
            o1.setReizigerId(2);
            o1.setSaldo(11.11);
            dbo.save(o1);

            OvChipkaart o2 = new OvChipkaart();
            o2.setKaartnummer(5678142);
            o2.setKlasse(2);
            o2.setReizigerId(2);
            o2.setSaldo(83.11);
            dbo.save(o2);

            Product product1 = new Product();
            product1.setProductnaam("2test3");
            product1.setBeschrijving("Dit is de beschrijving 1");
            product1.setPrijs(50.2);
            product1.setProductnummer(14);
            dbp.save(product1);

            Product product2 = new Product();
            product2.setProductnaam("1test4");
            product2.setBeschrijving("Dit is de beschrijving 2");
            product2.setPrijs(10.3);
            product2.setProductnummer(15);
            dbp.save(product2);

            dbo.linkProduct(o1, product1);

            System.out.println("Alle kaarten die product 2 hebben");
            for (OvChipkaart ov : dbp.findOvChipkaartByProductNummer(2)) {
                System.out.println(ov);
            }

            System.out.println("done");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
