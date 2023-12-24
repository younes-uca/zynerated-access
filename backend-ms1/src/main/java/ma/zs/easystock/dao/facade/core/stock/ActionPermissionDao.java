package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.ActionPermission;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.ActionPermission;
import java.util.List;


@Repository
public interface ActionPermissionDao extends AbstractRepository<ActionPermission,Long>  {
    ActionPermission findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW ActionPermission(item.id,item.reference) FROM ActionPermission item")
    List<ActionPermission> findAllOptimized();

}
