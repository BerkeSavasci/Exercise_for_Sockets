import java.io.*;

/**
 * @author berkesavasci
 * 29.06.23
 * project: SocketUebung
 */
public class Serializer {

    public void serializeGetStringPDU(GETSTRING_PDU stringPDU, OutputStream os){
        DataOutputStream dos = new DataOutputStream(os);
        try {
            dos.writeUTF(stringPDU.getString());
        } catch (IOException e) {
            System.err.println("Error! Can't send String");
        }
    }

    public void serializeGetIntPDU(GETINT_PDU intPDU, OutputStream os){
        DataOutputStream dos = new DataOutputStream(os);
        try{
            dos.writeInt(intPDU.getInt());
        }catch (IOException e){
            System.err.println("Error! Can't send Integer");
        }
    }

    public void serializeGetBytePDU(GETBYTE_PDU bytePDU, OutputStream os){
        DataOutputStream dos = new DataOutputStream(os);
        try{
            dos.write(bytePDU.getByte());
        }catch (IOException e){
            System.err.println("Error! Can't send Byte");
        }
    }

    public String deserializeGetStringPDU(InputStream is){
        DataInputStream dis = new DataInputStream(is);
        try {
            return dis.readUTF();
        } catch (IOException e) {
            System.err.println("Error! Can't read String");
            return null;
        }
    }

    public int deserializeGetIntPDU(InputStream is){
        DataInputStream dis = new DataInputStream(is);
        try{
            return dis.readInt();
        }catch(IOException e){
            System.err.println("Error! Can't read Integer");
            return -1;
        }
    }

    public byte deserializeGetBytePDU(InputStream is){
        DataInputStream dis = new DataInputStream(is);
        try{
            return dis.readByte();
        }catch(IOException e){
            System.err.println("Error! Can't read Byte");
            return -1;
        }
    }
}
