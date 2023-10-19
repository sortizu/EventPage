/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package debug;

/**
 *
 * @author sortizu
 */
public class Console {
    public static ConsoleFrame consoleFrame = new ConsoleFrame();
    static {
        consoleFrame.setVisible(true);
    }
    public static void println(Object obj){
        if (!consoleFrame.isDisplayable()){
            consoleFrame = new ConsoleFrame();
            consoleFrame.setVisible(true);
        }
        consoleFrame.setConsoleText(consoleFrame.getConsoleText()+"> "+obj.toString()+"<br>");
    }
}
