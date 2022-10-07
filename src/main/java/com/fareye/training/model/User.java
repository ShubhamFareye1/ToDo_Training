package com.fareye.training.model;

import com.fareye.training.utility.EncryptDecryptUtil;
import com.fareye.training.utility.EncryptionDecryptionUsingHash;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
@Getter @Setter @NoArgsConstructor
public class User {
    @NotNull
    private String firstName;

    private String lastName;
    @Email
    private String email;

    private boolean verified;

    private LocalDate created;

    private Date modified;

    private String password;

    private String role;

    private boolean active;


    public void setPassword(String password) throws Exception {
        EncryptDecryptUtil e = new EncryptDecryptUtil();
        e.init();
        this.password = e.encrypt(password);
        System.out.println(password);
        System.out.println(e.decrypt(this.password));

        EncryptionDecryptionUsingHash he = new EncryptionDecryptionUsingHash();
        String temp = he.encrypt("Shubham");
        System.out.println(he.decrypt(temp));
    }

}