//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.ProductToken;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(
        name = "product_token"
)
public class ProductToken {
    @Id
    @SequenceGenerator(
            name = "token_sequency",
            sequenceName = "token_sequency",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequency"
    )
    private Long id;
    private int num_users;
    private int period;
    private String token;

    public String getTk(String token) {
        return token;
    }

    public ProductToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return this.id;
    }

    public int getNum_users() {
        return this.num_users;
    }

    public int getPeriod() {
        return this.period;
    }

    public String getToken() {
        return this.token;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNum_users(final int num_users) {
        this.num_users = num_users;
    }

    public void setPeriod(final int period) {
        this.period = period;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProductToken)) {
            return false;
        } else {
            ProductToken other = (ProductToken)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getNum_users() != other.getNum_users()) {
                return false;
            } else if (this.getPeriod() != other.getPeriod()) {
                return false;
            } else {
                label40: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label40;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label40;
                    }

                    return false;
                }

                Object this$token = this.getToken();
                Object other$token = other.getToken();
                if (this$token == null) {
                    if (other$token != null) {
                        return false;
                    }
                } else if (!this$token.equals(other$token)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProductToken;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getNum_users();
        result = result * 59 + this.getPeriod();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    public String toString() {
        return "ProductToken(id=" + this.getId() + ", num_users=" + this.getNum_users() + ", period=" + this.getPeriod() + ", token=" + this.getToken() + ")";
    }

    public ProductToken() {
    }
}
