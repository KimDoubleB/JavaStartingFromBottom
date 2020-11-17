public class SystemSpeakerSingleton {
    static private SystemSpeakerSingleton instance; // static method 에서 접근하기 위해 static 설정
    private int volume;

    private SystemSpeakerSingleton(){
        // 인스턴스 생성을 불가능하게 만들기 위해 private constructor 를 사용한다.

        volume = 5; // default volume
    }

    public static SystemSpeakerSingleton getInstance(){
        if(instance == null){
            instance = new SystemSpeakerSingleton();
            System.out.println("새로 생성한 인스턴스 리턴");
        } else{
            System.out.println("이미 생성한 인스턴스 리턴");

        }

        return instance;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
