/**
 * 
 */
package com.bohai.gof.adapter.obj;

/**
 * Class Name		: Adapter<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public class Adapter implements Targetable {
    
    public Source source;
    
    public Adapter(Source source) {
        this.source = source;
    }

    /**
     * Method Name		: monthod1<br>
     * 
     * Description		: 这里记述method说明<br>
     *  
     * @since
     * 
     */
    @Override
    public void method1() {
        source.method1();
    }

    /**
     * Method Name		: monthod2<br>
     * 
     * Description		: 这里记述method说明<br>
     *  
     * @since
     * 
     */
    @Override
    public void method2() {
        System.out.println("this is adapter method");
    }
}
