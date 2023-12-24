package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.Permission;
import ma.zs.easystock.dao.criteria.core.stock.PermissionCriteria;
import ma.zs.easystock.service.facade.admin.stock.PermissionAdminService;
import ma.zs.easystock.ws.converter.stock.PermissionConverter;
import ma.zs.easystock.ws.dto.stock.PermissionDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.easystock.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/permission/")
public class PermissionRestAdmin  extends AbstractController<Permission, PermissionDto, PermissionCriteria, PermissionAdminService, PermissionConverter> {



    @Operation(summary = "upload one permission")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple permissions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all permissions")
    @GetMapping("")
    public ResponseEntity<List<PermissionDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a permission by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PermissionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  permission")
    @PostMapping("")
    public ResponseEntity<PermissionDto> save(@RequestBody PermissionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  permission")
    @PutMapping("")
    public ResponseEntity<PermissionDto> update(@RequestBody PermissionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of permission")
    @PostMapping("multiple")
    public ResponseEntity<List<PermissionDto>> delete(@RequestBody List<PermissionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified permission")
    @DeleteMapping("")
    public ResponseEntity<PermissionDto> delete(@RequestBody PermissionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified permission")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple permissions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by actionPermission id")
    @GetMapping("actionPermission/id/{id}")
    public List<PermissionDto> findByActionPermissionId(@PathVariable Long id){
        return findDtos(service.findByActionPermissionId(id));
    }
    @Operation(summary = "delete by actionPermission id")
    @DeleteMapping("actionPermission/id/{id}")
    public int deleteByActionPermissionId(@PathVariable Long id){
        return service.deleteByActionPermissionId(id);
    }
    @Operation(summary = "find by modelPermission id")
    @GetMapping("modelPermission/id/{id}")
    public List<PermissionDto> findByModelPermissionId(@PathVariable Long id){
        return findDtos(service.findByModelPermissionId(id));
    }
    @Operation(summary = "delete by modelPermission id")
    @DeleteMapping("modelPermission/id/{id}")
    public int deleteByModelPermissionId(@PathVariable Long id){
        return service.deleteByModelPermissionId(id);
    }
    @Operation(summary = "Finds permissions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PermissionDto>> findByCriteria(@RequestBody PermissionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated permissions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PermissionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports permissions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PermissionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets permission data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PermissionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PermissionRestAdmin (PermissionAdminService service, PermissionConverter converter) {
        super(service, converter);
    }




}
