public class Client {
    private Weapon clientWeapon;

    public Client(){
        clientWeapon = new Hand();
    }

    public Weapon getClientWeapon() {
        return clientWeapon;
    }

    public void setClientWeapon(Weapon clientWeapon) {
        this.clientWeapon = clientWeapon;
    }

    public void useWeapon(){
        this.clientWeapon.attack();
    }
}
