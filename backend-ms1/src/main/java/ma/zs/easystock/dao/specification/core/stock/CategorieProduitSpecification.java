package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.CategorieProduitCriteria;
import ma.zs.easystock.bean.core.stock.CategorieProduit;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class CategorieProduitSpecification extends  AbstractSpecification<CategorieProduitCriteria, CategorieProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategorieProduitSpecification(CategorieProduitCriteria criteria) {
        super(criteria);
    }

    public CategorieProduitSpecification(CategorieProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
