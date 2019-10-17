package util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.io.BufferedInputStream;
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
    private static final String JDBC_URL = System.getenv("JDBC_URL");       // Runtime Environment Variables
    private static final String JDBC_USER = System.getenv("JDBC_USER");
    private static final String JDBC_PASS = System.getenv("JDBC_PASS");

    public static void init() {
        // setUrl Note: this method currently has no effect once the pool has been initialized. The pool is initialized the first time one of the following methods is invoked: getConnection, setLogwriter, setLoginTimeout, getLoginTimeout, getLogWriter.
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASS);
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}


/*
? .properties 에서 비밀번호를 가져오는것이 아니라 docker-compose.yml 에서 가져와서 별 필요없는듯?.. ?.. 암호화의 범위를 정해야함..

    public Connection getConnection() throws GeneralSecurityException {
        AESDec aes = null;
        String propFile = "src\\util\\key.properties";
        String read_key = "src\\util\\keymanagement.properties";

        try (FileInputStream fis = new FileInputStream(propFile);
             FileInputStream key_fis = new FileInputStream(read_key)) {
            Properties props = new Properties();
            props.load(new BufferedInputStream(fis));

            Properties key = new Properties();
            key.load(new BufferedInputStream(key_fis));

            String aes_key = key.getProperty("key");
            if (aes_key != null) { //true
                aes = new AESDec(aes_key);
            }

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
            return null;
        }
        return null; // 오류가 발생한경우 null 반환
    }

 */