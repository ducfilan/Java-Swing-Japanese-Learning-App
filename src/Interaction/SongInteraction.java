/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaction;

import Entity.Song;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Giang
 */
public class SongInteraction {
    //Lay thong tin bai hat

    public static Vector readSong() {
        String sql = "select * from tbSong";
        Vector vt = new Vector();
        ResultSet rs = DataInteraction.createResultSet(sql);
        try {
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getInt("id"));
                temp.add(rs.getString("songName"));
                temp.add(rs.getString("songPath"));
                temp.add(rs.getString("japLyric"));
                temp.add(rs.getString("vieLyric"));
                vt.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return vt;
        }
    }
    //Sua thong tin 1 bai hat

    public static String updateSong(Song s) {
        String mess = "";
        int flag = DataInteraction.execQuery("update tbSong set songName = '" + s.getSongName()
                + "', JapLyric = '" + s.getJapLyric()
                + "', VieLyric = '" + s.getVieLyric()
                + "'where id =" + s.getID());

        if (flag == 0) {
            mess = "Update fail";
        } else if (flag == -1) {
            mess = "SQL Exception";
        } else {
            mess = "Update successfully";
        }
        return mess;
    }
    //Them 1 bai hat

    public static String insertSong(Song s) {
        String mess = "";
        String sql = "insert into tbSong(songName, songPath, japLyric, vieLyric ) values ( ?, ?, ?, ?)";
        
        try {
            PreparedStatement prs = DataInteraction.connect().prepareStatement(sql);
            prs.setString(1, s.getSongName());
            prs.setString(2, s.getSongPath());
            prs.setString(3, s.getJapLyric());
            prs.setString(4, s.getVieLyric());
            prs.executeUpdate();

            mess = "Create Successfully";
        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = "Create Fail";
        }
        return mess;
    }
    //Xoa 1 bai hat

    public static String deleteSong(int ID) {
        String mess = "";
        int flag = DataInteraction.execQuery("delete from tbSong where id = " + ID);
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
