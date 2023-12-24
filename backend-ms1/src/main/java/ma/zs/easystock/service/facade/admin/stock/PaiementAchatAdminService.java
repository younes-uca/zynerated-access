package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.PaiementAchat;
import ma.zs.easystock.dao.criteria.core.stock.PaiementAchatCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface PaiementAchatAdminService extends  IService<PaiementAchat,PaiementAchatCriteria>  {

    List<PaiementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatReference(String reference);



}
