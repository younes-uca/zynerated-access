package ma.zs.easystock.bean.core.stock;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_achat_seq",sequenceName="paiement_achat_seq",allocationSize=1, initialValue = 1)
public class PaiementAchat   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime datePaiement ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Achat achat ;


    public PaiementAchat(){
        super();
    }

    public PaiementAchat(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public PaiementAchat(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="paiement_achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Achat getAchat(){
        return this.achat;
    }
    public void setAchat(Achat achat){
        this.achat = achat;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementAchat paiementAchat = (PaiementAchat) o;
        return id != null && id.equals(paiementAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

