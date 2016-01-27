/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Giang
 */
/*
 * Class bai hoc, chua ID va ten bai hoc
 */
public class Lesson {
    private int lessonID;
    private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
    
}

