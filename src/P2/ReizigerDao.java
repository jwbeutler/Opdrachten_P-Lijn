//1719032 Jan Willem Beutler
//P2: DAO één op veel relatie

package P2;

import java.util.List;

public interface ReizigerDao {
    public List<Reiziger> findAll();
    public List<Reiziger> findByGBdatum(String GBdatum);
    public Reiziger save(Reiziger reiziger);
    public Reiziger update(Reiziger reiziger);
    public boolean delete(Reiziger reiziger);

}
