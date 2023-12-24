package  ma.zs.easystock.dao.criteria.core.stock;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PermissionCriteria extends  BaseCriteria  {

    private String subAttribute;
    private String subAttributeLike;
    private Boolean value;

    private ActionPermissionCriteria actionPermission ;
    private List<ActionPermissionCriteria> actionPermissions ;
    private ModelPermissionCriteria modelPermission ;
    private List<ModelPermissionCriteria> modelPermissions ;


    public PermissionCriteria(){}

    public String getSubAttribute(){
        return this.subAttribute;
    }
    public void setSubAttribute(String subAttribute){
        this.subAttribute = subAttribute;
    }
    public String getSubAttributeLike(){
        return this.subAttributeLike;
    }
    public void setSubAttributeLike(String subAttributeLike){
        this.subAttributeLike = subAttributeLike;
    }

    public Boolean getValue(){
        return this.value;
    }
    public void setValue(Boolean value){
        this.value = value;
    }

    public ActionPermissionCriteria getActionPermission(){
        return this.actionPermission;
    }

    public void setActionPermission(ActionPermissionCriteria actionPermission){
        this.actionPermission = actionPermission;
    }
    public List<ActionPermissionCriteria> getActionPermissions(){
        return this.actionPermissions;
    }

    public void setActionPermissions(List<ActionPermissionCriteria> actionPermissions){
        this.actionPermissions = actionPermissions;
    }
    public ModelPermissionCriteria getModelPermission(){
        return this.modelPermission;
    }

    public void setModelPermission(ModelPermissionCriteria modelPermission){
        this.modelPermission = modelPermission;
    }
    public List<ModelPermissionCriteria> getModelPermissions(){
        return this.modelPermissions;
    }

    public void setModelPermissions(List<ModelPermissionCriteria> modelPermissions){
        this.modelPermissions = modelPermissions;
    }
}
