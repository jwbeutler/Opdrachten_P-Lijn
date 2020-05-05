package P2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OvChipkaartOracleDaoImpl extends OracleBaseDao implements OvChipkaartDao {

    @Override
    public List<OvChipkaart> findbyReiziger(int reizigerId) {
        List<OvChipkaart> ovs = new ArrayList<OvChipkaart>();

        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            String strQuery = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = " + reizigerId;
            ResultSet rs = myStmt.executeQuery(strQuery);

            while(rs.next()) {
                OvChipkaart ov = new OvChipkaart();
                ov.setSaldo(rs.getFloat("SALDO"));
                ov.setReizigerId(rs.getInt("REIZIGERID"));
                ov.setKaartnummer(rs.getInt("KAARTNUMMER"));
                ovs.add(ov);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ovs;
    }

    @Override
    public OvChipkaart save(OvChipkaart ovChipkaart) {
        try {
            Connection myConn = getConnection();
            Statement insertStmt = myConn.createStatement();
            String q = "INSERT INTO "
                    + "ov_chipkaart(KAARTNUMMER, KLASSE, SALDO, REIZIGERID, GELDIGTOT) "
                    + "VALUES('" + ovChipkaart.getKaartnummer() + "','" + ovChipkaart.getKlasse() + "', " + ovChipkaart.getSaldo() + ",'" + ovChipkaart.getReizigerId() + "', to_date('31-12-2017', 'DD-MM-YYYY'))";
            ResultSet myRs = insertStmt.executeQuery(q);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return ovChipkaart;
    }

    @Override
    public OvChipkaart update(OvChipkaart ovChipkaart) {
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();

            String q = "Update OV_CHIPKAART SET "
                    + "KAARTNUMMER = '" + ovChipkaart.getKaartnummer() + "' "
                    + "KLASSE = '" + ovChipkaart.getKlasse() + "' "
                    + "SALDO = '" + ovChipkaart.getSaldo() + "' "
                    + "REIZIGERID = '" + ovChipkaart.getReizigerId() + "' ";
            ResultSet myRs = myStmt.executeQuery(q);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return ovChipkaart;
    }

    @Override
    public boolean delete(OvChipkaart ovChipkaart) {
        try {
            Connection myConn = getConnection();
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("delete from OV_CHIPKAART "
                    + "where KAARTNUMMER = " + ovChipkaart.getKaartnummer());
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }
}


