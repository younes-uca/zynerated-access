package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.PaiementAchat;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.PaiementAchat;
import java.util.List;


@Repository
public interface PaiementAchatDao extends AbstractRepository<PaiementAchat,Long>  {
    PaiementAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<PaiementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatReference(String reference);

    @Query("SELECT NEW PaiementAchat(item.id,item.reference) FROM PaiementAchat item")
    List<PaiementAchat> findAllOptimized();

}
