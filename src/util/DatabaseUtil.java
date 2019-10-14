package util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil { // DB와 연동되는 부분을 정의
    // private AESDec aes;
    private static BasicDataSource dataSource = new BasicDataSource();
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dontcallme";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "example";

    public static void init() {
        // setUrl Note: this method currently has no effect once the pool has been initialized. The pool is initialized the first time one of the following methods is invoked: getConnection, setLogwriter, setLoginTimeout, getLoginTimeout, getLogWriter.
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASS);

        /*
        root로 해야하나?...
        null.. 컴파일 환경 차이..? 내 컴퓨터에서 하면 안나오지만, 도커에서 컴파일하면 환경변수가 있어서 불러오기 가능?
        dataSource.setUrl(System.getProperty("JDBC_URL"));
        dataSource.setUsername(System.getProperty("JDBC_USER"));
        dataSource.setPassword(System.getProperty("JDBC_PASS"));*/
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}

/*
            dataSource.setUrl(System.getProperty("JDBC_URL"));
        dataSource.setUsername(System.getProperty("JDBC_USER"));
        dataSource.setPassword(System.getProperty("JDBC_PASS"));

        ? 통하나? 컨테이너에서 돌릴떄라서 이건..

    public Connection getConnection() throws GeneralSecurityException {
        AESDec aes = null;
        FileInputStream fis = null;
        FileInputStream key_fis = null;
        try {
            // ★ it must be tested!!
            String propFile = "util\\key.properties";
            Properties props = new Properties();
            fis = new FileInputStream(propFile);
            props.load(new java.io.BufferedInputStream(fis));

            String read_key = "util\\keymanagement.properties";
            Properties key = new Properties();
            key_fis = new FileInputStream(read_key);
            key.load(new java.io.BufferedInputStream(key_fis));

            String aes_key = key.getProperty("key");
            if (aes_key != null) { //true
                aes = new AESDec(aes_key);
            }



            String dbURL = "jdbc:mysql://localhost:3306/dontcallme?characterEncoding=UTF-8&serverTimezone=UTC";
            String dbID = "root";
            String dbPassword = ""; // =props.getProperty("password");

            if (aes != null) { //true
                String temp = aes.aesEncode(props.getProperty("password"));
                dbPassword = aes.aesDecode(temp);
            }

            if (dbPassword != null) {
                Class.forName("com.mysql.jdbc.Driver");
                return ds.getConnection();
            }

//			if (fis != null)
//				fis.close();
//			if (key_fis != null)
//				key_fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) try {
                fis.close();
            } catch (IOException e) {
                System.err.println("UserDAO IOException error");
            }
            if (key_fis != null) try {
                key_fis.close();
            } catch (IOException e) {
                System.err.println("UserDAO IOException error");
            }
        }
        return null; // 오류가 발생한경우 null 반환
    }  */

