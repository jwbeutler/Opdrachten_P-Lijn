//1719032 Jan Willem Beutler
//P3: DAO veel op veel relatie

package P3;

import java.util.List;

public interface OvChipkaartDao {
    public List<OvChipkaart> findbyReiziger(int reizigerId);
    public OvChipkaart save(OvChipkaart ovChipkaart);
    public OvChipkaart update(OvChipkaart ovChipkaart);
    public boolean delete(OvChipkaart ovChipkaart);

}
