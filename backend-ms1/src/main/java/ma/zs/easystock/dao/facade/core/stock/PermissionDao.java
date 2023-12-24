package ma.zs.easystock.dao.facade.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Permission;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PermissionDao extends AbstractRepository<Permission,Long>  {

    List<Permission> findByActionPermissionId(Long id);
    int deleteByActionPermissionId(Long id);
    long countByActionPermissionReference(String reference);
    List<Permission> findByModelPermissionId(Long id);
    int deleteByModelPermissionId(Long id);
    long countByModelPermissionReference(String reference);


}
