package com.placement.engine.app.service;

import com.placement.engine.app.DAO.UserDetailsDAO;
import com.placement.engine.app.DAO.UserRegistrationDAO;
import com.placement.engine.app.DAO.otpDAO;
import com.placement.engine.app.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.Random;

@Service
public class UserDetailsService {


    @Autowired
    private UserDetailsDAO userDetailsDAO;

    @Autowired
    private UserRegistrationDAO userRegistrationDAO;

    @Autowired
    private otpDAO otpdao;
    private String Folder = "C:\\Users\\bhard\\placement_files\\";


    @Bean
    private OtpInfo getOtpInfo() {
        return new OtpInfo();
           }
    public Otp saveUserDetails(UserDetails user, MultipartFile file) throws IOException {

        CV cv = new CV();
        cv.setFileName(file.getName());
        cv.setFileType(file.getContentType());
        String filePath = Folder+file.getOriginalFilename();
        Path mypath = Paths.get(filePath);
        boolean fileDeleted=Files.deleteIfExists(mypath);
        if(fileDeleted == false){
            file.transferTo(new File(filePath));

        }else{
            file.transferTo(new File(filePath));

        }
        cv.setFilePath(filePath);

        user.setCv(cv);
        UserRegistration u = userRegistrationDAO.findUserByemail(user.getEmail());
        user.setUserRegistration(u);
        //GENERATING OTP
        Random rand = new Random();
        int otpvalue = rand.nextInt(1000);
        OtpInfo otp = getOtpInfo();
        otp.setOtpValue(otpvalue);
        otp.setTime(new Time(System.currentTimeMillis()));
        otp.setUserRegistration(u);
        otpdao.save(otp);
        userDetailsDAO.save(user);

       String uuid =  u.getUuid();
       return new Otp(otpvalue,uuid);


    }

    public String otpVerification(int otp , String uuid){
        UserRegistration user = userRegistrationDAO.findUserByUID(uuid);
        int otpFromDB=user.getOtpinfo().getOtpValue();
        if(otp == otpFromDB){
            user.setUser_status(true);
            userRegistrationDAO.save(user);
            return "User is registered and active now";
        }else{
            return "otp values didnot match try again";
        }
    }

}
