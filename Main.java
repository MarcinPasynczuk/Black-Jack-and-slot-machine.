import main.slot.service.SlotMachineImpl; 

public class Main {
    public static void main(String[] args) {
//        BlackJackServiceImpl blackJackService = new BlackJackServiceImpl();
//        blackJackService.playBlackJack();
 
        SlotMachineImpl slotMachineImpl = new SlotMachineImpl();
        slotMachineImpl.playSlotMachine();
    } 
}
