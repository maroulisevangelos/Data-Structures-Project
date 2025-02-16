import java.io.*;
import java.util.*; 


public class TagMatching{
	public static void main(String[] args) {
		BufferedReader reader = null;
		String filename = args[0];//read the name of the file
        String line,p;//use p to pop a tag
        String word = "";//use this to read the tags
        boolean flag = true;//the matching
        StringStackImpl<String> st = new StringStackImpl<>(); //Stack is implicitly declared as String
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
            line = reader.readLine();//read the first line
            while (line != null) {
            	int i =0;
            	line = line.replaceAll("\\s", "");//remove all the spaces
            	while(i<line.length()) {
            		if (String.valueOf(line.charAt(i)).equals("<")) {//when you find '<'
            			i++;
            			if (!((String.valueOf(line.charAt(i)).equals("/")))){//check if this is an "opening"tag
            				while(!(String.valueOf(line.charAt(i)).equals(">"))) {//read the content and stop when you find '>'
            					word += String.valueOf(line.charAt(i));//read the letters of the tag one-by-one
            					i++;//next char
            				}
            				st.push(word);//push the tag in the stack
            			}else {//else this is a "closing"tag
            				i++;
            				while(!(String.valueOf(line.charAt(i)).equals(">"))) {//read the content and stop when you find '>'
            					word += String.valueOf(line.charAt(i));
            					i++;
            				}
            				if (st.size() >0) {//if the stack is not empty
            					p = st.pop();//take the tag from the top
            				}else {//if the stack is empty
            					p = "";//make p "" so it will have a price for the next if
            				}
            				if (!(word.equals(p))) {//compare p with the content of the "closing tag"
            					flag = false;
            				}
            			}
            			word = "";
            		}
            		i++;
            	}
            	if (flag == false) {
            		break;//if you find a not matching tag stop
            	}
            	line = reader.readLine();//read next line
            }
            reader.close();
            if (st.size()> 0) {//if there is an open tag
        		flag = false;//there is mistake
        	}
            if (flag == false) {//when tags do not match
            	System.out.println("The tags do not match!!!");
            }else {//when tags match 
            	System.out.println("The tags match!!!");
            }
		}
		
		catch (IOException e) {//exception on reading file
            System.out.println	("Error reading line ...");
		}
	}
}