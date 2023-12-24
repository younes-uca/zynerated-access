package  ma.zs.easystock.ws.dto.stock;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionDto  extends AuditBaseDto {

    private String subAttribute  ;
    private Boolean value  ;

    private ActionPermissionDto actionPermission ;
    private ModelPermissionDto modelPermission ;



    public PermissionDto(){
        super();
    }



    @Log
    public String getSubAttribute(){
        return this.subAttribute;
    }
    public void setSubAttribute(String subAttribute){
        this.subAttribute = subAttribute;
    }

    @Log
    public Boolean getValue(){
        return this.value;
    }
    public void setValue(Boolean value){
        this.value = value;
    }


    public ActionPermissionDto getActionPermission(){
        return this.actionPermission;
    }

    public void setActionPermission(ActionPermissionDto actionPermission){
        this.actionPermission = actionPermission;
    }
    public ModelPermissionDto getModelPermission(){
        return this.modelPermission;
    }

    public void setModelPermission(ModelPermissionDto modelPermission){
        this.modelPermission = modelPermission;
    }






}
