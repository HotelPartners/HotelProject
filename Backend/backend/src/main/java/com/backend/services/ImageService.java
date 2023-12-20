package com.backend.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.daos.IMenuDAO;
import com.backend.pojos.MenuPOJO;

@Service
@Transactional
public class ImageService {
    
    @Autowired
    private IMenuDAO menuDAO;

    @Value("${content.upload.folder}")
    private String path;

    public String uploadImage(Long itemId,MultipartFile imageFile) throws IOException
    {
        String name=imageFile.getOriginalFilename();

        String randomId=UUID.randomUUID().toString();

        String finaFileName=randomId.concat(name.substring(name.lastIndexOf(".")));

        System.out.println(finaFileName+" ----------------------------");

        MenuPOJO menuPOJO=menuDAO.findById(itemId).get();

        String targetpath=path+File.separator+finaFileName;
        System.out.println(targetpath+" ---------------------");

        Files.copy(imageFile.getInputStream(), Paths.get(targetpath), StandardCopyOption.REPLACE_EXISTING);

        menuPOJO.setItemImage(finaFileName);
        return name;
    }

    public InputStream getResource (String filename) throws FileNotFoundException
    {
        String path="images/";
        String fullpath=path+File.separator+filename;
        InputStream is=new FileInputStream(fullpath);
        return is;
    }
}
