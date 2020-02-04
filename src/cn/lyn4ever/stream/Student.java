package cn.lyn4ever.stream;

public class Student {
    private String name;
    private int score;
    /*
    性别：使用1代替男，0代替女
     */
    private int sex;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, int sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public Student() {

    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getScore() != student.getScore()) return false;
        if (getSex() != student.getSex()) return false;
        return getName() != null ? getName().equals(student.getName()) : student.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getScore();
        result = 31 * result + getSex();
        return result;
    }
}
