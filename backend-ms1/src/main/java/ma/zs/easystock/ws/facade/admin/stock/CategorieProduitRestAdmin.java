package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.CategorieProduit;
import ma.zs.easystock.dao.criteria.core.stock.CategorieProduitCriteria;
import ma.zs.easystock.service.facade.admin.stock.CategorieProduitAdminService;
import ma.zs.easystock.ws.converter.stock.CategorieProduitConverter;
import ma.zs.easystock.ws.dto.stock.CategorieProduitDto;
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
@RequestMapping("/api/admin/categorieProduit/")
public class CategorieProduitRestAdmin  extends AbstractController<CategorieProduit, CategorieProduitDto, CategorieProduitCriteria, CategorieProduitAdminService, CategorieProduitConverter> {



    @Operation(summary = "upload one categorieProduit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categorieProduits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categorieProduits")
    @GetMapping("")
    public ResponseEntity<List<CategorieProduitDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categorieProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieProduitDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categorieProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a categorieProduit by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<CategorieProduitDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new CategorieProduit(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  categorieProduit")
    @PostMapping("")
    public ResponseEntity<CategorieProduitDto> save(@RequestBody CategorieProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categorieProduit")
    @PutMapping("")
    public ResponseEntity<CategorieProduitDto> update(@RequestBody CategorieProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categorieProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieProduitDto>> delete(@RequestBody List<CategorieProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categorieProduit")
    @DeleteMapping("")
    public ResponseEntity<CategorieProduitDto> delete(@RequestBody CategorieProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categorieProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categorieProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds categorieProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieProduitDto>> findByCriteria(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categorieProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categorieProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categorieProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategorieProduitRestAdmin (CategorieProduitAdminService service, CategorieProduitConverter converter) {
        super(service, converter);
    }




}
