public class SingletonPattern {
    /*
     * 객체: 속성과 기능을 갖춘 것
     * 클래스: 속성과 기능을 정의한 것 (설계도)
     * 인스턴스: 속성과 기능을 가진 것 중 실제하는 것
     * => 객체 안에는 클래스와 인스턴스라는 부분집합이 존재한다.
     *
     * Singleton Pattern
     * - 인스턴스를 하나만 생성해야 할 때 사용
     * - 인스턴스 하나만 생성해야할 객체를 위한 패턴
     *
     * 변경이 많은 한 클래스를 여러 클래스에서 의존하여 사용하는 경우
     * - 클래스 내용을 변경할 때마다 여러 클래스에 찾아가 다 변경해주어야 한다.
     *
     */
    public static void main(String[] args) {
        // private 이기 때문에 인스턴스 직접 생성 불가
        // SystemSpeaker speaker = new SystemSpeaker();

        SystemSpeakerSingleton singletonSpeaker1 = SystemSpeakerSingleton.getInstance();
        SystemSpeakerSingleton singletonSpeaker2 = SystemSpeakerSingleton.getInstance();

        // 5, 5
        System.out.println(singletonSpeaker1.getVolume());
        System.out.println(singletonSpeaker2.getVolume());

        singletonSpeaker1.setVolume(100);
        // 100, 100 -> 하나의 인스턴스이기 때문에 하나의 값만 바꿔도 다 바뀜
        System.out.println(singletonSpeaker1.getVolume());
        System.out.println(singletonSpeaker2.getVolume());

        // 새로 인스턴스를 만드는 것 같지만, 기존 만들어져있는 하나의 인스턴스를 할당받는 것.
        SystemSpeakerSingleton singletonSpeaker3 = SystemSpeakerSingleton.getInstance();
        singletonSpeaker3.setVolume(0);
        // 0, 0, 0,
        System.out.println(singletonSpeaker1.getVolume());
        System.out.println(singletonSpeaker2.getVolume());
        System.out.println(singletonSpeaker3.getVolume());


        System.out.println("-------------------");

        // all same
        System.out.println(singletonSpeaker1.hashCode());
        System.out.println(singletonSpeaker2.hashCode());
        System.out.println(singletonSpeaker3.hashCode());

        System.out.println("-------------------");


        // None singleton pattern object
        SystemSpeaker speaker1 = new SystemSpeaker();
        SystemSpeaker speaker2 = new SystemSpeaker();

        // 5, 5
        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());

        speaker1.setVolume(100);
        // 100, 5
        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());

        // different
        System.out.println(speaker1.hashCode());
        System.out.println(speaker2.hashCode());



    }

}
