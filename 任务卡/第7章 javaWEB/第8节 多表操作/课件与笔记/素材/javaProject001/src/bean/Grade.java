package bean;

import java.util.List;

public class Grade {
    private int gradeId;
    private String gname;
    private List<Student> studentList; //数据库中使用外键列保证两表关系，实体类中使用属性保证两表关系

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gname='" + gname + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
