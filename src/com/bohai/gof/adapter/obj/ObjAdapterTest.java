/**
 * 
 */
package com.bohai.gof.adapter.obj;

/**
 * Class Name		: ObjAdapterTest<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public class ObjAdapterTest {

    /**Description	： 这里记述method的说明<br>
     * 
     * liuhb
     * @param args
     * @since
     * 
     */
    public static void main(String[] args) {
        Source source = new Source();
        Targetable adapter = new Adapter(source);
        adapter.method1();
        adapter.method2();
    }

}
