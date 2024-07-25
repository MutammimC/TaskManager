import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorChecking{

    Scanner userInput = new Scanner(System.in);
    public boolean isInteger(String inputValue)
    {

        try
        {
            Integer.parseInt(inputValue);
        }
        catch(NumberFormatException error)
        {
            return false;
        }

        return true;
    }

    public String handleInteger()
    {
        String returnInt;
        do
        {
            System.out.println("Please enter an integer value");
            returnInt = userInput.nextLine();

        } while(!isInteger(returnInt));
        return returnInt;
    }

    public boolean isBool(String inputValue)
    {
        return inputValue.equals("true") || inputValue.equals("false");
    }

    public String handleBool()
    {
        String returnBool;
        do
        {
            System.out.println("Please type true or false");
            returnBool = userInput.nextLine();
        }while(!isBool(returnBool));
        return  returnBool;
    }

}
