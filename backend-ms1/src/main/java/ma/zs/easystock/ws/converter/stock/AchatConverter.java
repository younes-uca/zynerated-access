package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.easystock.zynerator.util.ListUtil;

import ma.zs.easystock.ws.converter.stock.ClientConverter;
import ma.zs.easystock.ws.converter.stock.PaiementAchatConverter;
import ma.zs.easystock.ws.converter.stock.AchatItemConverter;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Achat;
import ma.zs.easystock.ws.dto.stock.AchatDto;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private PaiementAchatConverter paiementAchatConverter ;
    @Autowired
    private AchatItemConverter achatItemConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean client;
    private boolean paiementAchats;
    private boolean achatItems;

    public  AchatConverter(){//Client clientPaiementAchat paiementAchatAchatItem achatItemProduit produit,){
        super(Achat.class, AchatDto.class);
        init(true);
        //this.client =  client ;
        //this.paiementAchat =  paiementAchat ;
        //this.achatItem =  achatItem ;
        //this.produit =  produit ;
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateAchat()))
                item.setDateAchat(DateUtil.stringEnToDate(dto.getDateAchat()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaye()))
                item.setTotalPaye(dto.getTotalPaye());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.paiementAchats && ListUtil.isNotEmpty(dto.getPaiementAchats()))
                item.setPaiementAchats(paiementAchatConverter.toItem(dto.getPaiementAchats()));
            if(this.achatItems && ListUtil.isNotEmpty(dto.getAchatItems()))
                item.setAchatItems(achatItemConverter.toItem(dto.getAchatItems()));


        return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateAchat()!=null)
                dto.setDateAchat(DateUtil.dateTimeToString(item.getDateAchat()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaye()))
                dto.setTotalPaye(item.getTotalPaye());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.paiementAchats && ListUtil.isNotEmpty(item.getPaiementAchats())){
            paiementAchatConverter.init(true);
            paiementAchatConverter.setAchat(false);
            dto.setPaiementAchats(paiementAchatConverter.toDto(item.getPaiementAchats()));
            paiementAchatConverter.setAchat(true);

        }
        if(this.achatItems && ListUtil.isNotEmpty(item.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            dto.setAchatItems(achatItemConverter.toDto(item.getAchatItems()));
            achatItemConverter.setAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.paiementAchats = value;
        this.achatItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public PaiementAchatConverter getPaiementAchatConverter(){
        return this.paiementAchatConverter;
    }
    public void setPaiementAchatConverter(PaiementAchatConverter paiementAchatConverter ){
        this.paiementAchatConverter = paiementAchatConverter;
    }
    public AchatItemConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemConverter(AchatItemConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isPaiementAchats(){
        return this.paiementAchats ;
    }
    public void  setPaiementAchats(boolean paiementAchats ){
        this.paiementAchats  = paiementAchats ;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
}
