package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.CategorieProduit;
import ma.zs.easystock.dao.criteria.core.stock.CategorieProduitCriteria;
import ma.zs.easystock.dao.facade.core.stock.CategorieProduitDao;
import ma.zs.easystock.dao.specification.core.stock.CategorieProduitSpecification;
import ma.zs.easystock.service.facade.admin.stock.CategorieProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieProduitAdminServiceImpl extends AbstractServiceImpl<CategorieProduit, CategorieProduitCriteria, CategorieProduitDao> implements CategorieProduitAdminService {





    public CategorieProduit findByReferenceEntity(CategorieProduit t){
        return  dao.findByReference(t.getReference());
    }


    public List<CategorieProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieProduit.class, CategorieProduitSpecification.class);
    }



    public CategorieProduitAdminServiceImpl(CategorieProduitDao dao) {
        super(dao);
    }

}
