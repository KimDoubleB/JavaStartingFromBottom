package connect.helper.example;

import java.util.HashMap;
import java.util.Map;

public class DefaultGameConnectHelper extends AbstGameConnectHelper{

    @Override
    protected Map<String, String> doSecurity(String idPassword) {
        String[] idPasswordSplit = idPassword.split("/");
        if (idPasswordSplit.length != 2)
            throw new Error("encoding id, password data is wrong");

        String id = idPasswordSplit[0].substring(idPasswordSplit[0].indexOf(':') + 1);
        String password = idPasswordSplit[1].substring(idPasswordSplit[0].indexOf(':') + 1);
        if (id.length() < 1 || password.length() < 1)
            throw new Error("There isn't id or password or both");

        HashMap<String, String> idPasswordHashMap = new HashMap<>();
        idPasswordHashMap.put("id", id);
        idPasswordHashMap.put("password", password);
        return idPasswordHashMap;
    }

    @Override
    protected boolean authentication(String id, String password) {
        for (HashMap<String, String> eachIdPassword : super.idPasswordList){
            if (eachIdPassword.get("id").equals(id) &&
                eachIdPassword.get("password").equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected int authorization(String id) {
        for (HashMap<String, String> eachIdPassword : super.idPasswordList){
            if (eachIdPassword.get("id").equals(id)){
                return Integer.parseInt(eachIdPassword.get("role"));
            }
        }
        return 3;
    }

    @Override
    protected String connection(Map<String, String> information) {
        return "USER: " + information.get("id") + "\nCONNECTED !";
    }
}
