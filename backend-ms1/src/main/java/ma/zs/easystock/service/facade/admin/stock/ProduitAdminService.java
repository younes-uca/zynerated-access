package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface ProduitAdminService extends  IService<Produit,ProduitCriteria>  {

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    long countByCategorieProduitReference(String reference);



}
