package cn.jho.common.constant;

/**
 * 产品常量类
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-13 22:39
 */
public class ProductConst {

    public enum AttrTypeEnum {

        /** 基础属性 */
        ATTR_TYPE_BASE(1, "BASE", "基础属性"),
        /** 销售属性 */
        ATTR_TYPE_SALE(0, "SALE", "销售属性");

        private final int code;

        private final String name;

        private final String desc;

        AttrTypeEnum(int code, String name, String desc) {
            this.code = code;
            this.name = name;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }

}
