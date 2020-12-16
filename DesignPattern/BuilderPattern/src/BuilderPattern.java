public class BuilderPattern {
    /**
     * Builder pattern
     * 복잡한 단계를 거쳐야 생성되는 객체의 구현을 서브 클래스에게 넘겨주는 패턴
     *
     * Computer factory에서 컴퓨터의 청사진을 어떻게 설정하느냐에 따라
     * 동일한 컴퓨터 생성 메서드(make)로 청사진에 맞는 컴퓨터를 만들어내고, 그 컴퓨터 객체를 가져올 수 있다.
     *
     * 비슷한 객체를 조금의 설정을 달리하여 많이 생성해야하는 경우, 유용하게 사용할 수 있을 것 같다.
     * 또한, 많은 변수를 가진 객체를 생성할 때, 편리하고 가독성있게 구현할 수 있다.
     *
     */

    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();

        factory.setBluePrint(new MacBookBluePrint());
        factory.make();

        Computer macBook = factory.getComputer();

        System.out.println(macBook.toString());
        System.out.println(macBook.hashCode());

        factory.setBluePrint(new LgGramBluePrint());
        factory.make();
        Computer lgGram = factory.getComputer();
        System.out.println(lgGram.toString());
        System.out.println(lgGram.hashCode());


        // Use chaining
        Computer macBook2 = ComputerBuilder
                .start()
                .setCpu("i7")
                .setRam("128g")
                .setStorage("ssd 512g")
                .build();

        System.out.println(macBook2.toString());
    }
}
