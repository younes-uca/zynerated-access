package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.stock.AchatConverter;

import ma.zs.easystock.bean.core.stock.Achat;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.PaiementAchat;
import ma.zs.easystock.ws.dto.stock.PaiementAchatDto;

@Component
public class PaiementAchatConverter extends AbstractConverter<PaiementAchat, PaiementAchatDto> {

    @Autowired
    private AchatConverter achatConverter ;
    private boolean achat;

    public  PaiementAchatConverter(){//Achat achat,){
        super(PaiementAchat.class, PaiementAchatDto.class);
        //this.achat =  achat ;
    }

    @Override
    public PaiementAchat toItem(PaiementAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementAchat item = new PaiementAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
                item.getAchat().setReference(dto.getAchat().getReference());
            }




        return item;
        }
    }

    @Override
    public PaiementAchatDto toDto(PaiementAchat item) {
        if (item == null) {
            return null;
        } else {
            PaiementAchatDto dto = new PaiementAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.achat = value;
    }


    public AchatConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatConverter(AchatConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
}
