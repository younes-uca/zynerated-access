package ma.zs.easystock.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "permission")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="permission_seq",sequenceName="permission_seq",allocationSize=1, initialValue = 1)
public class Permission   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String subAttribute;
    @Column(columnDefinition = "boolean default false")
    private Boolean value = false;

    private ActionPermission actionPermission ;
    private ModelPermission modelPermission ;


    public Permission(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="permission_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ActionPermission getActionPermission(){
        return this.actionPermission;
    }
    public void setActionPermission(ActionPermission actionPermission){
        this.actionPermission = actionPermission;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ModelPermission getModelPermission(){
        return this.modelPermission;
    }
    public void setModelPermission(ModelPermission modelPermission){
        this.modelPermission = modelPermission;
    }
    public String getSubAttribute(){
        return this.subAttribute;
    }
    public void setSubAttribute(String subAttribute){
        this.subAttribute = subAttribute;
    }
    public Boolean  getValue(){
        return this.value;
    }
    public void setValue(Boolean value){
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission permission = (Permission) o;
        return id != null && id.equals(permission.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

