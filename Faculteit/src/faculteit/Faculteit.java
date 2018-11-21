
package faculteit;

/**
 *
 * @author Hans
 */
public class Faculteit {


    public static void main(String[] args) {
     
        int n = 10;
        int answer = 1;
        
        while( n != 0){
            
            answer *= n;
            n -= 1;
            
            
        }
        System.out.println(answer);
    }
    
}
