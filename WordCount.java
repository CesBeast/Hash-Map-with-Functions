import java.io.*;
import java.util.*;
import java.util.Map.Entry;

																														//Cesar Garcia


class Wordinfo {  //non-public class
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count+1;
	}
	public void setCount(int count) {
		this.count = count;
	}
int position;
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	private String name;
	 int count=1;
	 ArrayList<Integer> lines = new ArrayList<Integer>();
	 public String toString() {
		    StringBuilder result = new StringBuilder();
		    result.append("Name: "+name);
		    result.append("     ");
		    result.append("Count: "+count);
		    result.append("     ");
		    result.append("Lines: "+lines);

		    return result.toString();
		  }

}//end wordinfo class

	public class WordCount
	{
		//private fields, including  your HashMap variable
		HashMap<String,Object> hmap =new HashMap<String,Object>();
		ArrayList<Object> alpha = new ArrayList<Object>();
		ArrayList<Object> freq = new ArrayList<Object>();
		ArrayList<Object> topten = new ArrayList<Object>();
		ArrayList<Object> printagain = new ArrayList<Object>();
		String filename;
		int numwords=0;
	           public WordCount( String infileName){   
	        	 this.filename =infileName;
	           }
	                       public void start()   {   
	                    	   
	                    	   try {
								Scanner inFile = new Scanner(new File(filename));
						        String line;
						        int lineNum=1;
						        
						        while(inFile.hasNext()) {
						        	line=inFile.nextLine();
						             StringTokenizer t=new StringTokenizer(line);
						             while(t.hasMoreTokens()){
						            	 String w=t.nextToken();
						            	 //put word into hash map
						            	 insertWord(w,lineNum);
						             }
						             lineNum++;
						        }
						       
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.exit(0);
							}
	                       }
	                      public void printHashTableOrder()  {  
	                    	  System.out.println("Printing in Hash Table Order:");
	                    	  System.out.println("  ");
	                    	  System.out.println("Number of unique words: "+numwords);
	                    	  Iterator<Map.Entry<String, Object>> itr = hmap.entrySet().iterator();
	                    	  while( itr.hasNext()) {
	                    	  Entry<String, Object> entry = itr.next(); 
	                    	  Object val = entry.getValue();
	                    	  System.out.println(val.toString());
	                    	  }
	                    	  System.out.println("  ");
	                      }
	                      public void printAlphaOrder() { 
	                    	  System.out.println("  ");
	                    	  System.out.println("Printing in Alphabetical Order:");
	                    	  System.out.println("  ");
	                    	  System.out.println("Number of unique words: "+numwords);
	                    	  Iterator alphaitr = alpha.iterator();
	                    	  Wordinfo first=null ;
							  Wordinfo element=null;
							  int runone=1;
							  int lastone=0;
							  if(alphaitr.hasNext()){
								  first = (Wordinfo) alphaitr.next();
								  runone=1;
							  }
							  while(alpha.isEmpty()!=true){
								  alphaitr = alpha.iterator();
	                          while(alphaitr.hasNext()) {
	                        	  if(runone==0)
	                        		  first = (Wordinfo) alphaitr.next();
	                        	 runone=1;
	                        	  lastone=0;
	                        	  if(alphaitr.hasNext())
	                        		  element = (Wordinfo) alphaitr.next();
	                        	  else
	                        		  lastone=1;//no more objects
	                        	  if(lastone==0){
	                        		  if(first.getName().compareToIgnoreCase(element.getName())>0){
	                        			  first=element; 
	                        			  //runone=0;
	                        		  }
	                        	  }
	                          }
	                          System.out.println(first.toString());
	                          alpha.remove(first);
	                          runone=0;
	                          }
	                      }
	                     public void printFrequencyOrder()  {  
	                    	 System.out.println("  ");
	                    	 System.out.println("Printing in Freq Order:");
	                    	  System.out.println("  ");
	                    	  System.out.println("Number of unique words: "+numwords);
	                    	  Iterator freqitr = freq.iterator();
	                    	  Wordinfo most=null ;
							  Wordinfo value=null;
							  int runone=1;
							  int lastone=0;
							  if(freqitr.hasNext()){
								  most = (Wordinfo) freqitr.next();
								  runone=1;
							  }
							  while(freq.isEmpty()!=true){
								  freqitr = freq.iterator();
	                          while(freqitr.hasNext()) {
	                        	  if(runone==0)
	                        		  most = (Wordinfo) freqitr.next();
	                        	 runone=1;
	                        	  lastone=0;
	                        	  if(freqitr.hasNext())
	                        		  value = (Wordinfo) freqitr.next();
	                        	  else
	                        		  lastone=1;//no more objects
	                        	  if(lastone==0){
	                        		  if(most.lines.size()<value.lines.size()){
	                        			  most=value; }
	                        		  if(most.lines.size()==value.lines.size()){
	                        			  if(most.getName().compareToIgnoreCase(value.getName())>0)
	                        				  most=value;
	                        		  }
	                        	  }
	                          }
	                          System.out.println(most.toString());
	                          freq.remove(most);
	                          runone=0;
	                          }
	                     }
	                     public void printTopTen() {  
	                    	 System.out.println("  ");
	                    	 System.out.println("Printing Top Ten Order:");
	                    	  System.out.println("  ");
	                    	  Wordinfo most=null ;
							  Wordinfo value=null;
							  Wordinfo temp=null;
							  int tencount=0;
							  int runone=1;
							  int lastone=0;
							  Iterator topitr = topten.iterator();
							  if(topitr.hasNext()){
								  most = (Wordinfo) topitr.next();
								  runone=1;
							  }
							  while(topten.isEmpty()!=true&&tencount<10){
								  topitr = topten.iterator();
								  
								  printagain.clear();
	                          while(topitr.hasNext()) {
	                        	  if(runone==0)
	                        		  most = (Wordinfo) topitr.next();
	                        	 runone=1;
	                        	  lastone=0;
	                        	  if(topitr.hasNext())
	                        		  value = (Wordinfo) topitr.next();
	                        	  else
	                        		  lastone=1;//no more objects
	                        	  if(lastone==0){
	                        		  if(most.count<value.count){
	                        			  most=value; }
	                        	  }
	                          }
	                          System.out.println(most.toString());
	                          tencount=fillArray(most,topten,tencount);
	                          if(printagain.isEmpty()!=true){
	                        	  printallarray(printagain);
	                        	  printagain.clear();
	                          }
	                          topten.remove(most);
	                          runone=0;
	                          }
	                     }

	                   
						//private methods 
	                     private int fillArray(Wordinfo most, ArrayList<Object> topten2, int tencountupdate) {
	                    	 Iterator fillitr = topten2.iterator();
	                    	 int match=most.count;
	                    	 for(int i=0;i<topten2.size();i++){
	                    		 Wordinfo checkcount=(Wordinfo) topten2.get(i);
	                    		 int check=checkcount.count;
	                    		 if(match==check){
	                    			 printagain.add(checkcount);
	                    		 	 topten.remove(checkcount);
	                    		 	 topten2.remove(checkcount);
	                    		 	 tencountupdate++;}
	                    	 }
							return tencountupdate;
							
						}
	                     private void printallarray(ArrayList<Object> printMe){
	                    	 Wordinfo print=null;
	                    	 for (int i=1;i<printMe.size();i++){
	                    		  print=(Wordinfo) printMe.get(i);
	                    		  System.out.println(print.toString());
	                    	 }
	                     }
	                     private void insertWord(String name, int number){
	                    	 Wordinfo word=new Wordinfo();
	                    		 if(hmap.containsKey(name)) {
	                    			 word=(Wordinfo) hmap.get(name);
	                    			 word.count++;            			 
	                    			 word.lines.add(number);
	                    		  }
	                    		 else{
	                    			 word.setName(name);
	                    		 	 word.lines.add(number);
	                    			 hmap.put(name, word);	
	                    			 numwords++;
	                    			 alpha.add(word);
	                    			 freq.add(word);
	                    			 topten.add(word);
	                    			 } 
	                    		
	                     }
	           }



