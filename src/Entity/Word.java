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
 * Class tu moi, gom ID, chu kanji, furigana,y nghia, giai thich(neu co), duong dan anh?,va thuoc bai nao (lessomID)
 */
public class Word {

    private int WordID;
    private String kanji;
    private String furigana;
    private String meaning;
    private String image;
    private int lessonID;
//contructor

    public Word() {
        //do nothing :v
    }

    public Word(int WordID, String kanji, String furigana, String meaning, String image, int lessonID) {
        this.WordID = WordID;
        this.kanji = kanji;
        this.furigana = furigana;
        this.meaning = meaning;
        this.image = image;
        this.lessonID = lessonID;
    }

    public Word(String kanji, String furigana, String meaning, String image, int lessonID) {
        this.kanji = kanji;
        this.furigana = furigana;
        this.meaning = meaning;
        this.image = image;
        this.lessonID = lessonID;
    }
//setter and getter

    public int getWordID() {
        return WordID;
    }

    public void setWordID(int WordID) {
        this.WordID = WordID;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getFurigana() {
        return furigana;
    }

    public void setFurigana(String furigana) {
        this.furigana = furigana;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }
}
