package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.AchatItem;
import ma.zs.easystock.dao.criteria.core.stock.AchatItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.AchatItemDao;
import ma.zs.easystock.dao.specification.core.stock.AchatItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.AchatItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.bean.core.stock.Achat ;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;

import java.util.List;
@Service
public class AchatItemAdminServiceImpl extends AbstractServiceImpl<AchatItem, AchatItemCriteria, AchatItemDao> implements AchatItemAdminService {






    public List<AchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<AchatItem> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatReference(String reference){
        return dao.countByAchatReference(reference);
    }






    public void configure() {
        super.configure(AchatItem.class, AchatItemSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private ProduitAdminService produitService ;

    public AchatItemAdminServiceImpl(AchatItemDao dao) {
        super(dao);
    }

}
