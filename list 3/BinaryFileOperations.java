import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class BinaryFileOperations {
    private String nameOperation;
    private int result;

    public BinaryFileOperations(String nameOperation, int result){
        this.nameOperation = nameOperation;
        this.result = result;
    }

    public void saveData(DataOutputStream stream)
        throws IOException {
        stream.writeUTF(this.nameOperation);
        stream.writeInt(this.result);
        System.out.println("Dodano dane");
    }

    public static String loadData(DataInputStream stream)
        throws IOException {
        String tekst = "";

        while (stream.available() > 0)
            tekst += "Gracz: " + stream.readUTF() + " zdobył: "+Integer.toString(stream.readInt()) + " punktów\n";

        stream.close();
        return tekst;
    }

}
