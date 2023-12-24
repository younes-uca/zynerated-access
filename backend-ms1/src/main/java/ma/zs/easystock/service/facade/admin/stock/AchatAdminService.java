package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Achat;
import ma.zs.easystock.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.zynerator.service.IService;



public interface AchatAdminService extends  IService<Achat,AchatCriteria>  {

    List<Achat> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientCin(String cin);



}
