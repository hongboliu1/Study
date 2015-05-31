/**
 * 
 */
package com.bohai.gof.singleton;

/**
 * Class Name		: Singleton<br>
 * 
 * Description		: 这里记述class说明<br>
 * 
 * @author liuhb
 * @version $Revision$
 * @see
 *
 */
public final class Singleton {
    private final static Singleton singleton = new Singleton();
    private Singleton(){}
    /**
     * 最简历的单例模式创建方法；在定义常量时就对其进行初始化，
     * 并且使用static关键字。使用同步关键字创建单实例都是不可取的
     * 
     * liuhb
     * @return
     * @since
     *
     */
    public static Singleton getInstance() {
        return singleton;
    }
}
