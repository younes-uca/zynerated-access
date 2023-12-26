package ma.zs.easystock.zynerator.security.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.security.bean.Permission;
import ma.zs.easystock.zynerator.security.ws.dto.PermissionDto;

@Component
public class PermissionConverter extends AbstractConverter<Permission, PermissionDto> {

    @Autowired
    private ActionPermissionConverter actionPermissionConverter ;
    @Autowired
    private ModelPermissionConverter modelPermissionConverter ;
    private boolean actionPermission;
    private boolean modelPermission;

    public  PermissionConverter(){//ActionPermission actionPermissionModelPermission modelPermission,){
        super(Permission.class, PermissionDto.class);
        //this.actionPermission =  actionPermission ;
        //this.modelPermission =  modelPermission ;
    }

    @Override
    public Permission toItem(PermissionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Permission item = new Permission();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getSubAttribute()))
                item.setSubAttribute(dto.getSubAttribute());
            if(dto.getValue() != null)
                item.setValue(dto.getValue());
            if(this.actionPermission && dto.getActionPermission()!=null &&  dto.getActionPermission().getId() != null)
                item.setActionPermission(actionPermissionConverter.toItem(dto.getActionPermission())) ;

            if(this.modelPermission && dto.getModelPermission()!=null &&  dto.getModelPermission().getId() != null)
                item.setModelPermission(modelPermissionConverter.toItem(dto.getModelPermission())) ;




        return item;
        }
    }

    @Override
    public PermissionDto toDto(Permission item) {
        if (item == null) {
            return null;
        } else {
            PermissionDto dto = new PermissionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getSubAttribute()))
                dto.setSubAttribute(item.getSubAttribute());
                dto.setValue(item.getValue());
        if(this.actionPermission && item.getActionPermission()!=null) {
            dto.setActionPermission(actionPermissionConverter.toDto(item.getActionPermission())) ;
        }
        if(this.modelPermission && item.getModelPermission()!=null) {
            dto.setModelPermission(modelPermissionConverter.toDto(item.getModelPermission())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.actionPermission = value;
        this.modelPermission = value;
    }


    public ActionPermissionConverter getActionPermissionConverter(){
        return this.actionPermissionConverter;
    }
    public void setActionPermissionConverter(ActionPermissionConverter actionPermissionConverter ){
        this.actionPermissionConverter = actionPermissionConverter;
    }
    public ModelPermissionConverter getModelPermissionConverter(){
        return this.modelPermissionConverter;
    }
    public void setModelPermissionConverter(ModelPermissionConverter modelPermissionConverter ){
        this.modelPermissionConverter = modelPermissionConverter;
    }
    public boolean  isActionPermission(){
        return this.actionPermission;
    }
    public void  setActionPermission(boolean actionPermission){
        this.actionPermission = actionPermission;
    }
    public boolean  isModelPermission(){
        return this.modelPermission;
    }
    public void  setModelPermission(boolean modelPermission){
        this.modelPermission = modelPermission;
    }
}
