import lombok.Data;

@Data
public class Sportsman {

    private String name;

    public Sportsman(String name) {
        this.name = name;
    }

//    public Stick getStick(Stick stick){
//        return stick.getStick();
//    }
    public Stick safeStickTransfer(Stick stick){

        return stick;
    }

    public Stick riskyStickTransfer(Stick stick){
        return stick;
    }
}
