/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author 3T's
 */
public class TestInteraction {
    public static Vector readTest() {
        String sql = "select * from tbTest";
        Vector vt = new Vector();
        ResultSet rs = DataInteraction.createResultSet(sql);
        try {
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getInt(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                temp.add(rs.getString(6));
                temp.add(rs.getInt(7));
                temp.add(rs.getString(8));
                temp.add(rs.getInt(9));
                vt.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return vt;
        }
    }
     public static Vector readTestBySetID(int LId) {
        String sql = "select * from tbTest where setID = " + LId;
        Vector vt = new Vector();
        ResultSet rs = DataInteraction.createResultSet(sql);
        try {
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getInt(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                temp.add(rs.getString(6));
                temp.add(rs.getInt(7));
                temp.add(rs.getString(8));
                temp.add(rs.getInt(9));
                vt.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return vt;
        }
    }
}
