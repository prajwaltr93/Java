//java programm to guess the movie from the selected movie from file
//udacity oop project GuessTheMovie
//date 19/01/19
import java.util.* ;
import java.io.*;
//import java.math.Random;
public class GuessTheMovie{
  //Create a function to read movie names and Populate the ArrayList
  public static ArrayList<String> ReadMovie(){
    ArrayList<String> movielist = new ArrayList<String>();
    //File moviefile = null;
    Scanner filereader = null;
    try{
      //moviefile =
      filereader = new Scanner(new File("movielist.txt"));
    }
    catch (Exception e){
      System.out.println("file not found !!");
    }

    String line = "";
    while(filereader.hasNextLine()){
        line = filereader.nextLine();
        movielist.add(line);
    }
    return movielist;
  }
  //randomly pick a movie from the ArrayList
  public static String pickamovie(ArrayList<String> givenlist){
    Random rand = new Random();
    int index  = 0;
    index = rand.nextInt(givenlist.size());
    return (givenlist.get(index));
  }
public static void main(String[] args) {
  ArrayList<String> movlist = null;
  String pickedmovie = "";
  int wrong_guess = 0;
  Scanner linereader = new Scanner(System.in);
  movlist= ReadMovie();
  //System.out.println(movlist);
  //pick a movie from pickamovie() function
  pickedmovie = pickamovie(movlist);
  System.out.println("picked movie is :"+pickedmovie);
  //convert the picked movie into "___.."
  StringBuilder temp = new StringBuilder();
  for(char x:pickedmovie.toCharArray())
  {
    temp.append("_");
  }

  String mysterystring = temp.toString();
  char[] mystery_string = mysterystring.toCharArray();
  int previndex;
  int inString = 0;
  String temp_string="";
  //take a infinite while loop
  while (true){
    String b = new String(mystery_string);
    if(pickedmovie.compareTo(b)==0)
    {
      System.out.println("Congo!! you have Guessed the movie Right!!");
      break;
    }
    System.out.println("Movie you are Gueesing : "+b);
    System.out.println("Number of Wrong Guesses : "+Integer.toString(wrong_guess));
    System.out.println("Go ahead..Guess a Char ");
    char line = linereader.nextLine().charAt(0);
    previndex = 0;
    //while(previndex!=(pickedmovie.length()-1))
    while((pickedmovie.indexOf(line))!=-1){
    inString = pickedmovie.indexOf(line,previndex);
    if(inString == -1)
    {

      break;
    }
    else
    {
      mystery_string[inString] = line;
      previndex = inString+1;
      
      /*if(pickedmovie.compareTo(mystery_string.toString())){
        break;
      }*/
    }
  }//end of inner while
    if(previndex==0){
      wrong_guess+=1;
    }
    //copying array to string

  }//end of outer while loop


  }//void main

}//class GuessTheMovie


  //System.out.println(pickedmovie);

  //compare and show correct
