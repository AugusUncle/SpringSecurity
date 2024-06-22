package com.cb.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class EncryptionUtil {

    private static final String AES = "AES";

    // 实例变量，用于接收配置属性的值
    @Value("${app.secretKey}")
    private String secretKeyValue;

    // 静态变量，用于在静态方法中使用
    private static String secretKey;

    // 使用@PostConstruct注解的方法将实例变量的值赋给静态变量
    @PostConstruct
    public void init() {
        secretKey = this.secretKeyValue;
    }

    // 获取SecretKeySpec
    private static SecretKeySpec getSecretKeySpec() {
        return new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), AES);
    }

    // 加密方法
    public static String encrypt(String strToEncrypt) {
        try {
            SecretKeySpec secretKeySpec = getSecretKeySpec();
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting: " + e.toString());
        }
    }

    // 解密方法
    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeySpec secretKeySpec = getSecretKeySpec();
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting: " + e.toString());
        }
    }

    // 哈希密码
    public static String hashPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    // 匹配密码
    public static boolean matchPassword(String rawPassword, String encodedPassword) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);
    }
}
