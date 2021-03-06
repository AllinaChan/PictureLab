
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method to set the blue to 0 */
  public void moreRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(pixelObj.getRed()+100);
      }
    }
  }
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }


  public void grayscale()
  {
    int average;
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        average = pixelObj.getRed()+pixelObj.getBlue()+pixelObj.getGreen();
        average= average/3;
        pixelObj.setRed(average);
        pixelObj.setBlue(average);
        pixelObj.setGreen(average);
      }
    }
  }

  public void fixUnderwater() {
      Pixel[][] pixels = this.getPixels2D();
      HashMap<Integer, Integer> blueIndexes = new HashMap<>();
      for (int i = 0; i < pixels.length; i++) {
          for (int j = 0; j < pixels[i].length; j++) {
              pixels[i][j].setAlpha(0);
              pixels[i][j].setGreen(pixels[i][j].getGreen() - 100);
              pixels[i][j].setRed(pixels[i][j].getRed() + 45);
              pixels[i][j].setBlue(pixels[i][j].getBlue() - 85);
          /*if(pixels[i][j].getBlue()<100){
              pixels[i][j].setRed(200);
              pixels[i][j].setBlue(200);
              pixels[i][j].setGreen(200);
          }
      }*/
          }/*
      for (int i = 0; i < pixels.length; i++)
      {
          for (int j =0; j< pixels[i].length; j++)
          {
              if(pixels[i][j].getRed()>70 && pixels[i][j].getGreen()>70 && pixels[i][j].getBlue()<75){
                  pixels[i][j].setRed(200);
                  pixels[i][j].setBlue(200);
                  pixels[i][j].setGreen(200);
              }
          }
      }*/

      }
  }



  /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorVerticalRighttoLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal(){
    Pixel[][] pixels=this.getPixels2D();
    Pixel upperPixel= null;
    Pixel lowerPixel= null;
    int height = pixels.length;
    for(int row=0;row<height/2;row++){
      for(int column=0;column<pixels[0].length;column++){
        upperPixel=pixels[row][column];
        lowerPixel=pixels[height- row -1][column];
        lowerPixel.setColor(upperPixel.getColor());
      }
    }
  }

  public void mirrorBottomtoTop() {
      Pixel[][] pixels = this.getPixels2D();
      Pixel upperPixel = null;
      Pixel lowerPixel = null;
      int height = pixels.length;
      for (int row = 0; row < height / 2; row++) {
          for (int column = 0; column < pixels[0].length; column++) {
              upperPixel = pixels[row][column];
              lowerPixel = pixels[height - row - 1][column];
              upperPixel.setColor(lowerPixel.getColor());
          }
      }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count+=1;
        count +=1;
      }
    }
  }
  public void mirrorSeagull()
  {
    int mirrorPoint = 343;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 230; row < 317; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count +=1;
      }
    }
    System.out.println(count);
  }

  public void mirror4ArmSnowman()
  {
    int mirrorPoint = 192;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 153 ; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 100; col < 170; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels
                [mirrorPoint - row +mirrorPoint][col];
        rightPixel.setColor(leftPixel.getColor());
        count +=1;
      }
    }
    mirrorPoint = 224;
    leftPixel = null;
    rightPixel = null;
    count = 0;

    // loop through the rows
    for (int row = 166 ; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < 297; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels
                [mirrorPoint - row +mirrorPoint][col];
        rightPixel.setColor(leftPixel.getColor());
        count +=1;
      }
    }

    System.out.println(count);
  }


    public void mirrorDiagonal(){
        Pixel[][] pixels=this.getPixels2D();
        Pixel y;
        Pixel j;
        int a=pixels.length;
        for(int i=0;i<a;i++){
            for(int g=0;g<a;g++){
                y=pixels[i][g];
                j=pixels[g][i];
                j.setColor(y.getColor());
            }
        }

    }
    public void negate(){
        Pixel[][] pixels=this.getPixels2D();
        for(Pixel[] rowArray:pixels){
            for(Pixel pixelObj: rowArray){
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setBlue(255-pixelObj.getBlue());
                pixelObj.setGreen(255-pixelObj.getGreen());
            }
        }
    }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic,
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
         toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }
    public void copy2(Picture fromPic,
                     int startRow, int startCol,int endRow,int endCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = startRow, toRow = endRow;
             fromRow < fromPixels.length &&
                     toRow < toPixels.length;
             fromRow++, toRow++)
        {
            for (int fromCol = startCol, toCol = endCol;
                 fromCol < fromPixels[0].length &&
                         toCol < toPixels[0].length;
                 fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }


  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void myCollage()
  {
    Picture flower1 = new Picture("the-cyanide-happiness-show-7.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy2(flower1,550,1500,0,20);
    this.copy2(flower2,100,100,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy2(flowerNoBlue,50,50,100,0);
    this.copy(flower1,400,0 );
    this.copy(flower2,400,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        topPixel= pixels[row][col];
        bottomPixel = pixels[row+1][col];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) >
                edgeDist || topPixel.colorDistance(bottomPixel.getColor())> edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }

  }


  public int getCountRedOverValue(int value)
  {
    Pixel[][] pixels= this.getPixels2D();
    int count = 0;
    for(int i = 0 ; i <pixels.length; i++)
    {
      for(int j=0; j <pixels[i].length; j++)
      {
        if(pixels[i][j].getRed() >value)
        {
          count++;
        }
      }
    }
    return count;
  }


  public void setRedToHalfValueInTopHalf()
  {
    Pixel[][] pixels= this.getPixels2D();
    for(int i = 0 ; i <pixels.length/2; i++)
    {
      for(int j=0; j <pixels[i].length; j++) {
        pixels[i][j].setRed(pixels[i][j].getRed()/2);
      }
    }
  }


  public void clearBlueOverValue(int value)
  {
    Pixel[][] pixels= this.getPixels2D();
    int count = 0;
    for(int i = 0 ; i <pixels.length; i++)
    {
      for(int j=0; j <pixels[i].length; j++)
      {
        if(pixels[i][j].getBlue() >value)
        {
          pixels[i][j].setBlue(0);
        }
      }
    }
  }
  public int[] getAverageForColumn(int col)
  {
    Pixel[][] pixels = this.getPixels2D();
    int [] arr = new int [pixels.length];
    for (int row =0; row < pixels.length; row++)
    {
      int i = (pixels[row][col].getBlue() + pixels[row][col].getGreen() + pixels[row][col].getRed())/3;
      arr[row] = i;
    }
    return arr;
  }
public void edgeDetection2(String filename) throws IOException {


    FileChooser dir = new FileChooser();

  URL img = new URL("https://c.o0bg.com/rf/image_960w/Boston/2011-2020/2014/05/14/BostonGlobe.com/Ideas/Images/iStock_000002630883Medium.jpg");
  BufferedImage image = ImageIO.read(img);

  int x = image.getWidth();
  int y = image.getHeight();

  int maxGval = 0;
  int[][] edgeColors = new int[x][y];
  int maxGradient = -1;

        for (int i = 1; i < x - 1; i++) {
  for (int j = 1; j < y - 1; j++) {

    int val00 = getGrayScale(image.getRGB(i - 1, j - 1));
    int val01 = getGrayScale(image.getRGB(i - 1, j));
    int val02 = getGrayScale(image.getRGB(i - 1, j + 1));

    int val10 = getGrayScale(image.getRGB(i, j - 1));
    int val11 = getGrayScale(image.getRGB(i, j));
    int val12 = getGrayScale(image.getRGB(i, j + 1));

    int val20 = getGrayScale(image.getRGB(i + 1, j - 1));
    int val21 = getGrayScale(image.getRGB(i + 1, j));
    int val22 = getGrayScale(image.getRGB(i + 1, j + 1));

    int gx =  ((-1 * val00) + (0 * val01) + (1 * val02))
            + ((-2 * val10) + (0 * val11) + (2 * val12))
            + ((-1 * val20) + (0 * val21) + (1 * val22));

    int gy =  ((-1 * val00) + (-2 * val01) + (-1 * val02))
            + ((0 * val10) + (0 * val11) + (0 * val12))
            + ((1 * val20) + (2 * val21) + (1 * val22));

    double gval = Math.sqrt((gx * gx) + (gy * gy));
    int g = (int) gval;

    if(maxGradient < g) {
      maxGradient = g;
    }

    edgeColors[i][j] = g;
  }
}

  double scale = 255.0 / maxGradient;

        for (int i = 1; i < x - 1; i++) {
  for (int j = 1; j < y - 1; j++) {
    int edgeColor = edgeColors[i][j];
    edgeColor = (int)(edgeColor * scale);
    edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

    image.setRGB(i, j, edgeColor);
  }
}

        File outputfile = new File("output.jpg");
        ImageIO.write(image, "jpg", outputfile);
}

  public static int  getGrayScale(int rgb) {
    int r = (rgb >> 16) & 0xff;
    int g = (rgb >> 8) & 0xff;
    int b = (rgb) & 0xff;

    //from https://en.wikipedia.org/wiki/Grayscale, calculating luminance
    int gray = (int)(0.2126 * r + 0.7152 * g + 0.0722 * b);
    //int gray = (r + g + b) / 3;

    return gray;
  }

  public void edgeDetection2()
  {
    Pixel[][] pixels = this.getPixels2D();
    int count =0;
    int redAvg=0;
    int blueAvg=0;
    int greenAvg=0;
    for(int i =0; i<pixels.length; i++)
    {
      for(int j=0; j<pixels[i].length; j++)
      {
        count++;
        redAvg+=pixels[i][j].getRed();
        blueAvg+= pixels[i][j].getBlue();
        greenAvg += pixels[i][j].getGreen();
      }
    }

    redAvg = redAvg/count;
    blueAvg= blueAvg/count;
    greenAvg = greenAvg/count;

    for(int i =0; i<pixels.length; i++)
    {
      for(int j=0; j<pixels[i].length; j++) {
        if(pixels[i][j].getRed()> redAvg || pixels[i][j].getBlue() > blueAvg
                || pixels[i][j].getGreen() > greenAvg)
        {
          pixels[i][j].setColor(Color.BLACK);
        }else{
          pixels[i][j].setColor(Color.WHITE);
        }
      }
    }

    Pixel topPixel = null;
    Pixel topTopPixel =null;
    Pixel bottomPixel = null;
    for (int row = 1; row < pixels.length-1; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        topTopPixel = pixels[row-1][col];
        topPixel= pixels[row][col];
        bottomPixel = pixels[row+1][col];

        if(topTopPixel.getRed()==255) {
          if (topPixel.getRed() == 0 && bottomPixel.getRed() == 0) {
            bottomPixel.setColor(Color.WHITE);
          }
        }

      }
    }




  }

  /* Main method for testing - each class in Java can have a main
   * method
   */
  public static void main(String[] args)
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

} // this } is the end of class Picture, put all new methods before this