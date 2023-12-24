package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Permission;
import ma.zs.easystock.dao.criteria.core.stock.PermissionCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface PermissionAdminService extends  IService<Permission,PermissionCriteria>  {

    List<Permission> findByActionPermissionId(Long id);
    int deleteByActionPermissionId(Long id);
    long countByActionPermissionReference(String reference);
    List<Permission> findByModelPermissionId(Long id);
    int deleteByModelPermissionId(Long id);
    long countByModelPermissionReference(String reference);



}
