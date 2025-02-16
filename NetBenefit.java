import java.io.*;
import java.util.*; 

public class NetBenefit {
	public static void main(String [] args) {
		BufferedReader reader = null;
		String filename = args[0];//read the name of the file
        String line;
        int p,a,pq,aq,i;//p = number of shares a = price of shares pq = number of the oldest shares in the queue aq = price of the oldest shares in the queue 
        int pqall = 0;//number of all the shares in the queue
        int prof = 0;//profit
        String s = "" ;//use it to read the numbers
        IntQueueImpl<Integer> stocks = new IntQueueImpl<>();
        try {
        	reader = new BufferedReader(new FileReader(new File(filename)));
			line  = reader.readLine();//read the first lines
			if(line.trim().startsWith("sell")) {//if the file starts with sell
				System.out.println("You are trying to sell before buyig!");//print an error message and continue with the next line
				line = reader.readLine();//read the next line
			}
			while (line != null) {
				line = line.replaceAll("\\s", "");//remove all the spaces
				if (line.trim().startsWith("buy")) {//if there is buy
					i = 3;//overcome buy
					while (!(String.valueOf(line.charAt(i)).equals("p"))) {//until you find the first letter o price
						s += String.valueOf(line.charAt(i));//read the number of shares 
						i++;//next char
					}
					p = Integer.parseInt(s);//convert String to Integer
					stocks.put(p);//put the number of shares in the queue
					pqall+=p;//increase the number of all shares
					s = "" ;
					i+=5;
					while (i<line.length()) {//until you find the end of the line 
						s += String.valueOf(line.charAt(i));//read the price of the shares
						i++;
					}
					a = Integer.parseInt(s);
					stocks.put(a);//put the price of shares in the queue
					s = "" ;
				}else if(line.trim().startsWith("sell")) {//if there is sell
					i = 4;//overcome sell
					while (!(String.valueOf(line.charAt(i)).equals("p"))) {//until you find the first letter o price
						s += String.valueOf(line.charAt(i));//read the number of shares
						i++;
					}
					p = Integer.parseInt(s);
					s = "" ;
					i+=5;
					while (i<line.length()) {//until you find the end of the line
						s += String.valueOf(line.charAt(i));//read the price of the shares
						i++;
					}
					a = Integer.parseInt(s);
					s = "" ;
					
					if (pqall>=p) {//if all the shares are more than these we want to sell
						while (p>0) {
	
							pq = stocks.get();//take the oldest shares
							
							
							aq = stocks.get();//take the price of the oldest shares
							
							
							
							
							
							if (pqall==pq) {//if all the shares we have are in one node
								prof += p*(a-aq);//calculate the profit
								pqall -= p;//decrease the number of all shares
								p = 0;//make zero the shares we have to sell
								stocks.put(pqall);//put back the shares which left
								stocks.put(aq);//put back the price of these shares
							}else {
								prof += pq*(a-aq);
								pqall -= pq;
								p -= pq;//remove from the shares we have to sell,these which we sold
							}
							
						}
					}else if (pqall<p) {//if all the shares are  less than these we want to sell
						System.out.println("You are trying to sell more than you have!");//print error message and continue with the next line
					}
				}
				line = reader.readLine();//read next line
			}
			reader.close();
			if (prof>=0) {//print profit or damage
				System.out.println("The profit is: "+prof);
			}else {
				System.out.println("The damage is: "+prof);
			}
        }
        catch (IOException e) {//exception on reading file
            System.out.println	("Error reading line ...");
		}
	}
}
	