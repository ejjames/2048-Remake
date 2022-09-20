/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Splash;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Liz
 */
public class Tile {
    
    
    
    
    
        ImageView imageView;
    int value;
    int princess;
    int Cin = 0;
    int Ariel = 0;

    public Tile(ImageView IV) {
        imageView = IV;
        value = 0;
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        imageView.setImage(getNewImage(value));
    }

    public ImageView getImageView() {
        return imageView;
    }
    
//        public int princess(ArrayList<ArrayList<Integer>> all, ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D) {
//            
//        for (int i = 0; i < all.size(); i++) {//going to try and form the starting pictures fingers crossed it works
//                            for (int call = 0; call < all.get(i).size(); call++) {
//                                if (all.get(i) == A) {
//                                Cin = 0;
//                                } else if (all.get(i) == B) {
//                                    Cin = 4;
//                                } else if (all.get(i) == C) {
//                                    Cin = 8;
//                                } else if (all.get(i) == D) {
//                                    Cin = 12;
//
//                                }
//                                Ariel = call + Cin;//Ariel is the number tile the game is on
//                            }
//                        }
//        princess = Ariel;
//        return princess;
//    }
    
    

    public Image getNewImage(int tempValue) {
        switch (tempValue) {
            case 2:
                return new Image(new File("src\\Splash\\2.png").toURI().toString());
            case 4:
                return new Image(new File("src\\Splash\\4.png").toURI().toString());
            case 8:
                return new Image(new File("src\\Splash\\8.png").toURI().toString());
           case 16:
                return new Image(new File("src\\Splash\\16.png").toURI().toString());                
           case 32:
                return new Image(new File("src\\Splash\\32.png").toURI().toString());
            case 64:
                return new Image(new File("src\\Splash\\64.png").toURI().toString());
            case 128:
                return new Image(new File("src\\Splash\\128.png").toURI().toString());
           case 256:
                return new Image(new File("src\\Splash\\256.png").toURI().toString());    
            case 512:
                return new Image(new File("src\\Splash\\512png").toURI().toString());
            case 1024:
                return new Image(new File("src\\Splash\\1024.png").toURI().toString());
           case 2048:
                return new Image(new File("src\\Splash\\2048.png").toURI().toString());   
            default:
                return new Image(new File("src\\PEX3\\2.png").toURI().toString());
        }
    }
    
}
