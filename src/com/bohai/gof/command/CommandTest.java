/**
 * 
 */
package com.bohai.gof.command;

/**
 * Class Name		: CommandTest<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public class CommandTest {

    /**Description	： 这里记述method的说明<br>
     * 
     * liuhb
     * @param args
     * @since
     * 
     */
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
