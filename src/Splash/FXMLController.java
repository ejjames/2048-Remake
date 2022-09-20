package Splash;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;



import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.text.Text;


/**
 *
 * @author Liz this is the controller class for the main game scene, it holds
 * the code for movement of tiles and internal code of the game after win or
 * lose conditions are met a big image shows up and stops the game from continuing to be played
 * 
 */
public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane gamePane;

    ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    ArrayList<Integer> C = new ArrayList<Integer>();
    ArrayList<Integer> D = new ArrayList<Integer>();

    Integer arrayTest = 1;//used to set up an initial array only once
    int num = 0; //used to make sure there's squares on the board to move

    @FXML
    private ImageView IV1;

    @FXML
    private ImageView IV2;

    @FXML
    private ImageView IV3;

    @FXML
    private ImageView IV4;

    @FXML
    private ImageView IV5;

    @FXML
    private ImageView IV6;

    @FXML
    private ImageView IV7;

    @FXML
    private ImageView IV8;

    @FXML
    private ImageView IV9;

    @FXML
    private ImageView IV10;

    @FXML
    private ImageView IV11;

    @FXML
    private ImageView IV12;

    @FXML
    private ImageView IV13;

    @FXML
    private ImageView IV14;

    @FXML
    private ImageView IV15;

    @FXML
    private ImageView IV16;

    @FXML
    private ImageView bigScreen;

    @FXML
    private Text score;

    @FXML
    TranslateTransition trans;

    ArrayList<Tile> tileArray;

    ArrayList<ImageView> bloopArray;

    int scoreNum = 0;//used to record the score of the game
    String scoreNumStr;//used to print the score of the game to private text score
    int birdsound = 0;//int variable for sound effect

    @FXML
    void moveTile(KeyEvent event) {

        //A.remove(3);//testing array A here
        //A.add(3, 5);    
        KeyCode b = event.getCode();//later used for switch     
        //System.out.println(b);
        //this is a test to see if b is read correctly

        int tempNum1 = 55; //default place holders for comparison numbers in the following if statements
        //int tempNum2 = 55;
        //int tempNum3 = 55;
        //int tempNum4 = 55;
        if (num == 1) {//if statement checking if a key was pressed
            birdsound = 0;//declaring this zero at the start of each key input
            bloopArray = new ArrayList<>();
            bloopArray.clear();
            bloopArray.add((IV1));
            bloopArray.add((IV2));
            bloopArray.add((IV3));
            bloopArray.add((IV4));
            bloopArray.add((IV5));
            bloopArray.add((IV6));
            bloopArray.add((IV7));
            bloopArray.add((IV8));
            bloopArray.add((IV9));
            bloopArray.add((IV10));
            bloopArray.add((IV11));
            bloopArray.add((IV12));
            bloopArray.add((IV13));
            bloopArray.add((IV14));
            bloopArray.add((IV15));
            bloopArray.add((IV16));

            switch (b) {//switch statement seeing if one of the 4 arrow keys were pressed

                case LEFT:
                    //A.add(1);
                    //System.out.println(all);//test to see if the arraylists are all working as intended               
                    //System.out.println("help");//this is a test to see if switch case is running correctly
                    //A.remove(0);//testing array A here
                    //A.add(0, 5); 

                    for (int i = 0; i < all.size(); i++) {




                        if (all.get(i).get(1) != 0) {//if loop to see if the last variable contains a number

                            if (all.get(i).get(0) == 0) {//if loop that checks if all zeroes so the variable can move
                                all.get(i).set(0, all.get(i).get(1));




                                all.get(i).remove(1);
                                all.get(i).add(1, 0);


                            } else if (Objects.equals(all.get(i).get(0), all.get(i).get(1))) {//if statement checks slot 0 = slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(1) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved
                                tempNum1 = all.get(i).get(1) * 2;
                                all.get(i).set(0, tempNum1);
                                all.get(i).remove(1);
                                all.get(i).add(1, 0);
                            }

                        }

                        if (all.get(i).get(2) != 0) {//if loop to move the third loop forward
                            double arielXpos = 266;//x position of column 2
                            if (all.get(i).get(0) == 0 & all.get(i).get(1) == 0) {//if loop that checks if all zeroes so the variable can move
                                all.get(i).set(0, all.get(i).get(2));
                                all.get(i).remove(2);
                                all.get(i).add(2, 0);

                            } else if (Objects.equals(all.get(i).get(0), all.get(i).get(2)) & all.get(i).get(1) == 0) {//if statement checks slot 0 = slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(0) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(2) * 2;
                                all.get(i).set(0, tempNum1);
                                all.get(i).remove(2);
                                all.get(i).add(2, 0);
                            } else if (all.get(i).get(1) == 0) {//if loops check if slot 1 and 2 are 0 so value can move to 0
                                all.get(i).set(1, all.get(i).get(2));
                                all.get(i).remove(2);
                                all.get(i).add(2, 0);
                            } else if (Objects.equals(all.get(i).get(1), all.get(i).get(2))) {//if checks if slot 1 and 3 are equal
                                birdsound++;
                                scoreNum = all.get(i).get(1) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(2) * 2;
                                all.get(i).set(1, tempNum1);
                                all.get(i).remove(2);
                                all.get(i).add(2, 0);
                            }

                        }//if all.get(i).2 

                        if (all.get(i).get(3) != 0) {//if loop to move the fourth element to the left
                            double arielXpos = 378;//x position of column 3
                            if (all.get(i).get(0) == 0 & all.get(i).get(1) == 0 & all.get(i).get(2) == 0) {//if loop that checks if all zeroes so the variable can move
                                all.get(i).set(0, all.get(i).get(3));
                                all.get(i).remove(3);
                                all.get(i).add(3, 0);

                            } else if (Objects.equals(all.get(i).get(0), all.get(i).get(3)) & all.get(i).get(1) == 0 & all.get(i).get(2) == 0) {//if statement checks slot 0 = slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(0) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(3) * 2;
                                all.get(i).set(0, tempNum1);
                                all.get(i).remove(3);
                                all.get(i).add(3, 0);
                            } else if (all.get(i).get(1) == 0 & all.get(i).get(2) == 0) {//if loops check if slot 1 and 2 are 0 so value can move to 0
                                all.get(i).set(1, all.get(i).get(3));
                                all.get(i).remove(3);
                                all.get(i).add(3, 0);
                            } else if (Objects.equals(all.get(i).get(1), all.get(i).get(3)) & all.get(i).get(2) == 0) {//if checks if slot 1 and 3 are equal
                                birdsound++;
                                scoreNum = all.get(i).get(1) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(3) * 2;
                                all.get(i).set(1, tempNum1);
                                all.get(i).remove(3);
                                all.get(i).add(3, 0);
                            } else if (all.get(i).get(2) == 0) {//checks if slot 2 is zero, if zero value moves there
                                all.get(i).set(2, all.get(i).get(3));
                                all.get(i).remove(3);
                                all.get(i).add(3, 0);
                            } else if (Objects.equals(all.get(i).get(2), all.get(i).get(3))) {//compare value slot 2 and slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(2) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(3) * 2;
                                all.get(i).set(2, tempNum1);
                                all.get(i).remove(3);
                                all.get(i).add(3, 0);
                            }

                        }//if all.get(i).3

                    }//for loop

                    //System.out.println(all);//to test how the arrays came out

                    break;

                case RIGHT:
                    for (int i = 0; i < all.size(); i++) {
                        if (all.get(i).get(2) != 0) {//if loop to see if the last variable contains a number
                            if (all.get(i).get(3) == 0) {//if loop that checks if all zeroes so the variable can move
                                all.get(i).set(3, all.get(i).get(2));
                                all.get(i).remove(2);
                                all.get(i).add(2, 0);

                            } else if (Objects.equals(all.get(i).get(2), all.get(i).get(3))) {//if statement checks slot 0 = slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(2) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(2) * 2;
                                all.get(i).set(3, tempNum1);
                                all.get(i).remove(2);
                                all.get(i).add(2, 0);
                            }
                        }
                        if (all.get(i).get(1) != 0) {//if loop to move the third loop forward
                            if (all.get(i).get(2) == 0 & all.get(i).get(3) == 0) {//if loop that checks if all zeroes so the variable can move
                                all.get(i).set(3, all.get(i).get(1));
                                all.get(i).remove(1);
                                all.get(i).add(1, 0);

                            }
                            if (Objects.equals(all.get(i).get(3), all.get(i).get(1)) & all.get(i).get(2) == 0) {//compare slot 1 and 3 and if theyre equal doublr
                                birdsound++;
                                scoreNum = all.get(i).get(3) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(1) * 2;
                                all.get(i).set(3, tempNum1);
                                all.get(i).remove(1);
                                all.get(i).add(1, 0);

                            } else if (Objects.equals(all.get(i).get(2), all.get(i).get(1))) {//if statement checks slot 0 = slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(2) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(1) * 2;
                                all.get(i).set(2, tempNum1);
                                all.get(i).remove(1);
                                all.get(i).add(1, 0);
                            } else if (all.get(i).get(2) == 0) {//if loops check if slot 1 and 2 are 0 so value can move to 0
                                all.get(i).set(2, all.get(i).get(1));
                                all.get(i).remove(1);
                                all.get(i).add(1, 0);
                            }
//                   else if(all.get(i).get(2) ==  all.get(i).get(1)){//if checks if slot 1 and 3 are equal
//                       tempNum1 = all.get(i).get(1) * 2;
//                       all.get(i).set(1, tempNum1);
//                       all.get(i).remove(1);
//                       all.get(i).add(1, 0);
//                   }

                        }//if all.get(i).3

                        if (all.get(i).get(0) != 0) {//if loop to move the fourth element to the left
                            if (all.get(i).get(3) == 0 & all.get(i).get(1) == 0 & all.get(i).get(2) == 0) {//if loop that checks if all zeroes so the variable can move
                                all.get(i).set(3, all.get(i).get(0));
                                all.get(i).remove(0);
                                all.get(i).add(0, 0);

                            } else if (Objects.equals(all.get(i).get(0), all.get(i).get(3)) & all.get(i).get(1) == 0 & all.get(i).get(2) == 0) {//if statement checks slot 0 = slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(0) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(0) * 2;
                                all.get(i).set(3, tempNum1);
                                all.get(i).remove(0);
                                all.get(i).add(0, 0);
                            } else if (all.get(i).get(1) == 0 & all.get(i).get(2) == 0) {//if loops check if slot 1 and 2 are 0 so value can move
                                all.get(i).set(2, all.get(i).get(0));
                                all.get(i).remove(0);
                                all.get(i).add(0, 0);
                            } else if (Objects.equals(all.get(i).get(2), all.get(i).get(0)) & all.get(i).get(1) == 0) {
                                birdsound++;
                                scoreNum = all.get(i).get(2) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(0) * 2;
                                all.get(i).set(2, tempNum1);
                                all.get(i).remove(0);
                                all.get(i).add(0, 0);
                            } else if (all.get(i).get(1) == 0) {//checks if slot 2 is zero, if zero value moves there
                                all.get(i).set(1, all.get(i).get(0));
                                all.get(i).remove(0);
                                all.get(i).add(0, 0);
                            } else if (Objects.equals(all.get(i).get(1), all.get(i).get(0))) {//compare value slot 2 and slot 3
                                birdsound++;
                                scoreNum = all.get(i).get(1) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = all.get(i).get(0) * 2;
                                all.get(i).set(1, tempNum1);
                                all.get(i).remove(0);
                                all.get(i).add(0, 0);
                            }

                        }//if all.get(i).3

                    }//for loop

                    //System.out.println(all);
                    break;
                case DOWN://time to figure out how the heck to move the values downwards
                    for (int i = 0; i < all.size(); i++) {//for loop so i dont have to the code four times

                        if (C.get(i) != 0) {//checking if B.get(i) is not zero  
                            if (D.get(i) == 0) {//checks if the all the following are zero
                                D.set(i, C.get(i));
                                C.remove(i);
                                C.add(i, 0);
                            } else if (Objects.equals(C.get(i), D.get(i))) {//if statement comparing C and D
                                birdsound++;
                                scoreNum = C.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = C.get(i) * 2;
                                D.set(i, tempNum1);
                                C.remove(i);
                                C.add(i, 0);
                            }//end bracket for compare C and d                   

                        }//end bracket for if C!=0
                        if (B.get(i) != 0) {//checking if B.get(i) is not zero  
                            if (D.get(i) == 0 & C.get(i) == 0) {//checks if the all the following are zero
                                D.set(i, B.get(i));
                                B.remove(i);
                                B.add(i, 0);
                            } else if (Objects.equals(B.get(i), D.get(i)) & C.get(i) == 0) {//if statement comparing B and D
                                birdsound++;
                                scoreNum = B.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = B.get(i) * 2;
                                D.set(i, tempNum1);
                                B.remove(i);
                                B.add(i, 0);
                            }//end bracket for compare a and d
                            else if (C.get(i) == 0) {//else for C ==  0
                                C.set(i, B.get(i));
                                B.remove(i);
                                B.add(i, 0);
                            } else if (Objects.equals(B.get(i), C.get(i))) {//if statement comparing B and C
                                birdsound++;
                                scoreNum = B.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = B.get(i) * 2;
                                C.set(i, tempNum1);
                                B.remove(i);
                                B.add(i, 0);
                            }//bracket for else if B == C

                        }//end bracket for if B!=0  

                        if (A.get(i) != 0) {//checking if A.get(i) is not zero  
                            if (D.get(i) == 0 & C.get(i) == 0 & B.get(i) == 0) {//checks if the all the following are zero
                                D.set(i, A.get(i));
                                A.remove(i);
                                A.add(i, 0);
                            } else if (Objects.equals(A.get(i), D.get(i)) & C.get(i) == 0 & B.get(i) == 0) {//if statement comparing A and D
                                birdsound++;
                                scoreNum = A.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = A.get(i) * 2;
                                D.set(i, tempNum1);
                                A.remove(i);
                                A.add(i, 0);
                            }//end bracket for compare a and d
                            else if (C.get(i) == 0 & B.get(i) == 0) {//else for C ==  0
                                C.set(i, A.get(i));
                                A.remove(i);
                                A.add(i, 0);
                            } else if (Objects.equals(A.get(i), C.get(i)) & B.get(i) == 0) {//if statement comparing A and C
                                birdsound++;
                                scoreNum = A.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = A.get(i) * 2;
                                C.set(i, tempNum1);
                                A.remove(i);
                                A.add(i, 0);
                            }//bracket for else if A == C
                            else if (B.get(i) == 0) {//else for C ==  0
                                B.set(i, A.get(i));
                                A.remove(i);
                                A.add(i, 0);
                            }//end bracket for else if B == 0
                            else if (Objects.equals(A.get(i), B.get(i))) {//if statement comparing A and C
                                birdsound++;
                                scoreNum = A.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = A.get(i) * 2;
                                B.set(i, tempNum1);
                                A.remove(i);
                                A.add(i, 0);
                            }//bracket for else if A == B
                        }//end bracket for if A!=0

                    }//end bracket for main for loop
                    //System.out.println(all); 
                    break;
                case UP:
                    for (int i = 0; i < all.size(); i++) {//for loop so i dont have to the code four times
                        if (B.get(i) != 0) {//checking if B.get(i) is not zero  
                            if (A.get(i) == 0) {//checks if the all the following are zero
                                A.set(i, B.get(i));
                                B.remove(i);
                                B.add(i, 0);
                            } else if (Objects.equals(B.get(i), A.get(i))) {//if statement comparing C and D
                                birdsound++;
                                scoreNum = A.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = B.get(i) * 2;
                                A.set(i, tempNum1);
                                B.remove(i);
                                B.add(i, 0);
                            }//end bracket for compare C and d                   

                        }//end bracket for if B!=0
                        if (C.get(i) != 0) {//checking if B.get(i) is not zero  
                            if (B.get(i) == 0 & A.get(i) == 0) {//checks if the all the following are zero
                                A.set(i, C.get(i));
                                C.remove(i);
                                C.add(i, 0);
                            } else if (Objects.equals(C.get(i), A.get(i)) & B.get(i) == 0) {//if statement comparing B and D
                                birdsound++;
                                scoreNum = A.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = C.get(i) * 2;
                                A.set(i, tempNum1);
                                C.remove(i);
                                C.add(i, 0);
                            }//end bracket for compare a and d
                            else if (B.get(i) == 0) {//else for C ==  0
                                B.set(i, C.get(i));
                                C.remove(i);
                                C.add(i, 0);
                            } else if (Objects.equals(B.get(i), C.get(i))) {//if statement comparing B and C
                                birdsound++;
                                scoreNum = C.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = C.get(i) * 2;
                                B.set(i, tempNum1);
                                C.remove(i);
                                C.add(i, 0);
                            }//bracket for else if B == C

                        }//end bracket for if C!=0  
                        if (D.get(i) != 0) {//checking if A.get(i) is not zero  
                            if (A.get(i) == 0 & B.get(i) == 0 & C.get(i) == 0) {//checks if the all the following are zero
                                A.set(i, D.get(i));
                                D.remove(i);
                                D.add(i, 0);
                            } else if (Objects.equals(A.get(i), D.get(i)) & C.get(i) == 0 & B.get(i) == 0) {//if statement comparing A and D
                                birdsound++;
                                scoreNum = A.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = D.get(i) * 2;
                                A.set(i, tempNum1);
                                D.remove(i);
                                D.add(i, 0);
                            }//end bracket for compare a and d
                            else if (C.get(i) == 0 & B.get(i) == 0) {//else for C ==  0
                                B.set(i, D.get(i));
                                D.remove(i);
                                D.add(i, 0);
                            } else if (Objects.equals(D.get(i), B.get(i)) & C.get(i) == 0) {//if statement comparing A and C
                                birdsound++;
                                scoreNum = B.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = D.get(i) * 2;
                                B.set(i, tempNum1);
                                D.remove(i);
                                D.add(i, 0);
                            }//bracket for else if A == C
                            else if (C.get(i) == 0) {//else for C ==  0
                                C.set(i, D.get(i));
                                D.remove(i);
                                D.add(i, 0);
                            }//end bracket for else if B == 0
                            else if (Objects.equals(D.get(i), C.get(i))) {//if statement comparing A and C
                                birdsound++;
                                scoreNum = C.get(i) + scoreNum;//initial score value
                                scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
                                score.setText(scoreNumStr);//changes the score on the gui to match
                                this.scoreNum = scoreNum;//keeps it saved

                                tempNum1 = D.get(i) * 2;
                                C.set(i, tempNum1);
                                D.remove(i);
                                D.add(i, 0);
                            }//bracket for else if A == B
                        }//end bracket for if D!=0

                    }//end bracket for main for loop
                    //System.out.println(all);//test for movement

                    break;
            }//switch end
        }//end bracket for if statement
        //randomaly spawned square starts here

        if (num == 1) {
            birdsound = (int) ((Math.random() * 7) + 1);
            if (birdsound == 1) {
                    playMusicBird();
            }
            else if(birdsound == 2){
                playMusicBird2();
            }
            else if(birdsound == 3){
                playMusicBird3();
            }
            else if(birdsound == 4){
                playMusicBird4();
            }
            else if(birdsound == 5){
                playMusicBird5();
            }
            else if(birdsound == 6){
                playMusicBird6();
            }
            else if(birdsound == 7){
                playMusicBird7();
            }
            else{
                playMusicBird();
            }
            

            int spawnage = 0;
            int altspawnage = 0;
            int ranSpawn = 0;
            int checkSpawn = 0;
//    for (int i =0; i <all.size(); i++){
//        if(all.get(i).get(i) == 0){
//            altspawnage++;
//        }
//    }

            for (int i = 0; i < all.size(); i++) {
                for (int call = 0; call < all.get(i).size(); call++) {
                    if (all.get(i).get(call) == 0) {

                        spawnage = spawnage + 1;
                    }

                }

            }

            if (spawnage == 0) {
                System.out.println("You Lose");
                bigScreen.setImage(new Image(new File("src\\Splash\\lose.png").toURI().toString()));
                num = 0;//making it so the game ends, a num = 1 is needed to read key inputs
                this.num = num;

            } else {
                ranSpawn = (int) ((Math.random() * spawnage) + 1);
                for (int i = 0; i < all.size(); i++) {
                    for (int call = 0; call < all.get(i).size(); call++) {
                        if (all.get(i).get(call) == 0) {
                            checkSpawn++;
                            if (ranSpawn == checkSpawn) {
                                all.get(i).set(call, 2);
                            }
                        }

                    }
                }
            }

            spawnage = 0;
            for (int i = 0; i < all.size(); i++) {
                for (int call = 0; call < all.get(i).size(); call++) {
                    if (all.get(i).get(call) == 0) {

                        spawnage = spawnage + 1;
                    }

                }

                bloopArray = new ArrayList<>();
                bloopArray.clear();
                bloopArray.add((IV1));
                bloopArray.add((IV2));
                bloopArray.add((IV3));
                bloopArray.add((IV4));
                bloopArray.add((IV5));
                bloopArray.add((IV6));
                bloopArray.add((IV7));
                bloopArray.add((IV8));
                bloopArray.add((IV9));
                bloopArray.add((IV10));
                bloopArray.add((IV11));
                bloopArray.add((IV12));
                bloopArray.add((IV13));
                bloopArray.add((IV14));
                bloopArray.add((IV15));
                bloopArray.add((IV16));

                int Cin = 0;
                for (i = 0; i < all.size(); i++) {//going to try and form the starting pictures fingers crossed it works
                    for (int call = 0; call < all.get(i).size(); call++) {
                        if (all.get(i) == A) {
                            Cin = 0;
                        } else if (all.get(i) == B) {
                            Cin = 4;
                        } else if (all.get(i) == C) {
                            Cin = 8;
                        } else if (all.get(i) == D) {
                            Cin = 12;

                        }
                        int Ariel = call + Cin;//Ariel is the number tile the game is on
                        //System.out.println(Ariel);
                        //i chose ariel cause i was listening to some disney songs while working on the code
                        // if(all.get(i).get(call) == 2){
                        switch (all.get(i).get(call)) {//figures out wht image to put in which square
                            case 2:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                                //System.out.println(Ariel);
                                break;
                            case 4:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\4.png").toURI().toString()));
                                break;
                            case 8:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\8.png").toURI().toString()));
                                break;
                            case 16:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\16.png").toURI().toString()));
                                break;
                            case 32:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\32.png").toURI().toString()));
                                break;
                            case 64:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\64.png").toURI().toString()));
                                break;
                            case 128:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\128.png").toURI().toString()));
                                break;
                            case 256:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\256.png").toURI().toString()));
                                break;
                            case 512:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\512.png").toURI().toString()));
                                break;
                            case 1024:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\1024.png").toURI().toString()));
                                break;
                            case 2048:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\2048.png").toURI().toString()));
                                System.out.println("You Win");
                                num = 0;//stops the game, num = 1 if statement is needed to read key inputs
                                this.num = num;
                                bigScreen.setImage(new Image(new File("src\\Splash\\win.png").toURI().toString()));

                                break;
                            default:
                                bloopArray.get(Ariel).setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                                break;

                        }//switch end

                    }//for loop inner
                }//for loop outer

            }

           // System.out.println(all);
        }
    }//end bracket for moveTile

    @FXML
    void startGame(ActionEvent event
    ) {

        bigScreen.setImage(new Image(new File("src\\Splash\\bigTransp.png").toURI().toString()));
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        ArrayList<Integer> D = new ArrayList<Integer>();

        //    if(arrayTest == 1){
        //because of how the startGame is supposed to work its okay the array gets reset everytime its pressed
        all.add(A);
        all.add(B);
        all.add(C);
        all.add(D);

        for (int i = 0; i < all.size(); i++) {
            all.get(i).add(0);
            all.get(i).add(0);
            all.get(i).add(0);
            all.get(i).add(0);

        }
        arrayTest = 0;

        //}
        int rand = (int) ((Math.random() * 4) + 1);//going to randomly generate the the first row to spawn
        int rand2 = (int) ((Math.random() * 4));
        int rand3 = (int) ((Math.random() * 4) + 1);//going to randomly generate the 2nd row to spawn
        int rand4 = (int) ((Math.random() * 4));
        while (rand3 == rand & rand2 == rand4) {//making sure at least 2 tiles spawn
            rand3 = (int) ((Math.random() * 4) + 1);//going to randomly generate to 2 numbers to spawn at start
            rand4 = (int) ((Math.random() * 4));
        }

        switch (rand) {
            case 1:

                A.remove(rand2);
                A.add(rand2, 2);

                break;
            case 2:
                B.remove(rand2);
                B.add(rand2, 2);

                break;
            case 3:
                C.remove(rand2);
                C.add(rand2, 2);

                break;
            case 4:
                D.remove(rand2);
                D.add(rand2, 2);

                break;

        }//end bracket meant for switch
        switch (rand3) {
            case 1:

                A.remove(rand4);
                A.add(rand4, 2);

                break;
            case 2:
                B.remove(rand4);
                B.add(rand4, 2);

                break;
            case 3:
                C.remove(rand4);
                C.add(rand4, 2);

                break;
            case 4:
                D.remove(rand4);
                D.add(rand4, 2);

                break;

        }//end bracket meant for switch

        //System.out.println(all);//testing the array  

        this.all = all;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;

        int num = 1;//making it so arrow keys are now read    
        this.num = num;


        int Cin = 0;
        for (int i = 0; i < all.size(); i++) {//going to try and form the starting pictures fingers crossed it works
            for (int call = 0; call < all.get(i).size(); call++) {
                if (all.get(i) == A) {
                    Cin = 0;
                } else if (all.get(i) == B) {
                    Cin = 4;
                } else if (all.get(i) == C) {
                    Cin = 8;
                } else if (all.get(i) == D) {
                    Cin = 12;

                }
                int Ariel = call + Cin + 1;
                if (all.get(i).get(call) == 2) {
                    switch (Ariel) {
                        case 1:
                            IV1.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 2:
                            IV2.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 3:
                            IV3.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 4:
                            IV4.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 5:
                            IV5.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 6:
                            IV6.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 7:
                            IV7.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 8:
                            IV8.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 9:
                            IV9.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 10:
                            IV10.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 11:
                            IV11.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 12:
                            IV12.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 13:
                            IV13.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 14:
                            IV14.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 15:
                            IV15.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;
                        case 16:
                            IV16.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
                            break;

                    }//switch end

                }//if end bracket
                else {
                    switch (Ariel) {
                        case 1:
                            IV1.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 2:
                            IV2.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 3:
                            IV3.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 4:
                            IV4.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 5:
                            IV5.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 6:
                            IV6.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 7:
                            IV7.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 8:
                            IV8.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 9:
                            IV9.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 10:
                            IV10.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 11:
                            IV11.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 12:
                            IV12.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 13:
                            IV13.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 14:
                            IV14.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 15:
                            IV15.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                        case 16:
                            IV16.setImage(new Image(new File("src\\Splash\\transp.png").toURI().toString()));
                            break;
                    }//switch end
                }//else end

            }

        }
        scoreNum = 0;//initial score value
        scoreNumStr = Integer.toString(scoreNum);//scoreNumStr is the string version of scorenum
        score.setText(scoreNumStr);//changes the score on the gui to match
        this.scoreNum = scoreNum;//keeps it saved so it can be used in the right left up down section
        //IV1.setImage(new Image(new File("src\\Splash\\2.png").toURI().toString()));
    }//end bracket for StartGame button

    @FXML
    public void initialize(String name
    ) {
        System.out.println(name);

    }

    @FXML
    void initialize() {
        playMusic();
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV1 != null : "fx:id=\"IV1\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV2 != null : "fx:id=\"IV2\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV3 != null : "fx:id=\"IV3\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV4 != null : "fx:id=\"IV4\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV5 != null : "fx:id=\"IV5\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV6 != null : "fx:id=\"IV6\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV7 != null : "fx:id=\"IV7\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV8 != null : "fx:id=\"IV8\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV9 != null : "fx:id=\"IV9\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV10 != null : "fx:id=\"IV10\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV11 != null : "fx:id=\"IV11\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV12 != null : "fx:id=\"IV12\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV13 != null : "fx:id=\"IV13\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV14 != null : "fx:id=\"IV14\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV15 != null : "fx:id=\"IV15\" was not injected: check your FXML file 'FXML.fxml'.";
        assert IV16 != null : "fx:id=\"IV16\" was not injected: check your FXML file 'FXML.fxml'.";

        assert bigScreen != null : "fx:id=\"bigScreen\" was not injected: check your FXML file 'FXML.fxml'.";
        assert score != null : "fx:id=\"score\" was not injected: check your FXML file 'FXML.fxml'.";

    }

    public void initialize(URL url, ResourceBundle rb) {

        //musicPlayer.play();
        tileArray = new ArrayList<>();
        bloopArray = new ArrayList<>();

        bloopArray.set(0, IV1);
        bloopArray.set(1, IV2);
        bloopArray.set(2, IV3);
        bloopArray.set(3, IV4);
        bloopArray.set(4, IV5);
        bloopArray.set(5, IV6);
        bloopArray.set(6, IV7);
        bloopArray.set(7, IV8);
        bloopArray.set(8, IV9);
        bloopArray.set(9, IV10);
        bloopArray.set(10, IV11);
        bloopArray.set(11, IV12);
        bloopArray.set(12, IV13);
        bloopArray.set(13, IV14);
        bloopArray.set(14, IV15);
        bloopArray.set(15, IV16);

        this.bloopArray = bloopArray;



    }

    public void playMusic() {

        String bip = "src//Splash//cali.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.setCycleCount(INDEFINITE);
        
        mediaPlayer.play();
        
    }

    public void playMusicBird() {//i made several bird sounds cause having the same one playing over and over got real annoying fast
        String bip = "src//Splash//birdcall1.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }

    public void playMusicBird2() {
        String bip = "src//Splash//birdcall2.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }

    public void playMusicBird3() {
        String bip = "src//Splash//birdcall3.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }

    public void playMusicBird4() {
        String bip = "src//Splash//birdcall4.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }
    
        public void playMusicBird5() {
        String bip = "src//Splash//birdcall4.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }
        
            public void playMusicBird6() {
        String bip = "src//Splash//birdcall4.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }
            
                public void playMusicBird7() {
        String bip = "src//Splash//birdcall4.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        AudioClip mediaPlayer = new AudioClip(hit.getSource());
        mediaPlayer.play();
    }



    
}
