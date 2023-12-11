package Model;

import java.util.Random;

public class IDGeneratorUtil {
	public static int GenerateId(){
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }
}
