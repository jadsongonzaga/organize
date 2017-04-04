
package jadsongonzaga.organize.controller;

/**
 *
 * @author jadson
 */
public class ExceptionController {
    
    public static void tratar(Exception ex, Object obj){
        System.out.println("Objeto ---->>>> "  + obj.toString());
        ex.printStackTrace();
    }
    
    public static void tratar(Exception ex){
        ex.printStackTrace();
    }
    
}
