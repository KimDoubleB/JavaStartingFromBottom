public class DogAdapter implements Cat {
    private Dog dog;

    public DogAdapter(Dog dog){
        this.dog = dog;
    }

    @Override
    public void mewMew() {
        dog.bowWow();
    }

    @Override
    public void eat() {
        dog.eat();
    }
}
