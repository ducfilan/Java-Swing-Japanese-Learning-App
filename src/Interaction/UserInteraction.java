/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaction;

import Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Giang
 */
public class UserInteraction {

    public static Vector readUser() {
        String sql = "select * from tbUser";
        Vector vt = new Vector();
        ResultSet rs = DataInteraction.createResultSet(sql);
        try {
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getInt("id"));
                temp.add(rs.getString("userName"));
                temp.add(rs.getString("userPath"));
                vt.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return vt;
        }
    }
    //

    public static String updateUserName(User ur) {
        String mess = "";
        int flag = DataInteraction.execQuery("update tbUser set userScore = " + ur.getUserScore()
                + "where id =" + ur.getUserName());

        if (flag == 0) {
            mess = "Update fail";
        } else if (flag == -1) {
            mess = "SQL Exception";
        } else {
            mess = "Update successfully";
        }
        return mess;
    }
    //

    public static String insertUser(User ur) {
        String mess = "";
        String sql = "insert into tbUser(userName, userPath, userScore) values (?, ?, ?)";

        try {
            PreparedStatement prs = DataInteraction.connect().prepareStatement(sql);
            prs.setString(1, ur.getUserName());
            prs.setString(2, ur.getUserAvatar());
            prs.setDouble(3, ur.getUserScore());
            prs.executeUpdate();

            mess = "Create Successfully";
        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = "Create Fail";
        }
        return mess;
    }
}
