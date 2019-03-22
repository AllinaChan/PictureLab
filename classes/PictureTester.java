/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
    public static void testKeepOnlyBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

  public static void testMoreRed()
  {
    Picture beach = new Picture("download.jpg");
    beach.explore();
    beach.moreRed();
    beach.explore();
  }

  public static void testGrayScale()
  {
    Picture beach = new Picture("download.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }


  public static void testFixUnderWater()
  {
    Picture caterpillar = new Picture("water.jpg");
    caterpillar.explore();
    caterpillar.fixUnderwater();
    caterpillar.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  public static void testMirrorVerticalRighttoleft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRighttoLeft();
    caterpillar.explore();
  }


  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testnegate(){
      Picture swan=new Picture("swan.jpg");
      swan.negate();
      swan.explore();
  }

  public static void testHorzontalMirror(){
    Picture kitten=new Picture("kitten2.jpg");
    kitten.mirrorHorizontal();
    kitten.explore();
  }

  public static void testBottomtoTop(){
      Picture moon=new Picture("moon-surface.jpg");
      moon.mirrorBottomtoTop();
      moon.explore();
  }
  public static void testSeagull()
  {
    Picture gull = new Picture ("seagull.jpg");
    gull.mirrorSeagull();
    gull.explore();
  }


  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testMoreRed();
    //testGrayScale();

    //testKeepOnlyBlue();
    //testGrayScale();
    //testFixUnderWater();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRighttoleft();
    testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
      //testnegate();
    //testHorzontalMirror();
    //testBottomtoTop();
    testSeagull();
  }
}