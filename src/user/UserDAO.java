package user;

import java.security.GeneralSecurityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

// import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import util.DatabaseUtil;
import util.AESDec;

public class UserDAO {
    private String userID; //DB와 1대1로 연동되어 DB에 데이터를 기록하거나 가져오는 역할

    public int login(String userID, String userPassword) throws GeneralSecurityException, IOException {
        String SQL = "SELECT userPassword FROM CCTV WHERE userID = ? ";
        AESDec aes = new AESDec();
        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                if(aes.aesDecode(rs.getString(1)).contentEquals(userPassword)) {
                    return 1; //로그인 성공
                }
                else {
                    return 0; //비밀번호 틀림
                }
            }
            return -1; //아이디 없음
        } catch (SQLException e) {
            e.printStackTrace();
            return -2; //데이터베이스 오류
        }
    }


    public int join(UserDTO user) throws GeneralSecurityException, IOException {
        String SQL = "INSERT INTO CCTV VALUES(?, ?, ?, ?, ?, ?, false, ?, ?, ?, ?)"; //?는 사용자가 직접 입력한 값
        AESDec aes = new AESDec();
        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, aes.aesEncode(user.getUserPassword()));
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getUserGender());
            pstmt.setString(5, user.getUserEmail());
            pstmt.setString(6, user.getUserEmailHash());
            pstmt.setString(7, user.getUserIP1());
            pstmt.setString(8, user.getUserIP2());
            pstmt.setString(9, user.getUserIP3());
            pstmt.setString(10, user.getUserIP4());

            return pstmt.executeUpdate(); //insert문을 실행해서 나온 결과를 반환, 데이터를 1개 넣었다면 1을 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; //회원가입 실패
        }
    }

    public int update(UserDTO user) throws GeneralSecurityException, IOException  {
        String SQL = "UPDATE CCTV SET userPassword = ?, userName = ?, userEmail = ?, userIP1 = ?, userIP2 = ?, userIP3 = ?, userIP4 = ? WHERE userID = ?";
        AESDec aes = new AESDec();
        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, aes.aesEncode(user.getUserPassword()));
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setString(4, user.getUserIP1());
            pstmt.setString(5, user.getUserIP2());
            pstmt.setString(6, user.getUserIP3());
            pstmt.setString(7, user.getUserIP4());
            pstmt.setString(8, user.getUserID());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; //데이터베이스 오류
        }
    }

    public int remove(String userID) {
        String SQL = "DELETE FROM CCTV WHERE userID = ? ";

        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; //데이터베이스 오류
        }
    }


    public boolean getUserEmailChecked(String userID) {
        String SQL = "SELECT userEmailChecked FROM CCTV WHERE userID = ?"; //?는 사용자가 직접 입력한 값

        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //데이터베이스 오류
    }


    public String getUserEmail(String userID) {
        String SQL = "SELECT userEmail FROM CCTV WHERE userID = ?";

        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //데이터베이스 오류
    }


    public boolean setUserEmailChecked(String userID) {
        String SQL = "UPDATE CCTV SET userEmailChecked = true WHERE userID = ? ";

        try (Connection conn = DatabaseUtil.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; //데이터베이스 오류
        }
    }
}


//	public int Hash(UserDTO user) {
//		String SQL = "INSERT INTO CCTV (userEmailHash) VALUES(?)"; //?는 사용자가 직접 입력한 값
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(SQL); //데이터를 실제로 넣어줄 수 있는 역할
//			pstmt.setString(1, SHA256.getSHA256(userEmail));
//			return pstmt.executeUpdate(); //insert문을 실행해서 나온 결과를 반환
//													   //데이터를 1개 넣었다면 1을 반환
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
//			if(pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
//			if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
//		}
//		return -1; //삽입 실패
//	}




/*
        try (Connection conn = DatabaseUtil.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }


 */