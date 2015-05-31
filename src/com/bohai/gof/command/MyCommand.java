/**
 * 
 */
package com.bohai.gof.command;

/**
 * Class Name		: MyCommand<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public class MyCommand implements Command {

    private Receiver        receiver;
    
    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    
    /**
     * Method Name		: exec<br>
     * 
     * Description		: 这里记述method说明<br>
     *  
     * @since
     * 
     */
    @Override
    public void exec() {
        receiver.action();
    }
}
