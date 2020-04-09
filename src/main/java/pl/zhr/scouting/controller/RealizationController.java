package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.zhr.scouting.entity.Realization;
import pl.zhr.scouting.payload.UploadFileResponse;
import pl.zhr.scouting.repository.RealizationRepository;
import pl.zhr.scouting.service.RealizationFileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/realizations")
@CrossOrigin(origins = "*")
public class RealizationController {

    @Autowired
    private RealizationRepository realizationRepositoryImpl;

    @Autowired
    private RealizationFileService realizationFileService;

    @GetMapping
    public List<Realization> realizationList(){

        return realizationRepositoryImpl.findAll();
    }

    @GetMapping("{realizationId}")
    public Realization findSingleRealization(@PathVariable int realizationId) {

        return realizationRepositoryImpl.findById(realizationId);
    }

//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//
//        Resource resource = realizationFileService.loadFileAsResource(fileName);
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex){
//            System.out.println("Could not determinate file type.");
//        }
//
////        Fallback to the default content type if type could not be determined
//        if(contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }

    @PostMapping("/user{userId}/quest{questId}")
    public void saveRealization(@PathVariable int userId,
                                @PathVariable int questId,
                                @RequestBody Realization tempRealization) {

        tempRealization.setRealizationId(0);
        realizationRepositoryImpl.saveOrUpdate(tempRealization, userId, questId);
        realizationRepositoryImpl.addRelationQuestReal(tempRealization.getRealizationId(), questId);
        realizationRepositoryImpl.setRealizationData(tempRealization.getRealizationId());
    }

//    @PostMapping("/uploadFile/real{realId}")
//    public UploadFileResponse uploadFile(@PathVariable int realId, @RequestParam("file") MultipartFile file) {
//
//        String fileName = realizationFileService.storeFile(file);
//        realizationRepositoryImpl.addFile(realId, fileName);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/realizations/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse (fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//
//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

    @PutMapping("{realizationId}/user{userId}/quest{questId}")
    public void updateRealization(@PathVariable int realizationId,
                                  @PathVariable int userId,
                                  @PathVariable int questId,
                                  @RequestBody Realization tempRealization){

        tempRealization.setRealizationId(realizationId);
        realizationRepositoryImpl.saveOrUpdate(tempRealization, userId, questId);
        realizationRepositoryImpl.setRealizationData(realizationId);
    }

    @DeleteMapping("{realizationId}")
    public void deleteRealization(@PathVariable int realizationId){

        realizationRepositoryImpl.removeRelationQuestReal(realizationId);
        realizationRepositoryImpl.delete(realizationId);
    }
}
