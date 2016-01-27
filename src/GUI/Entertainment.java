/*
 * StartPannel: Display the menu for the user to select
 */

/*
 * StartPanel.java
 *
 */
package GUI;

import Entity.Song;
import Interaction.SongInteraction;
import Interaction.TestInteraction;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import syntaxcandy.mp3.Mp3;

public class Entertainment extends javax.swing.JPanel {

    public static int x;
    public static int y;
    Timer t;
    int i = 0;
    private static int mark = 0;
    private int rowE = 0;
    int choice = 0;
    private int a = 0;
    private int life = 4;
    private int flag = 0;
    private boolean run = true;

    /**
     * Creates new form StartPanel
     */
    public Entertainment() {
        initComponents();
        fillTable();
        fillTbWord();

        tbSong.setGridColor(new java.awt.Color(204, 204, 204));
        tbSong.setSelectionBackground(new Color(199, 251, 111));
        tbSong.setSelectionForeground(new Color(0, 0, 0));
    }
    ///game

    public void game1() {

        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i += (Math.random() * 10);
                if (i >= 100 || a == 1) {
                    NextWord(true);
                    a = 0;
                    if (!mark(choice)) {
                        life = life - 1;
                    }
                    //else if(i > = 100)
                    //System.out.println(life);
                    i = 0;

                    jProgressBar.setValue(i);
                    jProgressBar.setStringPainted(true);
                }
                if (i != 0) {
                    jProgressBar.setValue(i);
                    jProgressBar.setStringPainted(true);
                }
                if (life == 2) {
                    btLife1.setEnabled(false);
                }
                if (life == 1) {
                    btLife2.setEnabled(false);
                }
                if (life == 0) {
                    btLife3.setEnabled(false);
                }
                if (setLife()) {
                    life = life + 1;
                }
                if (life < 0) {
                    run = false;
                    if (t.isRunning()) {
                        t.stop();
                    }
                }


            }
        };
        if (t == null) {
            t = new Timer(100, action);
        }
        if (run) {
            jProgressBar.setValue(i);
            t.start();
        } else if (t.isRunning()) {
            t.stop();
        }


    }

    private boolean setLife() {
        if (mark != 0 && mark % 5 == 0 && mark != flag) {
            flag = mark;
            return true;
        } else {
            return false;
        }

    }

    private boolean mark(int choice) {
        boolean flag = true;
        if (choice == tbWord.getValueAt(rowE, 6)) {
            mark++;

        } else {
            flag = false;
        }
        //System.out.println(tbWord.getValueAt(rowE, 6));
        //System.out.println("Mark: " + mark);
        return flag;

    }

    int random_cond(int range, int pre) {
        int n;
        Random random = new Random();
        n = random.nextInt(pre);
        if (n >= pre) {
            n++;
        }

        return n;
    }

    private boolean NextWord(boolean a) {

        if (a == true) {
            try {
                rowE = random_cond(0, tbWord.getRowCount());

                if (rowE < tbWord.getRowCount()) {
                    tbWord.clearSelection();
                    tbWord.changeSelection(row, 5, false, false);
                    fillTest();
                } else {
                    a = false;
                }
            } catch (Exception e) {
                //System.out.println("next word false");
            }
        }
        return a;
    }

    private void fillTest() {
        taQ.setText((String) tbWord.getValueAt(rowE, 1));
        btA.setText((String) tbWord.getValueAt(rowE, 2));
        btB.setText((String) tbWord.getValueAt(rowE, 3));
        btC.setText((String) tbWord.getValueAt(rowE, 4));
        btD.setText((String) tbWord.getValueAt(rowE, 5));
    }

    private void fillTbWord() {

        Vector title = new Vector();
        title.add("ID");
        title.add("Question");
        title.add("A");
        title.add("B");
        title.add("C");
        title.add("D");
        title.add("RA");
        title.add("Set");
        Vector test = TestInteraction.readTest();
        if (test.size() > 0) {
            tbWord.setModel(new DefaultTableModel(test, title));
            tbWord.getColumnModel().getColumn(1).setPreferredWidth(20);

        }
    }
    ///Game

    private void fillTable() {
        Vector title = new Vector();
        title.add("ID");
        title.add("SongName");
        title.add("SongPath");
        title.add("JapLyric");
        title.add("VieLyric");
        Vector song = SongInteraction.readSong();
        if (song.size() >= 0) {
            tbSong.setModel(new DefaultTableModel(song, title));
            tbSong.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbSong.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbSong.getColumn("ID").setWidth(0);
            tbSong.getColumn("ID").setMinWidth(0);
            tbSong.getColumn("ID").setMaxWidth(0);
            tbSong.getColumn("JapLyric").setWidth(0);
            tbSong.getColumn("JapLyric").setMinWidth(0);
            tbSong.getColumn("JapLyric").setMaxWidth(0);
            tbSong.getColumn("VieLyric").setWidth(0);
            tbSong.getColumn("VieLyric").setMinWidth(0);
            tbSong.getColumn("VieLyric").setMaxWidth(0);
            tbSong.setDragEnabled(false);
        }
        tbSong.changeSelection(0, 1, true, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnMusic = new javax.swing.JPanel();
        pnListSong = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnPlayMusic = new javax.swing.JPanel();
        btPlaymusic = new javax.swing.JButton();
        btPreview = new javax.swing.JButton();
        btNext = new javax.swing.JButton();
        lbMusic = new javax.swing.JLabel();
        lbSongName = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSong = new javax.swing.JTable();
        pnAction = new javax.swing.JPanel();
        pnJapLyric = new javax.swing.JPanel();
        btJapHide = new javax.swing.JButton();
        btJapSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taJap = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taVie = new javax.swing.JTextArea();
        pnGame = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        taQ = new javax.swing.JTextArea();
        btB = new javax.swing.JButton();
        btD = new javax.swing.JButton();
        btC = new javax.swing.JButton();
        btA = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bStart = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbWord = new javax.swing.JTable();
        btLife3 = new javax.swing.JButton();
        btLife1 = new javax.swing.JButton();
        btLife2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(660, 550));
        setPreferredSize(new java.awt.Dimension(850, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        pnMusic.setName("pnMusic"); // NOI18N
        pnMusic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnListSong.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnListSong.setName("pnListSong"); // NOI18N
        pnListSong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAdd.setText("Add");
        btAdd.setName("btAdd"); // NOI18N
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        pnListSong.add(btAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 110, -1));

        btDelete.setText("Delete");
        btDelete.setName("btDelete"); // NOI18N
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        pnListSong.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 110, -1));

        pnPlayMusic.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnPlayMusic.setName("pnPlayMusic"); // NOI18N
        pnPlayMusic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPlaymusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play-button.png"))); // NOI18N
        btPlaymusic.setBorderPainted(false);
        btPlaymusic.setContentAreaFilled(false);
        btPlaymusic.setName("btPlaymusic"); // NOI18N
        btPlaymusic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPlaymusicMouseExited(evt);
            }
        });
        btPlaymusic.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btPlaymusicMouseMoved(evt);
            }
        });
        btPlaymusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlaymusicActionPerformed(evt);
            }
        });
        pnPlayMusic.add(btPlaymusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 70, 80));

        btPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rewind.png"))); // NOI18N
        btPreview.setBorderPainted(false);
        btPreview.setContentAreaFilled(false);
        btPreview.setName("btPreview"); // NOI18N
        btPreview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPreviewMouseExited(evt);
            }
        });
        btPreview.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btPreviewMouseMoved(evt);
            }
        });
        btPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPreviewActionPerformed(evt);
            }
        });
        pnPlayMusic.add(btPreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 40, 40));

        btNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/forward.png"))); // NOI18N
        btNext.setBorderPainted(false);
        btNext.setContentAreaFilled(false);
        btNext.setName("btNext"); // NOI18N
        btNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNextMouseExited(evt);
            }
        });
        btNext.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btNextMouseMoved(evt);
            }
        });
        btNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextActionPerformed(evt);
            }
        });
        pnPlayMusic.add(btNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 40, 40));

        lbMusic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/music1.png"))); // NOI18N
        lbMusic.setName("lbMusic"); // NOI18N
        pnPlayMusic.add(lbMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 120));

        lbSongName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSongName.setName("lbSongName"); // NOI18N
        pnPlayMusic.add(lbSongName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 210, 20));

        pnListSong.add(pnPlayMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 240));

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        tbSong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbSong.setName("tbSong"); // NOI18N
        tbSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSongMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSong);

        jScrollPane4.setViewportView(jScrollPane5);

        pnListSong.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 250, 200));

        pnMusic.add(pnListSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 550));

        pnAction.setName("pnAction"); // NOI18N
        pnAction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnJapLyric.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnJapLyric.setName("pnJapLyric"); // NOI18N
        pnJapLyric.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btJapHide.setText("Hide");
        btJapHide.setName("btJapHide"); // NOI18N
        btJapHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJapHideActionPerformed(evt);
            }
        });
        pnJapLyric.add(btJapHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 110, -1));

        btJapSave.setText("Save");
        btJapSave.setName("btJapSave"); // NOI18N
        btJapSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJapSaveActionPerformed(evt);
            }
        });
        pnJapLyric.add(btJapSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 110, -1));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        taJap.setColumns(20);
        taJap.setRows(5);
        taJap.setName("taJap"); // NOI18N
        jScrollPane1.setViewportView(taJap);

        pnJapLyric.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 470));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        taVie.setColumns(20);
        taVie.setRows(5);
        taVie.setName("taVie"); // NOI18N
        jScrollPane2.setViewportView(taVie);

        pnJapLyric.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 260, 470));

        pnAction.add(pnJapLyric, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 550));

        pnMusic.add(pnAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 560, 550));

        jTabbedPane1.addTab("Music", pnMusic);

        pnGame.setName("pnGame"); // NOI18N
        pnGame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar.setName("jProgressBar"); // NOI18N
        jPanel1.add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 650, 20));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        taQ.setColumns(20);
        taQ.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        taQ.setRows(5);
        taQ.setName("taQ"); // NOI18N
        jScrollPane3.setViewportView(taQ);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 650, 110));

        btB.setText("B");
        btB.setName("btB"); // NOI18N
        btB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBActionPerformed(evt);
            }
        });
        jPanel1.add(btB, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 300, 50));

        btD.setText("C");
        btD.setName("btD"); // NOI18N
        btD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDActionPerformed(evt);
            }
        });
        jPanel1.add(btD, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 300, 50));

        btC.setText("C");
        btC.setName("btC"); // NOI18N
        btC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCActionPerformed(evt);
            }
        });
        jPanel1.add(btC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 320, 50));

        btA.setText("A");
        btA.setName("btA"); // NOI18N
        btA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAActionPerformed(evt);
            }
        });
        jPanel1.add(btA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 320, 50));

        pnGame.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 790, 370));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bStart.setText("Start");
        bStart.setName("bStart"); // NOI18N
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });
        jPanel2.add(bStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 110, 50));

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        tbWord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbWord.setName("tbWord"); // NOI18N
        jScrollPane6.setViewportView(tbWord);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, 110));

        btLife3.setText("C");
        btLife3.setName("btLife3"); // NOI18N
        jPanel2.add(btLife3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 90, 70));

        btLife1.setText("A");
        btLife1.setName("btLife1"); // NOI18N
        jPanel2.add(btLife1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 90, 70));

        btLife2.setText("B");
        btLife2.setName("btLife2"); // NOI18N
        jPanel2.add(btLife2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 90, 70));

        pnGame.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 790, 130));

        jTabbedPane1.addTab("Game", pnGame);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        // TODO add your handling code he
        game1();
    }//GEN-LAST:event_bStartActionPerformed

    private void btAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAActionPerformed
        // TODO add your handling code here:
        choice = 1;
        mark(choice);
        a = 1;
        //System.out.println("chon : " + choice);
    }//GEN-LAST:event_btAActionPerformed

    private void btCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCActionPerformed
        // TODO add your handling code here:
        choice = 3;
        mark(choice);
        a = 1;
        //System.out.println("chon : " + choice);
    }//GEN-LAST:event_btCActionPerformed

    private void btDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDActionPerformed
        // TODO add your handling code here:
        choice = 4;
        a = 1;
        mark(choice);
        //System.out.println("chon : " + choice);
    }//GEN-LAST:event_btDActionPerformed

    private void btBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBActionPerformed
        // TODO add your handling code here:
        choice = 2;
        a = 1;
        mark(choice);
        //System.out.println("chon : " + choice);
    }//GEN-LAST:event_btBActionPerformed

    private void btJapSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJapSaveActionPerformed
        // TODO add your handling code here:
        s.setJapLyric(taJap.getText());
        s.setVieLyric(taVie.getText());
        s.setSongName((String) tbSong.getValueAt(row, 1));
        //System.out.println((String) tbSong.getValueAt(row, 1));
        s.setSongPath((String) tbSong.getValueAt(row, 2));
        String result = SongInteraction.updateSong(s);
        //System.out.println(result);
        fillTable();
        selection(s, row);
        tbSong.clearSelection();
        tbSong.changeSelection(row, 5, false, false);
    }//GEN-LAST:event_btJapSaveActionPerformed

    private void btJapHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJapHideActionPerformed
        // TODO add your handling code here:
        taJap.setText(null);
        taVie.setText(null);
    }//GEN-LAST:event_btJapHideActionPerformed

    private void tbSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSongMouseClicked
        // TODO add your handling code here:
        if (tbSong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please choose the song to play");
            return;
        }
        row = tbSong.getSelectedRow();
        //cap phat 1 bien song
        s = new Song();
        //goi ham select bai hat
        selection(s, row);
        PlayMusic();
    }//GEN-LAST:event_tbSongMouseClicked

    private void btNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNextActionPerformed
        // TODO add your handling code here:
        try {
            row = tbSong.getSelectedRow() + 1;
            if (row < tbSong.getRowCount()) {
                tbSong.clearSelection();
                tbSong.changeSelection(row, 5, false, false);
                s = new Song();
                selection(s, row);
                PlayMusic();
            }
        } catch (Exception e) {
            //System.out.println("Het bai r");
        }
    }//GEN-LAST:event_btNextActionPerformed

    private void btNextMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNextMouseMoved
        // TODO add your handling code here:
        btNext.setIcon(new ImageIcon("src\\Images\\forward-on.png"));
    }//GEN-LAST:event_btNextMouseMoved

    private void btNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNextMouseExited
        // TODO add your handling code here:
        btNext.setIcon(new ImageIcon("src\\Images\\forward.png"));
    }//GEN-LAST:event_btNextMouseExited

    private void btPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPreviewActionPerformed
        // TODO add your handling code here:
        try {
            row = tbSong.getSelectedRow() - 1;
            if (row > -1) {
                tbSong.clearSelection();
                tbSong.changeSelection(row, 5, false, false);
                s = new Song();
                selection(s, row);
                PlayMusic();
            }
        } catch (Exception e) {
            //System.out.println("Het bai r");
        }
    }//GEN-LAST:event_btPreviewActionPerformed

    private void btPreviewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPreviewMouseMoved
        // TODO add your handling code here:
        btPreview.setIcon(new ImageIcon("src\\Images\\rewind-on.png"));
    }//GEN-LAST:event_btPreviewMouseMoved

    private void btPreviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPreviewMouseExited
        // TODO add your handling code here:
        btPreview.setIcon(new ImageIcon("src\\Images\\rewind.png"));
    }//GEN-LAST:event_btPreviewMouseExited

    private void btPlaymusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlaymusicActionPerformed

        //Play music
        if (ms == null) {
            tbSong.clearSelection();
            tbSong.changeSelection(0, 5, false, false);
            s = new Song();
            selection(s, 0);
        }
        PlayMusic();
    }//GEN-LAST:event_btPlaymusicActionPerformed

    private void btPlaymusicMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPlaymusicMouseMoved
        // TODO add your handling code here:
        if (ms != null && ms.isPlaying()) {
            btPlaymusic.setIcon(new ImageIcon("src\\Images\\pause-on.png"));
        } else {
            btPlaymusic.setIcon(new ImageIcon("src\\Images\\play-on.png"));
        }
    }//GEN-LAST:event_btPlaymusicMouseMoved

    private void btPlaymusicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPlaymusicMouseExited
        // TODO add your handling code here:
        try {
            if (ms != null && ms.isPlaying()) {
                btPlaymusic.setIcon(new ImageIcon("src\\Images\\pause.png"));
            } else {
                btPlaymusic.setIcon(new ImageIcon("src\\Images\\play-button.png"));
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_btPlaymusicMouseExited

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        if (tbSong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please choose the song to delete");
            return;
        }
        deleteSong();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        String SelezioneString = "", name = "";
        JFileChooser ChooseFile = new JFileChooser();
        ChooseFile.addChoosableFileFilter(new FileNameExtensionFilter("File Mp3", "mp3"));
        int returnValue = ChooseFile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File Selezione = ChooseFile.getSelectedFile();
            SelezioneString = Selezione.getAbsolutePath();
            name = Selezione.getName();
        } else {
            //System.out.println("khong chon a?");
            name = null;
        }
        if (name != null) {
            s = new Song(name, SelezioneString, null, null);
            String result = SongInteraction.insertSong(s);
            //System.out.println(result);
            fillTable();
        }
    }//GEN-LAST:event_btAddActionPerformed
    //ham chon bai hat

    public int selection(Song s, int r) {
        s.setID((Integer) tbSong.getValueAt(r, 0));
        s.setSongName((String) tbSong.getValueAt(r, 1));
        s.setSongPath((String) tbSong.getValueAt(r, 2));
        s.setJapLyric((String) tbSong.getValueAt(r, 3));
        s.setVieLyric((String) tbSong.getValueAt(r, 4));

        //tao file mp3 moi voi duong dan duoc chon

        mp3 = new Mp3(s.getSongPath());

        return r;
    }

    public void PlayMusic() {
        taJap.setText(s.getJapLyric());
        taVie.setText(s.getVieLyric());
        lbSongName.setText(s.getSongName());
        try {
            if (ms == null) {
                ms = mp3;
            } else if (ms != mp3) {
                ms.stop();
                ms = mp3;
            }
            if (ms.isPlaying()) {
                ms.pause();
            } else {
                if (ms != null) {
                    try {
                        ms.play();
                    } catch (LineUnavailableException ex) {
                        //System.out.println("LineUnavailableException 533");
                    } catch (IOException ex) {
                        //System.out.println("Loi IOException ");
                        ms = null;
                        mp3 = null;
                        int n = JOptionPane.showConfirmDialog(null, "Do you want to delete this song? :o", "File not found", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            deleteSong();
                        }

                    } catch (UnsupportedAudioFileException ex) {
                        //System.out.println("UnsupportedAudioFileException");

                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SetImageMusic();
    }

    public void SetImageMusic() {
        try {
            if (ms.isPlaying()) {
                lbMusic.setIcon(new ImageIcon("src\\Images\\music.gif"));
            } else {
                if (ms != null) {
                    lbMusic.setIcon(new ImageIcon("src\\Images\\music1.png"));
                }
            }
        } catch (NullPointerException ex) {
            lbMusic.setIcon(new ImageIcon("src\\Images\\music1.png"));
            //System.out.println("NullPointerException");

        }
    }

    public void deleteSong() {
        int row = tbSong.getSelectedRow();
        String result = SongInteraction.deleteSong((Integer) tbSong.getValueAt(row, 0));
        fillTable();
    }
    //Them thu vien mp3
    private Mp3 mp3 = null;
    private Mp3 ms = null;
    private Song s = null;
    private int row = 1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bStart;
    private javax.swing.JButton btA;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btB;
    private javax.swing.JButton btC;
    private javax.swing.JButton btD;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btJapHide;
    private javax.swing.JButton btJapSave;
    private javax.swing.JButton btLife1;
    private javax.swing.JButton btLife2;
    private javax.swing.JButton btLife3;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btPlaymusic;
    private javax.swing.JButton btPreview;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMusic;
    private javax.swing.JLabel lbSongName;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnGame;
    private javax.swing.JPanel pnJapLyric;
    private javax.swing.JPanel pnListSong;
    private javax.swing.JPanel pnMusic;
    private javax.swing.JPanel pnPlayMusic;
    private javax.swing.JTextArea taJap;
    private javax.swing.JTextArea taQ;
    private javax.swing.JTextArea taVie;
    private javax.swing.JTable tbSong;
    private javax.swing.JTable tbWord;
    // End of variables declaration//GEN-END:variables
}
