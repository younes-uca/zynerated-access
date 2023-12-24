package ma.zs.easystock.zynerator.service;

import ma.zs.easystock.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import ma.zs.easystock.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
