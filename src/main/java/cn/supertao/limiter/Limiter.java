package cn.supertao.limiter;

/**
 * @author shidt
 * @date 2021/4/20 14:33
 */
public abstract class Limiter {
    abstract boolean tryAcquire();
}
