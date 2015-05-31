/**
 * 
 */
package com.bohai.gof.prototype;

/**
 * Class Name		: Prototype<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public class Prototype implements Cloneable {

    /**
     * 
     * Method Name		: clone<br>
     * 
     * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
     * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
     *  
     * @return
     * @throws CloneNotSupportedException
     * @since
     *
     */
    public Object clone() throws CloneNotSupportedException {  
        Prototype proto = (Prototype) super.clone();  
        return proto;  
    } 
}
