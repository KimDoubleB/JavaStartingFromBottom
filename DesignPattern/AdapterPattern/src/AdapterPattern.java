public class AdapterPattern {
    /**
     * Adapter: 기계, 기구 등을 다목적으로 사용하기 위한 부가기구
     * - 이미 구현되어 있는 것을 Adapter 를 통해 기능을 확장 및 변경시키는 것
     *  -- 인터페이스 호환성 문제로 인해 쓸 수 없는 클래스들을 연결해 사용할 수 있다.
     * - 110V 미국 제품을 우리나라에서 사용할 수 있게 220V로 변환해주는 것을 Adapter 라 할 수 있다.
     */

    public static void main(String[] args) {
        Adapter adapterInstance = new AdapterImplements();
        System.out.println(adapterInstance.twiceOf(10));
        System.out.println(adapterInstance.halfOf(10));
        System.out.println(adapterInstance.halfOf(11));
        System.out.println(adapterInstance.halfOf(12));
    }
}
