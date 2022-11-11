//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.tenantManagement;

import javax.persistence.Embeddable;

@Embeddable
public class TenantBusiness {
    private String business_name;
    private String business_type;
    private String services;
    private String shop_number;

    public TenantBusiness() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TenantBusiness)) {
            return false;
        } else {
            TenantBusiness other = (TenantBusiness)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$business_name = this.getBusiness_name();
                    Object other$business_name = other.getBusiness_name();
                    if (this$business_name == null) {
                        if (other$business_name == null) {
                            break label59;
                        }
                    } else if (this$business_name.equals(other$business_name)) {
                        break label59;
                    }

                    return false;
                }

                Object this$business_type = this.getBusiness_type();
                Object other$business_type = other.getBusiness_type();
                if (this$business_type == null) {
                    if (other$business_type != null) {
                        return false;
                    }
                } else if (!this$business_type.equals(other$business_type)) {
                    return false;
                }

                Object this$services = this.getServices();
                Object other$services = other.getServices();
                if (this$services == null) {
                    if (other$services != null) {
                        return false;
                    }
                } else if (!this$services.equals(other$services)) {
                    return false;
                }

                Object this$shop_number = this.getShop_number();
                Object other$shop_number = other.getShop_number();
                if (this$shop_number == null) {
                    if (other$shop_number != null) {
                        return false;
                    }
                } else if (!this$shop_number.equals(other$shop_number)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TenantBusiness;
    }

    public int hashCode() {
        boolean  PRIME = true;
        int result = 1;
        Object $business_name = this.getBusiness_name();
        result = result * 59 + ($business_name == null ? 43 : $business_name.hashCode());
        Object $business_type = this.getBusiness_type();
        result = result * 59 + ($business_type == null ? 43 : $business_type.hashCode());
        Object $services = this.getServices();
        result = result * 59 + ($services == null ? 43 : $services.hashCode());
        Object $shop_number = this.getShop_number();
        result = result * 59 + ($shop_number == null ? 43 : $shop_number.hashCode());
        return result;
    }

    public String toString() {
        return "TenantBusiness(business_name=" + this.getBusiness_name() + ", business_type=" + this.getBusiness_type() + ", services=" + this.getServices() + ", shop_number=" + this.getShop_number() + ")";
    }

    public String getBusiness_name() {
        return this.business_name;
    }

    public String getBusiness_type() {
        return this.business_type;
    }

    public String getServices() {
        return this.services;
    }

    public String getShop_number() {
        return this.shop_number;
    }

    public void setBusiness_name(final String business_name) {
        this.business_name = business_name;
    }

    public void setBusiness_type(final String business_type) {
        this.business_type = business_type;
    }

    public void setServices(final String services) {
        this.services = services;
    }

    public void setShop_number(final String shop_number) {
        this.shop_number = shop_number;
    }
}
