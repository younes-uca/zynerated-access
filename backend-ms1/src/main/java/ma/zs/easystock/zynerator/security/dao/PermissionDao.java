package ma.zs.easystock.zynerator.security.dao;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.zynerator.security.bean.Permission;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PermissionDao extends AbstractRepository<Permission,Long>  {

    List<Permission> findByActionPermissionId(Long id);
    List<Permission> findByModelPermissionReference(String reference);
    Permission findByModelPermissionReferenceAndActionPermissionReferenceAndSubAttributeIsNull(String reference, String action);
    int deleteByActionPermissionId(Long id);
    long countByActionPermissionReference(String reference);
    List<Permission> findByModelPermissionId(Long id);
    int deleteByModelPermissionId(Long id);
    long countByModelPermissionReference(String reference);


}
