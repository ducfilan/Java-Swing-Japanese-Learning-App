/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaction;

import Entity.Word;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Giang
 */
public class WordInteraction {

    public static Vector readWordByLId(int LId) {
        String sql = "select * from tbWord where LessonID = " + LId;
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
                temp.add(rs.getInt(6));
                vt.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return vt;
        }
    }
    //Sua thong tin 1 bai hat

    public static String updateWord(Word word) {
        String mess = "";
        int flag = DataInteraction.execQuery("update tbWord set kanji = '" + word.getKanji()
                + "', furigana = '" + word.getFurigana()
                + "', meaning = '" + word.getMeaning()
                + "', image = '" + word.getImage()
                + "', lessonId = " + word.getLessonID()
                + "   where id =" + word.getWordID());

        if (flag == 0) {
            mess = "Update fail";
        } else if (flag == -1) {
            mess = "SQL Exception";
        } else {
            mess = "Update successfully";
        }
        return mess;
    }
    //Them 1 tu

    public static String insertWord(Word w) {
        String mess = "";
        String sql = "insert into tbword(kanji, furigana, meaning, image, lessonId ) values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement prs = DataInteraction.connect().prepareStatement(sql);
            prs.setString(1, w.getKanji());
            prs.setString(2, w.getFurigana());
            prs.setString(3, w.getMeaning());
            prs.setString(4, w.getImage());
            prs.setInt(5, w.getLessonID());
            prs.executeUpdate();

            mess = "Create Successfully";
        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = "Create Fail";
        }
        return mess;
    }
    //Xoa 1 tu

    public static String deleteWord(int ID) {
        String mess = "";
        int flag = DataInteraction.execQuery("delete from tbWord where id = " + ID);
        if (flag == 0) {
            mess = "Delete fail";
        } else if (flag == -1) {
            mess = "SQL Exception";
        } else {
            mess = "Delete successfully";
        }
        return mess;
    }

    //Xoa tu theo Lesson ID
    public static String deleteWordByLessonId(int lID) {
        String mess = "";
        int flag = DataInteraction.execQuery("delete from tbWord where lessonid = " + lID);
        if (flag == 0) {
            mess = "Delete fail";
        } else if (flag == -1) {
            mess = "SQL Exception";
        } else {
            mess = "Delete successfully";
        }
        return mess;
    }
    
    //Xoa tu theo Word ID
    public static String deleteWordByWordId(int wID) {
        String mess = "";
        int flag = DataInteraction.execQuery("delete from tbWord where id = " + wID);
        if (flag == 0) {
            mess = "Delete fail";
        } else if (flag == -1) {
            mess = "SQL Exception";
        } else {
            mess = "Delete successfully";
        }
        return mess;
    }
}
