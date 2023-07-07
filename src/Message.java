import java.io.*;

/**
 * @author berkesavasci
 * 28.06.23
 * project: SocketUebung
 */
public class Message implements Runnable{
    private final DataInputStream dis;
    private final DataOutputStream dos;
    public Message(InputStream is, OutputStream os){
        this.dis = new DataInputStream(is);
        this.dos = new DataOutputStream(os);
    }

    @Override
    public void run() {
        Serializer s = new Serializer();
        String name = "Ilkkan Berke Savasci";
        int matrikelNummer = 587653;
        byte b = 42;


        try {
            String message = dis.readUTF();
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Error! Can't read first message");
        }

        GETSTRING_PDU getString = new GETSTRING_PDUimpl(name);
        s.serializeGetStringPDU(getString,dos);
        System.out.println("String sent successfully: " + name);

        try {
            String message = dis.readUTF();
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Error! Can't read second message");
        }
        GETINT_PDU getInt = new GETINT_PDUimpl(matrikelNummer);
        s.serializeGetIntPDU(getInt,dos);
        System.out.println("Integer sent successfully: " + matrikelNummer);

        try {
            String message = dis.readUTF();
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Error! Can't read third message");
        }
        GETBYTE_PDU getBytePdu = new GETBYTE_PDUimpl(b);
        s.serializeGetBytePDU(getBytePdu,dos);
        System.out.println("Byte sent successfully: " + b);
    }
}
