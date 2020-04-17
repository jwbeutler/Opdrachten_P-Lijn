//1719032 Jan Willem Beutler
//P1: DAO Simulatie voor 1 domeinklasse

package P1;

import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
    private List<Reiziger> reizigers = new ArrayList<Reiziger>();

    @Override
    public List<Reiziger> findAll() {
        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String GBdatum) {
        List<Reiziger> GbReiziger = new ArrayList<Reiziger>();
        for(Reiziger reiziger : this.reizigers){
            if(reiziger.getGbdatum()!=null){
                if(reiziger.getGbdatum().equals(GBdatum)){
                    GbReiziger.add(reiziger);
                }
            }

        }
        return GbReiziger;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        if(!this.reizigers.contains(reiziger)){
            this.reizigers.add(reiziger);
        }
        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        if (this.reizigers.contains(reiziger)) {
            this.reizigers.remove(reiziger);
            this.reizigers.add(reiziger);
            return reiziger;
        }
        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        if (this.reizigers.contains(reiziger)) {
            this.reizigers.remove(reiziger);
            return true;
        }
        return false;
    }
}