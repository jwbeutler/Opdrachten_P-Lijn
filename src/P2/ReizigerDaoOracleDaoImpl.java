package P2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDaoOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
    private List<Reiziger> reizigers = new ArrayList<Reiziger>();

    @Override
    public List<Reiziger> findAll() {
         return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String GBdatum) {
        List<Reiziger> Reizigers = new ArrayList<Reiziger>();
        OvChipkaartOracleDaoImpl im = new OvChipkaartOracleDaoImpl();

        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            String strQuery = "SELECT * FROM REIZIGER WHERE geboortedatum = to_date(" + "'" + GBdatum + "'" + ", 'DD-MM-YYYY')";
            ResultSet rs = myStmt.executeQuery(strQuery);


            while(rs.next()) {
                Reiziger reiziger = new Reiziger();
                reiziger.setNaam(rs.getString("VOORLETTERS") + " " + rs.getString("ACHTERNAAM"));
                reiziger.setReizigerId(rs.getInt("REIZIGERID"));

                for (OvChipkaart ov : im.findbyReiziger(reiziger.getReizigerId())) {
                    reiziger.voegOvToe(ov);
                }

                Reizigers.add(reiziger);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        return null;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            String voorletter = reiziger.getNaam();
            voorletter = Character.toString(voorletter.charAt(0));
            String[] naam = reiziger.getNaam().split(" ");
            String achternaam = naam[1];

            String q = "Update REIZIGER SET voorletters = '" + voorletter + "', ACHTERNAAM = '" + achternaam + "' where REIZIGERID = " + reiziger.getReizigerId();
            ResultSet myRs = myStmt.executeQuery(q);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("delete from REIZIGER "
                    + "where REIZIGERID = " + reiziger.getReizigerId());
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }
}
