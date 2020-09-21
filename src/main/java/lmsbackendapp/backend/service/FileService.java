package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.PersonalData;
import lmsbackendapp.backend.model.Result;
import lmsbackendapp.backend.repository.FileRepository;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Optional;

@Service
public class FileService {
    private String defProfilePicturePath = "src/main/resources/images/profileImages/default.png";

    @Autowired
    private FileRepository fileRepo;

    public void savedProfileImage(MultipartFile file, String fileName, PersonalData personalData) throws IOException {
        Tika tika = new Tika();
        String mimType = tika.detect(file.getBytes());
        if (file != null && (mimType.equals("image/png") || mimType.equals("image/jpeg"))) {
            File convertFile = new File("src/main/resources/images/profileImages/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
            personalData.setPathProfilePic("images/profileImages/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        } else {
            InputStream initialStream = new FileInputStream(new File(defProfilePicturePath));
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File targetFile = new File("src/main/resources/images/profileImages/" + fileName + defProfilePicturePath.substring(defProfilePicturePath.lastIndexOf(".")));
            targetFile.createNewFile();
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
            initialStream.close();
            outStream.close();
            personalData.setPathProfilePic("images/profileImages/" + fileName + defProfilePicturePath.substring(defProfilePicturePath.lastIndexOf(".")));
        }
    }
    public void saveResultIcon(MultipartFile file, String fileName, Result iData) throws IOException {
        Tika tika = new Tika();
        String mimeType = tika.detect(file.getBytes());
        if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg"))) {
            File convertFile = new File("src/main/resources/images/topicIcons/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
            iData.setPathToIcon("images/topicIcons/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        }
    }
    public Iterable<Optional<lmsbackendapp.backend.model.File>> getFileBySubject(Long id){
        return fileRepo.getAllBySubject(id);
    }



}
