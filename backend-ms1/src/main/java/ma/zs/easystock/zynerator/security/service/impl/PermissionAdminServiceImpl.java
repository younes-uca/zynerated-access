package ma.zs.easystock.zynerator.security.service.impl;


import ma.zs.easystock.zynerator.security.bean.Permission;
import ma.zs.easystock.dao.criteria.core.stock.PermissionCriteria;
import ma.zs.easystock.zynerator.security.dao.PermissionDao;
import ma.zs.easystock.dao.specification.core.stock.PermissionSpecification;
import ma.zs.easystock.zynerator.security.service.facade.PermissionAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.ActionPermissionAdminService ;
import ma.zs.easystock.service.facade.admin.stock.ModelPermissionAdminService ;

@Service
public class PermissionAdminServiceImpl extends AbstractServiceImpl<Permission, PermissionCriteria, PermissionDao> implements PermissionAdminService {






    public List<Permission> findByActionPermissionId(Long id){
        return dao.findByActionPermissionId(id);
    }
    public int deleteByActionPermissionId(Long id){
        return dao.deleteByActionPermissionId(id);
    }
    public long countByActionPermissionReference(String reference){
        return dao.countByActionPermissionReference(reference);
    }
    public List<Permission> findByModelPermissionId(Long id){
        return dao.findByModelPermissionId(id);
    }
    public Boolean findByModelPermissionReferenceAndActionPermissionReferenceAndSubAttributeIsNull(String reference , String action){
        Permission permission = dao.findByModelPermissionReferenceAndActionPermissionReferenceAndSubAttributeIsNull(reference , action);
        return permission.getValue() ;
    }
    public int deleteByModelPermissionId(Long id){
        return dao.deleteByModelPermissionId(id);
    }
    public long countByModelPermissionReference(String reference){
        return dao.countByModelPermissionReference(reference);
    }






    public void configure() {
        super.configure(Permission.class, PermissionSpecification.class);
    }


    @Autowired
    private ActionPermissionAdminService actionPermissionService ;
    @Autowired
    private ModelPermissionAdminService modelPermissionService ;

    public PermissionAdminServiceImpl(PermissionDao dao) {
        super(dao);
    }

}
