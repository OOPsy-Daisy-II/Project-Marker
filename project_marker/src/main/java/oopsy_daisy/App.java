package oopsy_daisy;



public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        GeneratePDF generator = new GeneratePDF();

        System.out.println(generator.CreatePDF()); 
        
        

        
    }
}
