public abstract class BluePrint {

    protected Computer computer;
    public BluePrint(){
        computer = new Computer("default","default","default");
    }

    abstract void setCpu();
    abstract void setRam();
    abstract void setStorage();

    public Computer getComputer(){
        return computer;
    }
}
