import helper.ATM;
import helper.ATMDatabase;
import helper.ATM_Machine;

class Main {
    public static void main(String[] args) {
        ATMDatabase database = new ATMDatabase();
        ATM atm = new ATM(database);

        ATM_Machine frame = new ATM_Machine(atm);
        frame.setVisible(true);
    }
}