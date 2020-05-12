//1719032 Jan Willem Beutler
//P2: DAO één op veel relatie

package P2;

import java.util.List;

public interface OvChipkaartDao {
    public List<OvChipkaart> findbyReiziger(int reizigerId);
    public OvChipkaart save(OvChipkaart ovChipkaart);
    public OvChipkaart update(OvChipkaart ovChipkaart);
    public boolean delete(OvChipkaart ovChipkaart);

}
