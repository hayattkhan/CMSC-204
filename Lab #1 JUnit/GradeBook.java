
import java.util.ArrayList;

public class GradeBook
{
   private double[] scores;
   private int scoresSize;
   private String out = "";
   private int count;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }
   /**
    * 
    * 
    * @return the maximum size of the array 
    */
   public int getScoreSize() {
	   return scores.length;
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      
      double smallest = -99;
      
	  for(int i = 0;i<scores.length;i++) {
		  if((scores[i]>0)&&(smallest==-99.0)) {
			  smallest = scores[i];
		  }
		  else {
			  if(scores[i]<smallest && scores[i]!= 0) {
				  smallest = scores[i];
			  }
			  
		  }
	  }
	  if(smallest == -99) {
		  smallest = 0;
	  }
	  
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   /***
    * returns every score inside list seperated by a space
    */
   public String toString() {
	   
	   for(int i = 0;i<scores.length;i++) {
		   if(scores[i]!=0.0) {
		   out= out+Double.toString(scores[i])+" ";
		   }
	   }
	   return out;
   }
}

