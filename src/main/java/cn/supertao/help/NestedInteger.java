package cn.supertao.help;

import java.util.List;

/**
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485629&idx=1&sn=fc0d0fc2b8618a9b8a575cfa9d5b1c4a&chksm=9bd7f6b5aca07fa33c4fbce0dc439359592ace091814fdcdc0742f336722398090396f0b3668&scene=21#wechat_redirect
 *
 * @author shidt
 * @date 2021/4/3 21:08
 */
public class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    public boolean isInteger() {
        return val == null;
    }

    public Integer getInteger() {
        return val;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}
