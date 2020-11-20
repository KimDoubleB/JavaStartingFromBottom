public class Shape implements Cloneable{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // clone 을 다음과 같이 사용할 수 있다.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
