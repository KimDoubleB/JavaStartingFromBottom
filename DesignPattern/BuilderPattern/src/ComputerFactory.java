public class ComputerFactory {
    private BluePrint print;
    public void setBluePrint(BluePrint bluePrintComputer){
        print = bluePrintComputer;
    }

    public void make(){
        print.setCpu();
        print.setRam();
        print.setStorage();
    }

    public Computer getComputer(){
        return print.getComputer();
    }
}
