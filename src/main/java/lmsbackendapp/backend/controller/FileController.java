package lmsbackendapp.backend.controller;

import lmsbackendapp.backend.service.FileService;
import org.apache.tika.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/images/{type}/{file}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getFileFromImages(@PathVariable String type, @PathVariable String file) throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/images/" + type +"/"+ file);
        byte[] bytes = IOUtils.toByteArray(fis);
        fis.close();
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
