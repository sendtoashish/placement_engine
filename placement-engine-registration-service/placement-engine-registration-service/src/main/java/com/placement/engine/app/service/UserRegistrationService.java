package com.placement.engine.app.service;


import com.placement.engine.app.DAO.UserRegistrationDAO;
import com.placement.engine.app.entity.CV;
import com.placement.engine.app.entity.UserAddress;
import com.placement.engine.app.entity.UserRegistration;
import com.placement.engine.app.exception.ApplicationException;
import com.placement.engine.app.exception.ErrorStatus;
import com.placement.engine.app.utility.RandomGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserRegistrationService {

    @Autowired
    private UserRegistrationDAO userRegistration;


    public void addUser(UserRegistration user) {
       log.info("Saving the user");
        List<UserRegistration> userInDB  = userRegistration.findAll();
        if(!userInDB.isEmpty()){
           UserRegistration registeredUser = userInDB.stream().filter(u ->u.getEmail().equals(user.getEmail()))
                   .findFirst().orElse(null);

           if(registeredUser != null){
               log.error("User already exists");
               throw new ApplicationException(ErrorStatus.DUPLICATE_RECORD,"User is already Registered");
           }
        }
        String uniqueIdentity = RandomGeneratorUtil.encrypt(user.getEmail());
        user.setUuid(uniqueIdentity);
//        String FilePath = Folder;
//        CV cv = new CV();
//        cv.setFileName(file.getOriginalFilename());
//        cv.setFileType(file.getContentType());
//        String filepath = FilePath+file.getOriginalFilename();
//        cv.setFilePath(filepath);
//        file.transferTo(new File(filepath));
//        user.setCv(cv);

//        need to discuss this in class
//        for(UserAddress add: user.getAddress()){
//            add.setUser(user);

//        }
        userRegistration.save(user);

    }

//    public byte[] findCVofUser(String email) throws IOException {

//        UserRegistration u = userRegistration.findUserByemail(email);
//        String filepath = u.getCv().getFilePath();
//        byte[] cv = Files.readAllBytes(new File(filepath).toPath());
//        return cv;
//    }

    public List<UserRegistration> findAllUsers(){
        List<UserRegistration> users = userRegistration.findAll();
        List<UserRegistration> user =new ArrayList<>();
        for(UserRegistration u : users){
            UserRegistration newUser = new UserRegistration();
            newUser.setName(u.getName());
            newUser.setEmail(u.getEmail());
            newUser.setUuid(u.getUuid());
//            newUser.setUser_status(u.get);

//            CV cv = new CV();
//            cv.setFileName(u.getCv().getFileName());
//            cv.setFileType(u.getCv().getFileType());
//            cv.setFilePath(u.getCv().getFilePath());
//            newUser.setCv(cv);

//            List<UserAddress> address = new ArrayList<>();
//            for(UserAddress a : u.getAddress()){
//                UserAddress add = new UserAddress();
//                add.setCity(a.getCity());
//                add.setStreet(a.getStreet());
//                add.setState(a.getState());
//                address.add(add);
//            }
//            newUser.setAddress(address);
            user.add(newUser);
        }
        return user;
    }

    public String findByUsername(String username){
        return userRegistration.findByUsername(username);
    }
}
