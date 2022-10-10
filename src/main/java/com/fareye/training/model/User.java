package com.fareye.training.model;
import com.fareye.training.service.GitAvatarService;
import com.fareye.training.utility.EncryptDecryptUtil;
import com.fareye.training.utility.EncryptionDecryptionUsingHash;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;


@Getter @Setter @NoArgsConstructor
public class User {
    @NotEmpty(message = "Firstname should not empty")
    private String firstName;

    private String lastName;

    @Email(message = "Entered mail is wrong")
    private String email;

    private boolean verified;

    private LocalDate created;

    private Date modified;
    @NotEmpty(message = "Password should not empty")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n",message = "Minimum eight and maximum 15 characters, at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    @NotEmpty(message = "role should not be empty")
    private String role;

    private boolean active;

    @NotEmpty(message = "github Username should not be empty")
    private String githubUsername;

    // we can use custom avatar_url link so that we can fetch link when we pass the username from post username details..
    public void setGithubUsername(String githubUsername) throws Exception {
          GitAvatarService a = new GitAvatarService();
          String avatar_url = a.avatar(githubUsername);
        //  String avatar_url= "hiiii";
          System.out.println("avatar = "+avatar_url);
          this.githubUsername = avatar_url;
    }

    //this following custom setPassword function is used to password encryption and we can remove this following code when we use DB.
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