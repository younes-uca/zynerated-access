package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.PermissionCriteria;
import ma.zs.easystock.bean.core.stock.Permission;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class PermissionSpecification extends  AbstractSpecification<PermissionCriteria, Permission>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("subAttribute", criteria.getSubAttribute(),criteria.getSubAttributeLike());
        addPredicateBool("value", criteria.getValue());
        addPredicateFk("actionPermission","id", criteria.getActionPermission()==null?null:criteria.getActionPermission().getId());
        addPredicateFk("actionPermission","id", criteria.getActionPermissions());
        addPredicateFk("actionPermission","reference", criteria.getActionPermission()==null?null:criteria.getActionPermission().getReference());
        addPredicateFk("modelPermission","id", criteria.getModelPermission()==null?null:criteria.getModelPermission().getId());
        addPredicateFk("modelPermission","id", criteria.getModelPermissions());
        addPredicateFk("modelPermission","reference", criteria.getModelPermission()==null?null:criteria.getModelPermission().getReference());
    }

    public PermissionSpecification(PermissionCriteria criteria) {
        super(criteria);
    }

    public PermissionSpecification(PermissionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
