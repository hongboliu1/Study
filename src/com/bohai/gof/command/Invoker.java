/**
 * 
 */
package com.bohai.gof.command;

/**
 * Class Name		: Invoker<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public class Invoker {
    private Command     command;
    
    public Invoker(Command command) {
        this.command = command;
    }
    
    public void action() {
        command.exec();
    }
}
