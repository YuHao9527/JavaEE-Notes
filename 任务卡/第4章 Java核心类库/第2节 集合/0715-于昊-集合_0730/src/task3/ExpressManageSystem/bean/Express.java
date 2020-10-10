package task.task3.bean;

/**
 * @ClassName Express
 * @Description 快递数组对象
 * @Author 0715-YuHao
 * @Date 2020/7/28 10:51
 */
public class Express {
    //快递单号
    private String number;
    //快递公司
    private String company;
    //取件码
    private String code;

    public Express() {
    }

    public Express(String number, String company, String code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String  code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Express{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Express express = (Express) o;

        return number != null ? number.equals(express.number) : express.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
