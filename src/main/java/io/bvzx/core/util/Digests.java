package io.bvzx.core.util;

import com.google.common.base.Strings;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: Digests
 * @date 2016年06月30日 09:38
 * @Copyright (c) 2015-2020 by caitu99
 */
public class Digests {

    public static final String DEFAULT_DIGEST_AES = "SHA1";

    public static final String DEFAULT_DIGEST_MD5 = "MD5";

    public static final String DEFAULT_CHARSET = "UTF-8";

    private String algorithmType;

    private Charset charset;

    private MessageDigest messageDigest;

    private static boolean checkAlgorithmType(String algorithmParam) {
        if (algorithmParam.equalsIgnoreCase(DEFAULT_DIGEST_AES) ||
                algorithmParam.equalsIgnoreCase(DEFAULT_DIGEST_MD5)) {
            return true;
        }
        throw new IllegalStateException("Please assign the correct encryption algorithm [ MD5 or SHA1]");
    }

    /**
     *
     * @param algorithmParam 算法类型
     * @return
     */
    public static Digests assign(String algorithmParam) {
        checkAlgorithmType(algorithmParam);
        return assign(algorithmParam, DEFAULT_CHARSET);
    }

    /**
     *
     * @param algorithmParam 算法类型
     * @param charset 字符集
     * @return
     */
    public static Digests assign(String algorithmParam, String charset) {
        checkAlgorithmType(algorithmParam);
        return assign(algorithmParam, Charset.forName(DEFAULT_CHARSET));
    }

    /**
     *
     * @param algorithmParam 算法类型
     * @param charset 字符集
     * @return
     */
    public static Digests assign(String algorithmParam, Charset charset) {
        checkAlgorithmType(algorithmParam);
        return new Digests(algorithmParam, charset);
    }


    private Digests(String algorithmParam, Charset charset) {
        this.algorithmType = algorithmParam;
        this.charset = charset;
    }

    /**
     *
     * @param input 输入参数
     * @return
     */
    public String encrypt(String input) {
        checkAlgorithmType(this.algorithmType);
        try {
            if (Strings.isNullOrEmpty(input)) {
                return "";
            }

            messageDigest = MessageDigest.getInstance(algorithmType);

            byte[] password = input.getBytes(charset);
            password = messageDigest.digest(password);

            StringBuilder ret = new StringBuilder(password.length << 1);
            for (int i = 0; i < password.length; i++) {
                ret.append(Character.forDigit((password[i] >> 4) & 0xf, 16));
                ret.append(Character.forDigit(password[i] & 0xf, 16));
            }

            return ret.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *检验密码
     * @param clearKey 明文
     * @param password 加密密码
     * @return
     */
    public boolean checkPassword(String clearKey, String password){
        return encrypt(clearKey).equalsIgnoreCase(password);
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public static void main(String[] args){
        log(Digests.assign("MD5").encrypt("123456"));
        log(Digests.assign("MD5").checkPassword("123456","2312312"));
    }

    public static void log(Object content){
        System.out.println(content.toString());
    }

}
