package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.CategorieProduit;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.CategorieProduit;
import java.util.List;


@Repository
public interface CategorieProduitDao extends AbstractRepository<CategorieProduit,Long>  {
    CategorieProduit findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW CategorieProduit(item.id,item.reference) FROM CategorieProduit item")
    List<CategorieProduit> findAllOptimized();

}
