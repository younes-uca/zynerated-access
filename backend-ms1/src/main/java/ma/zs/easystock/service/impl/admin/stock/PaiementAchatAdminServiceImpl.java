package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.PaiementAchat;
import ma.zs.easystock.dao.criteria.core.stock.PaiementAchatCriteria;
import ma.zs.easystock.dao.facade.core.stock.PaiementAchatDao;
import ma.zs.easystock.dao.specification.core.stock.PaiementAchatSpecification;
import ma.zs.easystock.service.facade.admin.stock.PaiementAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.bean.core.stock.Achat ;

import java.util.List;
@Service
public class PaiementAchatAdminServiceImpl extends AbstractServiceImpl<PaiementAchat, PaiementAchatCriteria, PaiementAchatDao> implements PaiementAchatAdminService {





    public PaiementAchat findByReferenceEntity(PaiementAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatReference(String reference){
        return dao.countByAchatReference(reference);
    }

    public List<PaiementAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PaiementAchat.class, PaiementAchatSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;

    public PaiementAchatAdminServiceImpl(PaiementAchatDao dao) {
        super(dao);
    }

}
