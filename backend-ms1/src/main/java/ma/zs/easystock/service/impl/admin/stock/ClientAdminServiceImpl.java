package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Client;
import ma.zs.easystock.dao.criteria.core.stock.ClientCriteria;
import ma.zs.easystock.dao.facade.core.stock.ClientDao;
import ma.zs.easystock.dao.specification.core.stock.ClientSpecification;
import ma.zs.easystock.service.facade.admin.stock.ClientAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {





    public Client findByReferenceEntity(Client t){
        return  dao.findByCin(t.getCin());
    }


    public List<Client> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Client.class, ClientSpecification.class);
    }



    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}
