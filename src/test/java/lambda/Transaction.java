package lambda;

/**
 * @author bvzx
 * @Description: (类职责详细描述, 可空)
 * @ClassName: lambda.Transaction
 * @date 2017/2/20
 * @Copyright (c) 2015-2020 by dfwsgroup.com
 */
public class Transaction {

    private Integer id;

    private Double price;

    private String currency;

    public Transaction(Integer id, Double price, String currency) {
        this.id = id;
        this.price = price;
        this.currency = currency;
    }

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
