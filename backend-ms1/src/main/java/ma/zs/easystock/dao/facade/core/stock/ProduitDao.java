package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Produit;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.Produit;
import java.util.List;


@Repository
public interface ProduitDao extends AbstractRepository<Produit,Long>  {
    Produit findByReference(String reference);
    int deleteByReference(String reference);

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    long countByCategorieProduitReference(String reference);

    @Query("SELECT NEW Produit(item.id,item.reference) FROM Produit item")
    List<Produit> findAllOptimized();

}
