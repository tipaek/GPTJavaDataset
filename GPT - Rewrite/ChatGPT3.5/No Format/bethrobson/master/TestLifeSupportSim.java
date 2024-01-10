package chap09;

import java.util.ArrayList;

public class TestLifeSupportSim {
    public static void main(String[] args) {
        ArrayList<SimUnit> simUnits = new ArrayList<>();
        V2Radiator v2 = new V2Radiator(simUnits);
        V3Radiator v3 = new V3Radiator(simUnits);

        for (int z = 0; z < 20; z++) {
            RetentionBot ret = new RetentionBot(simUnits);
        }

        // Calculate and display total power usage
        int totalPower = calculateTotalPower(simUnits);
        System.out.println("Total power: " + totalPower);
    }

    private static int calculateTotalPower(ArrayList<SimUnit> simUnits) {
        int totalPower = 0;
        for (SimUnit simUnit : simUnits) {
            totalPower += simUnit.powerUse();
        }
        return totalPower;
    }
}

class V2Radiator {
    V2Radiator(ArrayList<SimUnit> simUnits) {
        System.out.println("making a v2 radiator");
        for (int x = 0; x < 5; x++) {
            simUnits.add(new SimUnit("V2Radiator"));
        }
    }
}

class V3Radiator extends V2Radiator {
    V3Radiator(ArrayList<SimUnit> simUnits) {
        super(simUnits);
        for (int g = 0; g < 10; g++) {
            simUnits.add(new SimUnit("V3Radiator"));
        }
    }
}

class RetentionBot {
    RetentionBot(ArrayList<SimUnit> simUnits) {
        simUnits.add(new SimUnit("Retention"));
    }
}

class SimUnit {
    private String botType;

    SimUnit(String type) {
        botType = type;
    }

    int powerUse() {
        return "Retention".equals(botType) ? 2 : 4;
    }
}
