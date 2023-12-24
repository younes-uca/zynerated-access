package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.dao.facade.core.stock.ProduitDao;
import ma.zs.easystock.dao.specification.core.stock.ProduitSpecification;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.CategorieProduitAdminService ;
import ma.zs.easystock.bean.core.stock.CategorieProduit ;

import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit, ProduitCriteria, ProduitDao> implements ProduitAdminService {





    public Produit findByReferenceEntity(Produit t){
        return  dao.findByReference(t.getReference());
    }

    public List<Produit> findByCategorieProduitId(Long id){
        return dao.findByCategorieProduitId(id);
    }
    public int deleteByCategorieProduitId(Long id){
        return dao.deleteByCategorieProduitId(id);
    }
    public long countByCategorieProduitReference(String reference){
        return dao.countByCategorieProduitReference(reference);
    }

    public List<Produit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Produit.class, ProduitSpecification.class);
    }


    @Autowired
    private CategorieProduitAdminService categorieProduitService ;

    public ProduitAdminServiceImpl(ProduitDao dao) {
        super(dao);
    }

}
