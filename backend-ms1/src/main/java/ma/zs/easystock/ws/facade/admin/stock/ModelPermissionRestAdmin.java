package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.ModelPermission;
import ma.zs.easystock.dao.criteria.core.stock.ModelPermissionCriteria;
import ma.zs.easystock.service.facade.admin.stock.ModelPermissionAdminService;
import ma.zs.easystock.ws.converter.stock.ModelPermissionConverter;
import ma.zs.easystock.ws.dto.stock.ModelPermissionDto;
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
@RequestMapping("/api/admin/modelPermission/")
public class ModelPermissionRestAdmin  extends AbstractController<ModelPermission, ModelPermissionDto, ModelPermissionCriteria, ModelPermissionAdminService, ModelPermissionConverter> {



    @Operation(summary = "upload one modelPermission")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple modelPermissions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all modelPermissions")
    @GetMapping("")
    public ResponseEntity<List<ModelPermissionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all modelPermissions")
    @GetMapping("optimized")
    public ResponseEntity<List<ModelPermissionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a modelPermission by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModelPermissionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a modelPermission by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ModelPermissionDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ModelPermission(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  modelPermission")
    @PostMapping("")
    public ResponseEntity<ModelPermissionDto> save(@RequestBody ModelPermissionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  modelPermission")
    @PutMapping("")
    public ResponseEntity<ModelPermissionDto> update(@RequestBody ModelPermissionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of modelPermission")
    @PostMapping("multiple")
    public ResponseEntity<List<ModelPermissionDto>> delete(@RequestBody List<ModelPermissionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified modelPermission")
    @DeleteMapping("")
    public ResponseEntity<ModelPermissionDto> delete(@RequestBody ModelPermissionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified modelPermission")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple modelPermissions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds modelPermissions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ModelPermissionDto>> findByCriteria(@RequestBody ModelPermissionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated modelPermissions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ModelPermissionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports modelPermissions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ModelPermissionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets modelPermission data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ModelPermissionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ModelPermissionRestAdmin (ModelPermissionAdminService service, ModelPermissionConverter converter) {
        super(service, converter);
    }




}
