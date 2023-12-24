package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.ModelPermission;
import ma.zs.easystock.dao.criteria.core.stock.ModelPermissionCriteria;
import ma.zs.easystock.dao.facade.core.stock.ModelPermissionDao;
import ma.zs.easystock.dao.specification.core.stock.ModelPermissionSpecification;
import ma.zs.easystock.service.facade.admin.stock.ModelPermissionAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ModelPermissionAdminServiceImpl extends AbstractServiceImpl<ModelPermission, ModelPermissionCriteria, ModelPermissionDao> implements ModelPermissionAdminService {





    public ModelPermission findByReferenceEntity(ModelPermission t){
        return  dao.findByReference(t.getReference());
    }


    public List<ModelPermission> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ModelPermission.class, ModelPermissionSpecification.class);
    }



    public ModelPermissionAdminServiceImpl(ModelPermissionDao dao) {
        super(dao);
    }

}
