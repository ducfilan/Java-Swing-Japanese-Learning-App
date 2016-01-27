/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interaction;

import Entity.Lesson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Giang
 */
public class LessonInteraction {
    //lay thong tin ten bai hoc va ID
    public static Vector readLesson()
    {
        String sql="select * from tbLesson";
        Vector vt= new Vector();
        ResultSet rs= DataInteraction.createResultSet(sql);
        try {
            while(rs.next())
            {
                Vector temp= new Vector();
                temp.add(rs.getInt(1));
                temp.add(rs.getString(2));
                vt.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally
        {
            return vt;
        }
    }
    //Them 1 bai hoc moi vao database
     public static String insertLesson(Lesson l) {
        String mess = "";
        String sql = "insert into tbLesson(LessonName) values (?)";
        
        try {
            PreparedStatement prs = DataInteraction.connect().prepareStatement(sql);
            prs.setString(1, l.getLessonName());
            
            prs.executeUpdate();

            mess = "Create Successfully";
        } catch (SQLException ex) {
            ex.printStackTrace();
            mess = "Create Fail";
        }
        return mess;
    }
  
    //Sua thong tin 1 bai hoc
     public static String updateLesson(Lesson ls)
    {
        String mess="";
        int flag = DataInteraction.execQuery("update [tbLesson] set LessonName = '" + ls.getLessonName() + "'where LessonID ="+ls.getLessonID());

        if(flag == 0 ) {
            mess="Update fail";
        }
        else if(flag == -1 ) {
            mess="SQL Exception";
        }
        else {
            mess="Update successfully";
        }
        return mess;
    }
     //Xoa 1 bai hoc
      public static String deleteLesson(int ID) {
        String mess = "";
        int flag = DataInteraction.execQuery("delete from tbLesson where id = " + ID);
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
