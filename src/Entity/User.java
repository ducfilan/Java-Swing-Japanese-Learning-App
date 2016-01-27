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
 *Class user, chua ID, ten, duong dan Avata, diem (chua biet la diem j :v) 
 */
public class User {

    private String userID;
    private String userName;
    private String userAvatar;
    private Double userScore;

    public User(String userID, String userName, String userAvatar, Double userScore) {
        this.userID = userID;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.userScore = userScore;
    }

    public User() {
        this.userScore = 0.0;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }
}
