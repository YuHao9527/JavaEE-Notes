/**
 * @ClassName Tasking
 * @Description 任务3
 * @Author 0715-YuHao
 * @Date 2020/7/22 15:16
 */
public class Task3 {

    public static void main(String[] args) {
        // 创建Employee对象
        Employee employee = new Employee();
        // 使用set方法设置属性
        employee.setName("张三");
        employee.setId(20201212);
        employee.setSalary(3500);
        employee.setSalaryGrowthRate(0.3f);

        // 打印信息 使用get方法获取属性值
        System.out.println("姓名：" + employee.getName());
        System.out.println("id：" + employee.getId());
        System.out.println("工资：" + employee.getSalary());
        System.out.println("工资增长率：" + employee.getSalaryGrowthRate());
        System.out.println("工资增长额：" + employee.salaryIncrease());
        System.out.println("增长后的工资总额：" + employee.totalSalary());
    }
}

/**
 * @ClassName Employee
 * @Description 定义并测试一个代表员工的 Employee 类。它的属性包括“员工姓名”、
 * “员工号码”、“员工基本薪水”、“员工薪水增长率”；他的方法包括“构造方法”、“获取员工姓
 * 名”、“获取员工号码”、“获取员工基本薪水”、“计算薪水增长额”及“计算增长后的工资总额”。
 * @Author 0715-YuHao
 * @Date 2020/7/22 15:17
 */
class Employee {

    // 无参构造方法
    public Employee() {}
    // 全参构造方法，使用IDEA自动生成的构造方法
    public Employee(String name, int id, float salary, float salaryGrowthRate) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.salaryGrowthRate = salaryGrowthRate;
    }

    // 属性： 名字、号码、基本薪水、薪水增长率
    String name;
    int id;
    float salary, salaryGrowthRate;

    /**
     * @Author 0715-YuHao
     * @Description 获取属性name值
     * @Date 2020/7/22 15:24
     * @Param []
     * @return java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * @Author 0715-YuHao
     * @Description 设置属性name的值
     * @Date 2020/7/22 15:25
     * @Param [name]
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @Author 0715-YuHao
     * @Description 获取属性id的值
     * @Date 2020/7/22 15:25
     * @Param []
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * @Author 0715-YuHao
     * @Description 设置属性id的值
     * @Date 2020/7/22 15:26
     * @Param [id]
     * @return void
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @Author 0715-YuHao
     * @Description 获取属性salary的值
     * @Date 2020/7/22 15:28
     * @Param []
     * @return float
     */
    public float getSalary() {
        return salary;
    }

    /**
     * @Author 0715-YuHao
     * @Description 设置属性salary的值
     * @Date 2020/7/22 15:28
     * @Param [salary]
     * @return void
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     * @Author 0715-YuHao
     * @Description 获取属性salaryGrowthRate的值
     * @Date 2020/7/22 15:28
     * @Param []
     * @return float
     */
    public float getSalaryGrowthRate() {
        return salaryGrowthRate;
    }

    /**
     * @Author 0715-YuHao
     * @Description 设置属性salaryGrowthRate的值
     * @Date 2020/7/22 15:29
     * @Param [salaryGrowthRate]
     * @return void
     */
    public void setSalaryGrowthRate(float salaryGrowthRate) {
        this.salaryGrowthRate = salaryGrowthRate;
    }

    /**
     * @Author 0715-YuHao
     * @Description 计算薪水增长额
     * @Date 2020/7/22 15:26
     * @Param []
     * @return float 增长额
     */
    public float salaryIncrease() {
        return salary * salaryGrowthRate;
    }

    /**
     * @Author 0715-YuHao
     * @Description 计算增长后的工资总额
     * @Date 2020/7/22 15:27
     * @Param []
     * @return float 工资总额
     */
    public float totalSalary() {
        return salary * (1 + salaryGrowthRate);
    }
}
