/*
 * Class contains methods using to validate input data
 * 
 */
package Interaction;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GiangNT
 */
/*
 * Ham kiem tra ki tu,trung lap du lieu, dem so hang trong 1 co (?)
 */
public class Validation {

    public static boolean isEmpty(String text) {
        if (text.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isCharacter(String text) {
        if (text.matches("^[a-zA-Z]+([\\s][a-zA-Z]+)*$")) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicateValue(String table, String column, String value) {
        String _sql = "select " + column + " from " + table + " where " + column + " like '" + value + "'";
        try {
            ResultSet rs = DataInteraction.createResultSet(_sql);
            if (!rs.first()) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return true;
        }
    }

    public static boolean isDuplicateValue(String table, String columnID, String valueID, String columnREF, String valueREF) {
        String _sql = "select " + columnREF + " from " + table + " where " + columnREF + " like '" + valueREF + "'"
                + "and " + columnID + " != '" + valueID + "'";
        try {
            ResultSet rs = DataInteraction.createResultSet(_sql);
            if (!rs.first()) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return true;
        }
    }
//Kiem tra lap tu
    public static boolean isDuplicateWord(String furigana, String meaning) {
        String _sql = "select (Furigana + Meaning) as PC from tbWord";
        try {
            ResultSet rs = DataInteraction.createResultSet(_sql);
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("PC").equalsIgnoreCase(furigana + meaning)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
