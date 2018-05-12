package exercise.generics;

class Sauce {

    public String describe() {
        // TODO Auto-generated method stub
        return null;
    }

}

class Cofee extends Sauce {
    private Sauce sauce;

    public Cofee(Sauce sce) {
        this.sauce = sce;
    }

    public Cofee() {
    }

    public String describe() {
        return ((null != sauce ? sauce.describe() : ""));
    }

    public String fullDesc() {
        return describe() + "咖啡";
    }
}


class Milk extends Cofee {
    public Milk(Sauce sce) {
        super(sce);
    }

    public String describe() {
        return super.describe() + "牛奶";
    }
}

class Foam extends Cofee {
    public Foam(Sauce sce) {
        super(sce);
    }

    public String describe() {
        return super.describe() + "泡沫";
    }
}

class Chocolate extends Cofee {
    public Chocolate(Sauce sce) {
        super(sce);
    }

    public String describe() {
        return super.describe() + "巧克力";
    }
}

class Caramel extends Cofee {
    public Caramel(Sauce sce) {
        super(sce);
    }

    public Caramel() {

    }

    public String describe() {
        return super.describe() + "焦糖";
    }
}

public class Exercise38 {
    public static void main(String[] args) {
        Cofee cf = new Cofee(new Milk(new Chocolate(new Foam(new Caramel()))));
        System.out.println(cf.fullDesc());
    }
}
