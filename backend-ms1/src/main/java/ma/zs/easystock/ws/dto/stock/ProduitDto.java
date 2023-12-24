package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;
    private String barcode  ;
    private String discription  ;
    private BigDecimal prixAchatMoyen  ;
    private BigDecimal quantite  ;
    private BigDecimal seuilAlert  ;

    private CategorieProduitDto categorieProduit ;



    public ProduitDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    @Log
    public String getDiscription(){
        return this.discription;
    }
    public void setDiscription(String discription){
        this.discription = discription;
    }

    @Log
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getSeuilAlert(){
        return this.seuilAlert;
    }
    public void setSeuilAlert(BigDecimal seuilAlert){
        this.seuilAlert = seuilAlert;
    }


    public CategorieProduitDto getCategorieProduit(){
        return this.categorieProduit;
    }

    public void setCategorieProduit(CategorieProduitDto categorieProduit){
        this.categorieProduit = categorieProduit;
    }






}
