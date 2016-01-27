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
 * Class bai hat, gom ID, ten bai hat, duong dan path, lyric jap va vie
 */
public class Song {
    private int id;
    private String songName;
    private String songPath;
    private String japLyric;
    private String VieLyric;

    public Song(int ID, String songName, String songPath, String japLyric, String VieLyric) {
        this.id = ID;
        this.songName = songName;
        this.songPath = songPath;
        this.japLyric = japLyric;
        this.VieLyric = VieLyric;
    }
      public Song( String songName, String songPath, String japLyric, String VieLyric) {
        this.songName = songName;
        this.songPath = songPath;
        this.japLyric = japLyric;
        this.VieLyric = VieLyric;
    }

    public Song() {
         this.id = 0;
        this.songName = null;
        this.songPath = null;
        this.japLyric = null;
        this.VieLyric = null;
       // throw new UnsupportedOperationException("Not yet implemented");
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getJapLyric() {
        return japLyric;
    }

    public void setJapLyric(String japLyric) {
        this.japLyric = japLyric;
    }

    public String getVieLyric() {
        return VieLyric;
    }

    public void setVieLyric(String VieLyric) {
        this.VieLyric = VieLyric;
    }
    
}
