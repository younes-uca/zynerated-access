package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.ActionPermission;
import ma.zs.easystock.dao.criteria.core.stock.ActionPermissionCriteria;
import ma.zs.easystock.dao.facade.core.stock.ActionPermissionDao;
import ma.zs.easystock.dao.specification.core.stock.ActionPermissionSpecification;
import ma.zs.easystock.service.facade.admin.stock.ActionPermissionAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ActionPermissionAdminServiceImpl extends AbstractServiceImpl<ActionPermission, ActionPermissionCriteria, ActionPermissionDao> implements ActionPermissionAdminService {





    public ActionPermission findByReferenceEntity(ActionPermission t){
        return  dao.findByReference(t.getReference());
    }


    public List<ActionPermission> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ActionPermission.class, ActionPermissionSpecification.class);
    }



    public ActionPermissionAdminServiceImpl(ActionPermissionDao dao) {
        super(dao);
    }

}
