package be.g00glen00b.portal.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class ApiKeys {

    @Size(min = 1, max = 40, message = "size.private")
    @NotNull(message = "notEmpty.private")
    private String privateKey;
    
    @Size(min = 1, max = 32, message = "size.public")
    @NotNull(message = "notEmpty.public")
    private String publicKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}