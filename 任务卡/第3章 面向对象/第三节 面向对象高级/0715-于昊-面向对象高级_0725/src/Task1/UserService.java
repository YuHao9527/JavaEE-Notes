package Task1;

/**
 * @ClassName UserService
 * @Description 用户登录服务器
 * @Author 0715-YuHao
 * @Date 2020/7/24 22:19
 */
public class UserService {
    private String username;
    private int password;

    public UserService() {
        // 设置默认用户名和密码
        this("admin", 123);
    }

    public UserService(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserService other = (UserService) obj;
        if (password != other.password)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    /**
     * @Author 0715-YuHao
     * @Description 登录方法
     * @Date 2020/7/25 12:29
     * @Param [username, password] [用户名称 密码]
     * @return void
     */
    public void login(String username, int password) {
        if (this.username.equals(username) && this.password == password) {
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败，用户名称或密码错误！");
        }
    }
}
