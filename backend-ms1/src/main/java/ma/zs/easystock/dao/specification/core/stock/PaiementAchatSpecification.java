package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.PaiementAchatCriteria;
import ma.zs.easystock.bean.core.stock.PaiementAchat;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class PaiementAchatSpecification extends  AbstractSpecification<PaiementAchatCriteria, PaiementAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
        addPredicateFk("achat","reference", criteria.getAchat()==null?null:criteria.getAchat().getReference());
    }

    public PaiementAchatSpecification(PaiementAchatCriteria criteria) {
        super(criteria);
    }

    public PaiementAchatSpecification(PaiementAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
