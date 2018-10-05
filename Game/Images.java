import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Images
{
   public static BufferedImage levelSelectImage, warioImage, waluigiImage, toadImage, goombaImage, yoshiImage, chestImage, chestWithKeyImage, keyImage1, keyImage2, keyImage3, flameImage, donkeyKongImage;
   
   public Images()
   {
      try{levelSelectImage = ImageIO.read(new File("levelSelectImage.png"));}catch(IOException e){}
      try{warioImage = ImageIO.read(new File("wario.png")); warioImage = warioImage.getSubimage(390, 360, 200, 310);}catch(IOException e){}
      try{waluigiImage = ImageIO.read(new File("waluigi.png")); waluigiImage = waluigiImage.getSubimage(720, 20, 200, 310);}catch(IOException e){}
      try{goombaImage = ImageIO.read(new File("goomba.png")); goombaImage = goombaImage.getSubimage(220, 150, 160, 160);}catch(IOException e){}
      try{toadImage = ImageIO.read(new File("toad.png")); /*toadImage = toadImage.getSubimage();*/}catch(IOException e){}
      try{yoshiImage = ImageIO.read(new File("yoshi.png")); yoshiImage = yoshiImage.getSubimage(222, 0, 156, 150);}catch(IOException e){}
      try{chestImage = ImageIO.read(new File("chest.png"));}catch(IOException e){}
      try{chestWithKeyImage = ImageIO.read(new File("chestWithKey.png"));}catch(IOException e){}
      try{keyImage1 = ImageIO.read(new File("key1.png"));}catch(IOException e){}
      try{keyImage2 = ImageIO.read(new File("key2.png"));}catch(IOException e){}
      try{keyImage3 = ImageIO.read(new File("key3.png"));}catch(IOException e){}
      try{flameImage = ImageIO.read(new File("fire.jpg"));}catch(IOException e){}
      try{donkeyKongImage = ImageIO.read(new File("dk.png")); donkeyKongImage = donkeyKongImage.getSubimage(53, 526, 280, 273);}catch(IOException e){}
   }
}